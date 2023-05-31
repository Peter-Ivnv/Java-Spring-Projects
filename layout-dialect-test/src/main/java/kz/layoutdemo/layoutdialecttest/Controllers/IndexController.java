package kz.layoutdemo.layoutdialecttest.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {

    @GetMapping(value = "/")
    public String openHome(Model model){
        return "index";
    }
    @GetMapping(value = "/add-task")
    public String indexPage(Model model) {
        return "add-task";
    }
}
