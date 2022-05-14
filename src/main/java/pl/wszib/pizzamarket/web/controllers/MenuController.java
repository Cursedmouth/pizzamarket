package pl.wszib.pizzamarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.wszib.pizzamarket.data.repositories.PizzaRepository;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {

    private final PizzaRepository pizzaRepository;

    public MenuController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping
    public String showPizzaMenu( Model model) {
        List<PizzaEntity> pizzas = pizzaRepository.findAll();
        model.addAttribute("pizzas", pizzas);
        return "menuPage";
    }

    @GetMapping("order/{pizzaId}")
    public String showPizzaOrderPage(
            @PathVariable Long pizzaId,
            @ModelAttribute("orderAddress") OrderAddressModel orderAddress,
            Model model) {
        PizzaEntity pizza = pizzaRepository.findById(pizzaId).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("pizza", pizza);
        return "orderPizzaPage";
    }

}
