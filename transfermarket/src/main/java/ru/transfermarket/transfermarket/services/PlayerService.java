package ru.transfermarket.transfermarket.services;

import ru.transfermarket.transfermarket.entities.Player;

import java.util.List;

public interface PlayerService {
     Player addPLayer(Player players);
     List<Player> getAllPlayers();
     Player getPlayer(Long id);
     void deletePlayer(Player players);
}
