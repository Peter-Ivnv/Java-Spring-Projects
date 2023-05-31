package kz.CIS.CIScountries;

import kz.CIS.CIScountries.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Controller
@RequestMapping(value = "/")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private FileService fileService;

    @GetMapping(value = "/add-country")
    public String openAddCountry(Model model) {
        return "add-country";
    }

    @PostMapping(value = "add-country")
    public String addRequest(@RequestParam(name = "country-name") String name,
                             @RequestParam(name = "country-allies") String allies,
                             @RequestParam(name = "country-enemies") String enemies,
                             @RequestParam(name = "country-size") int size,
                             @RequestParam(name = "country-language") String language,
                             @RequestParam(name = "country-commentary") String commentary) {
        String redirect = "/add-country?error";
        Country country = new Country();
        country.setName(name);
        country.setAllies(allies);
        country.setEnemies(enemies);
        country.setCommentary(commentary);
        country.setLanguage(language);
        country.setSize(size);
        if (countryRepository.save(country) != null) {
            redirect = "/home";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value = "/home")
    public String openHome(Model model) {
        List<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        return "home";
    }

    @GetMapping(value = "/details/{id}")
    public String openDetails(Model model, @PathVariable("id") Long id) {
        Country country = countryRepository.findAllById(id);
        model.addAttribute("country", country);
        return "details";
    }

    @PostMapping(value = "/upload-photo")
    public String uploadPhotoPost(@RequestParam(name = "country-photo") MultipartFile file,
                                  @RequestParam(name = "country-id") Long id) {
        fileService.uploadPhoto(file, id);
        return "redirect:home";
    }
}
