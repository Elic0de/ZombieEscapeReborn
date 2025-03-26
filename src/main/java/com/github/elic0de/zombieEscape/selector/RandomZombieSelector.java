package com.github.elic0de.zombieEscape.selector;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class RandomZombieSelector extends PlayerSelector {
    private final Random random = new Random();

    @Override
    public Player selectZombie(List<Player> players) {
        if (players == null || players.isEmpty()) return null;
        return players.get(random.nextInt(players.size()));
    }
}