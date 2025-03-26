package com.github.elic0de.zombieEscape.state;

import com.github.elic0de.zombieEscape.minigame.ZombieEscapeMinigame;
import org.bukkit.plugin.java.JavaPlugin;

public class InGameState extends GameState {

    public InGameState(ZombieEscapeMinigame game, JavaPlugin plugin) {
        super(game, plugin);
    }

    @Override
    public void enter() {
        game.spawnZombies();
        game.getPlayerSelector().selectZombie();
    }

    @Override
    public void execute() {

    }

    @Override
    public void exit() {
        game.removeSpawnedZombies();
    }
}