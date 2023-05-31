package IvanovPA.goodplaces.Controllers;

import IvanovPA.goodplaces.Entities.Place;
import IvanovPA.goodplaces.Services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class PlaceController {
    @Autowired
    private PlaceService placeService;
    @GetMapping(value="/add-places")
    public String openAddPlace(){
        return "add-places";
    }
    @PostMapping(value="/add-places")
    public String addPlacePost(Model model, @RequestParam(name = "place-name") String name,
                                            @RequestParam(name = "place-area") int area,
                                            @RequestParam(name= "place-country") String country){
        String redirect = "/add-places?error";
        Place place = new Place();
        place.setName(name);
        place.setArea(area);
        place.setCountry(country);
        if(placeService.addPlace(place)!=null){
            redirect = "/home";
        }
        return "redirect:" + redirect;
    }
    @GetMapping(value = "/home")
    public String openHome(Model model){
        List <Place> places = placeService.getAllPlaces();
        model.addAttribute("places", places);
        return "home";
    }
    @GetMapping(value = "/details/{id}")
    public String openDetails(@PathVariable("id") Long id, Model model){
        Place place = placeService.getPlace(id);
        model.addAttribute("place", place);
        return "details";
    }
}
