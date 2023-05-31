package kz.bitlab.FoodShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(value = "/add-order")
    public String openAddOrder() {
        return "add-order";
    }

    @PostMapping(value = "/add-order")
    public String addOrder(@RequestParam(name = "user-name") String fullName,
                           @RequestParam(name = "food") String food,
                           @RequestParam(name = "food-amount") int amount,
                           @RequestParam(name = "address") String address) {
        String redirect = "/order/add-order?error";
        Order order = new Order();
        order.setUserName(fullName);
        String[] words = food.split(" ");
        order.setFoodName(words[0]);
        order.setPrice(Integer.parseInt(words[1]));
        order.setAmount(amount);
        order.setAddress(address);
        order.setLinkToImage(words[2]);
        if (orderRepository.save(order) != null) {
            redirect = "/order/home";
        }
        return "redirect:" + redirect;
    }
    @GetMapping(value = "/home")
    public String openHome(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "home";
    }
}
