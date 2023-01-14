package onao.coffee.example.service.impl;

import onao.coffee.example.data.Coffees;
import onao.coffee.example.data.CoffeesInOrder;
import onao.coffee.example.data.Orders;
import onao.coffee.example.entity.OrderRequest;
import onao.coffee.example.repository.OrdersRepository;
import onao.coffee.example.service.CoffeesService;
import onao.coffee.example.service.CoffeesInOrderService;
import onao.coffee.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CoffeesService coffeesService;

    @Autowired
    private CoffeesInOrderService coffeesInOrderService;

    @Override
    public Optional<Orders> getById(long id) {
        Optional<Orders> orders = ordersRepository.findById(id);

        if (orders.isPresent()) {
            Orders ord = orders.get();
            List<CoffeesInOrder> coffees = coffeesInOrderService.get(ord.getId());
            ord.setCoffees(coffees);
        }

        return orders;
    }

    @Override
    public Optional<List<Orders>> getAllByUserId(long id) {
        return Optional.empty();
    }

    @Override
    public void buy(OrderRequest orderRequest) {
        AtomicReference<Float> totalPrice = new AtomicReference<>((float) 0.0);
        orderRequest.getCoffees().forEach(cof -> {
                            float price = getTotalPrice(cof);
                            totalPrice.getAndSet(price);
                        });

        Orders order = Orders.builder()
                .username(orderRequest.getUsername())
                .paymentMethod(orderRequest.getPaymentMethod())
                .price(totalPrice.get())
                .build();
        order.addCoffees(orderRequest.getCoffees());

        ordersRepository.persist(order);

        coffeesInOrderService.add(order.getCoffees());
    }

    private float getTotalPrice(CoffeesInOrder req) {
        Coffees cof = coffeesService.findById(req.getCoffeeId());
        if (cof.getId() >= 0) return cof.getPrice() * req.getCoffeeCount();
        else return 0;
    }
}