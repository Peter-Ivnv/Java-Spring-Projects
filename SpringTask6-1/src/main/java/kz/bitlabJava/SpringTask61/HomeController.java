package kz.bitlabJava.SpringTask61;
import kz.bitlabJava.SpringTask61.Entities.AppRequest;
import kz.bitlabJava.SpringTask61.Entities.Courses;
import kz.bitlabJava.SpringTask61.Repositories.AppRequestRepository;
import kz.bitlabJava.SpringTask61.Repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private AppRequestRepository appRequestRepository;
    @Autowired
    private CoursesRepository coursesRepository;
    @GetMapping(value = "/")
    public String indexPage(Model model) {
        model.addAttribute("appRequests", appRequestRepository.findAll());
        model.addAttribute("courses", coursesRepository.findAll());
        return "index";
    }

    @PostMapping (value = "/add-request")
    public String addRequest(AppRequest appRequest){
        appRequestRepository.save(appRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/handled")
    public String openHandled(Model model){
        List<AppRequest> appRequests = appRequestRepository.findAllByHandledIsTrue();
        model.addAttribute("appRequests", appRequests);
        return "redirect:/";
    }
    @GetMapping(value = "/unhandled")
    public String openUnHandled(Model model){
        List<AppRequest> appRequests = appRequestRepository.findAllByHandledIsFalse();
        model.addAttribute("appRequests", appRequests);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String openDetails(Model model, @PathVariable(name = "id") Long id) {
        AppRequest appRequest = appRequestRepository.findById(id).orElse(null);
        model.addAttribute("appRequest", appRequest);
        model.addAttribute("courses", coursesRepository.findAll());
        return "details";
    }

    @PostMapping(value = "/update")
    public String updateAppRequest(@RequestParam(name = "id") Long id,
                               @RequestParam(name = "userName") String userName,
                               @RequestParam(name = "phone") String phone,
                               @RequestParam(name = "commentary") String commentary
                       ) {
        String redirect = "/update?error";
        AppRequest appRequest = appRequestRepository.findById(id).orElse(null);
        appRequest.setUserName(userName);
        appRequest.setPhone(phone);
        appRequest.setCommentary(commentary);
        appRequest.setHandled(true);
        if (appRequestRepository.save(appRequest) != null){
            redirect = "/";
        }
        return "redirect:" + redirect;
    }
    @PostMapping(value = "/delete-request")
    public String deleteRequest(@RequestParam(name = "id") Long id){
        appRequestRepository.deleteById(id);
        return "redirect:/";
    }
}
