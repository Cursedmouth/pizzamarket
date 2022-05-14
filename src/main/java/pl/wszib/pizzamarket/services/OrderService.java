package pl.wszib.pizzamarket.services;


import org.springframework.stereotype.Service;
import pl.wszib.pizzamarket.data.entities.OrderAddressesEntity;
import pl.wszib.pizzamarket.data.entities.OrderEntity;
import pl.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.wszib.pizzamarket.data.repositories.OrderRepository;
import pl.wszib.pizzamarket.data.repositories.PizzaRepository;
import pl.wszib.pizzamarket.web.mappers.OrderAddressMapper;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    public OrderService(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Long pizzaId, OrderAddressModel orderAddressModel) {
        PizzaEntity pizzaEntity = pizzaRepository.findById(pizzaId).orElseThrow(EntityNotFoundException::new);

        OrderAddressesEntity orderAddressesEntity = OrderAddressMapper.toEntity(orderAddressModel);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPizzaName(pizzaEntity.getName());
        orderEntity.setOrderAddress(orderAddressesEntity);

        orderRepository.save(orderEntity);


    }
}
