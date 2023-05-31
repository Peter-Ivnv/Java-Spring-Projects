package ru.transfermarket.transfermarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.transfermarket.transfermarket.entities.Player;

import java.util.List;

@Controller
@RequestMapping(value = "/player")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(value = "/add-player")
    public String openAddPlayer() {
        return "add-player";
    }

    @PostMapping(value = "/add-player")
    public String addPlayer(
            @RequestParam(name = "player-name") String name,
            @RequestParam(name = "player-surname") String surname,
            @RequestParam(name = "player-age") int age,
            @RequestParam(name = "player-club") String club,
            @RequestParam(name = "player-price") int price) {
        String redirect = "/player/add-player?error";
        Player player = new Player();
        player.setName(name);
        player.setSurname(surname);
        player.setAge(age);
        player.setClub(club);
        player.setPrice(price);
        if (playerRepository.save(player) != null) {
            redirect = "/player/home";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value = "/home")
    public String openHome(Model model) {
        List<Player> players = playerRepository.findAll();
        model.addAttribute("players", players);
        return "home";
    }

    @GetMapping(value = "/home-search")
    public String openHomeSearch(Model model, @RequestParam(name = "search-name") String name,
                                                @RequestParam(name = "search-surname") String surname) {
        List<Player> players = playerRepository.findAllByNameContainsIgnoreCaseOrSurnameContainsIgnoreCase(name, surname);
        model.addAttribute("players", players);
        return "home";
    }

    @GetMapping(value = "/details/{id}")
    public String openDetails(Model model, @PathVariable(name = "id") Long id) {
        Player player = playerRepository.findById(id).orElse(null);
        model.addAttribute("players", player);
        return "details";
    }

    @PostMapping(value = "/update")
    public String updatePlayer(@RequestParam(name = "id") Long id,
                               @RequestParam(name = "player-name") String name,
                               @RequestParam(name = "player-surname") String surname,
                               @RequestParam(name = "player-age") int age,
                               @RequestParam(name = "player-club") String club,
                               @RequestParam(name = "player-price") int price) {
        String redirect = "/player/add-player?error";
        Player player = playerRepository.findById(id).orElse(null);
        player.setName(name);
        player.setSurname(surname);
        player.setAge(age);
        player.setClub(club);
        player.setPrice(price);
        if (playerRepository.save(player) != null) {
            redirect = "/player/home";
        }
        return "redirect:" + redirect;
    }

    @PostMapping(value = "/delete-player")
    public String deletePlayer(@RequestParam(name = "id") Long id) {
        playerRepository.deleteById(id);
        return "redirect:home";
    }
}
