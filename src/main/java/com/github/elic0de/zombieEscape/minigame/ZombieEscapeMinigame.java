package com.github.elic0de.zombieEscape.minigame;

import com.github.elic0de.zombieEscape.selector.PlayerSelector;
import com.github.elic0de.zombieEscape.selector.RandomZombieSelector;
import com.github.elic0de.zombieEscape.state.EndState;
import com.github.elic0de.zombieEscape.state.StateManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Zombie Escape mini-game.
 */
public class ZombieEscapeMinigame extends AbstractMinigame {
    private final Plugin plugin;
    private final List<Player> participants = new ArrayList<>();
    private final List<Zombie> spawnedZombies = new ArrayList<>();
    private StateManager stateManager;
    private EventRegistry eventRegistry;
    private final Location[] zombieSpawnLocations;
    private final GameConfig config;

    public ZombieEscapeMinigame(Plugin plugin, GameConfig config) {
        super("ZombieEscape");
        this.plugin = plugin;
        this.config = config;
        this.stateManager = new StateManager(this, plugin);
        this.eventRegistry = new EventRegistry();

        // Convert config spawn positions into Locations
        List<Location> locList = new ArrayList<>();
        config.getSpawnPositions().forEach(sp -> {
            locList.add(new Location(Bukkit.getWorld(sp.getWorld()), sp.getX(), sp.getY(), sp.getZ()));
        });
        zombieSpawnLocations = locList.toArray(new Location[0]);
    }

    @Override
    public void init() {
        plugin.getLogger().info("Initializing ZombieEscape mini-game...");
        // Set initial state to start screen
        stateManager.setState(new StartScreenState(this, plugin));

        // Create escape area for the game (example coordinates)
        Location areaPoint1 = new Location(Bukkit.getWorlds().get(0), 120, 65, 120);
        Location areaPoint2 = new Location(Bukkit.getWorlds().get(0), 130, 70, 130);

        // Register common event handlers via EventRegistry
        eventRegistry.addEvent(new PlayerJoinEventHandler());
        eventRegistry.addEvent(new EscapeAreaEventHandler(new Area(areaPoint1, areaPoint2)));
        eventRegistry.addEvent(new PlayerDeathEventHandler(this));
        eventRegistry.register(plugin);
    }

    @Override
    public void start() {
        plugin.getLogger().info("Starting ZombieEscape mini-game...");
        spawnZombies();
        Bukkit.broadcastMessage("ZombieEscape game has started!");
    }

    @Override
    public void stop() {
        removeSpawnedZombies();
        plugin.getLogger().info("Stopping ZombieEscape mini-game...");
    }

    // Participant management
    public void addParticipant(Player player) {
        if (!participants.contains(player)) {
            participants.add(player);
        }
    }

    public boolean isParticipant(Player player) {
        return participants.contains(player);
    }

    public void playerDied(Player player) {
        participants.remove(player);
        plugin.getLogger().info(player.getName() + " died. Remaining: " + participants.size());
        checkGameOver();
    }

    private void checkGameOver() {
        if (participants.isEmpty()) {
            Bukkit.broadcastMessage("All participants are dead! Game over!");
            stateManager.setState(new EndState(this, plugin));
        }
    }

    // Zombie spawning methods
    public void spawnZombies() {
        for (Location loc : zombieSpawnLocations) {
            Zombie zombie = (Zombie) loc.getWorld().spawnEntity(loc, org.bukkit.entity.EntityType.ZOMBIE);
            zombie.setCustomName("Chasing Zombie");
            zombie.setCustomNameVisible(true);
            spawnedZombies.add(zombie);
        }
    }

    public void removeSpawnedZombies() {
        for (Zombie zombie : spawnedZombies) {
            if (!zombie.isDead()) {
                zombie.remove();
            }
        }
        spawnedZombies.clear();
    }

    public StateManager getStateManager() {
        return stateManager;
    }
}