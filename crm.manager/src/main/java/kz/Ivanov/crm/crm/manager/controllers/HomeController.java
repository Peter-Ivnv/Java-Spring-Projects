package kz.Ivanov.crm.crm.manager.controllers;

import kz.Ivanov.crm.crm.manager.entities.Course;
import kz.Ivanov.crm.crm.manager.entities.Operators;
import kz.Ivanov.crm.crm.manager.entities.Request;
import kz.Ivanov.crm.crm.manager.services.CourseService;
import kz.Ivanov.crm.crm.manager.services.OperatorsService;
import kz.Ivanov.crm.crm.manager.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private OperatorsService operatorsService;

    @GetMapping(value = "/")
    public String openHome(Model model) {
        List<Request> requests = requestService.getAllRequests();
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("requests", requests);
        model.addAttribute("courses", courses);
        return "home";
    }

    @GetMapping(value = "/add-request")
    public String openAddRequest(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "add-request";
    }

    @PostMapping(value = "/add-request")
    public String addRequestPost(@RequestParam(name = "fullName") String name,
                                 @RequestParam(name = "phone-number") String phone,
                                 @RequestParam(name = "commentary") String commentary,
                                 @RequestParam(name = "course-id") Long id) {
        String redirect = "/add-request?error";
        Course course = Course.builder()
                .id(id)
                .build();
        Request request = Request.builder()
                .course(course)
                .fullName(name)
                .phone(phone)
                .commentary(commentary)
                .handled(false)
                .build();
        if (requestService.addRequest(request) != null) {
            redirect = "/home";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value = "/add-course")
    public String openAddCourse() {
        return "add-course";
    }

    @PostMapping(value = "/add-course")
    public String addCoursePost(
            @RequestParam(name = "course-name") String name,
            @RequestParam(name = "course-description") String description,
            @RequestParam(name = "course-price") int price) {
        String redirect = "/add-request?error";
        Course course = Course.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
        if (courseService.addCourse(course) != null) {
            redirect = "/home";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value = "/details/{id}")
    public String openDetails(Model model, @PathVariable(name = "id") Long id) {
        Request request = requestService.findRequestById(id);
        model.addAttribute("request", request);
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        List<Operators> operators = operatorsService.getAllOperators();
        model.addAttribute("operators", operators);
        return "details";
    }

    @PostMapping(value = "/operator-assign")
    public String operatorAssignPost(@RequestParam(name = "operators") List<Operators> operators,
                                     @RequestParam(name = "request-id") Long id) {
        String redirect = "/operator-assign?error";
        Request request = requestService.findRequestById(id);
        request.setOperators(operators);

        if (requestService.addRequest(request) != null) {
            redirect = "/";
        }
        return "redirect:" + redirect;
    }
    @PostMapping(value="/operator-delete")
    public String operatorDeletePost(@RequestParam(name="req-operator-id") Long operatorId,
                                     @RequestParam(name="request-id") Long requestId){
        Request request = requestService.findRequestById(requestId);
        int index = -1;
        for(int i = 0; i < request.getOperators().size(); i++ ){
            if(request.getOperators().get(i).getId() == operatorId){
                index = i;
                break;
            }
        }
        request.getOperators().remove(index);
        requestService.addRequest(request);
        return "redirect: details/" + requestId;
    }
//    @GetMapping(value = "/handled")
//    public String openHandled(Model model){
//        List<Request> appRequests = requestService.findAllByHandledIsTrue();
//        model.addAttribute("appRequests", appRequests);
//        return "redirect:/";
//    }
//    @GetMapping(value = "/unhandled")
//    public String openUnHandled(Model model){
//        List<AppRequest> appRequests = appRequestRepository.findAllByHandledIsFalse();
//        model.addAttribute("appRequests", appRequests);
//        return "redirect:/";
//    }
}
