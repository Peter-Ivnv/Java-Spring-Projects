package kz.Ivanov.ManyToOne;

import kz.Ivanov.ManyToOne.model.Car;
import kz.Ivanov.ManyToOne.model.CarRepository;
import kz.Ivanov.ManyToOne.model.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CountryRepository countryRepository;
    @GetMapping(value = "/")
    public String indexPage(Model model){
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("countries", countryRepository.findAll());
        return "index";
    }
    @PostMapping (value = "add-car")
    public String addCar(Car car){
        carRepository.save(car);
        return "redirect:/";
    }
}
