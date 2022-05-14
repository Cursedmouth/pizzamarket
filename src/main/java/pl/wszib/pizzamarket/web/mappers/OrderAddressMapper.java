package pl.wszib.pizzamarket.web.mappers;

import pl.wszib.pizzamarket.data.entities.OrderAddressesEntity;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;

public class OrderAddressMapper {
    public static OrderAddressesEntity toEntity(OrderAddressModel model) {
        OrderAddressesEntity entity = new OrderAddressesEntity();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setStreet(model.getStreet());
        entity.setPostalCode(model.getPostalCode());
        entity.setCity(model.getCity());
        return entity;
    }
}
