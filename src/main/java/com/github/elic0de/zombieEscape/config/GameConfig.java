package com.github.elic0de.zombieEscape.config;

import java.util.List;

/**
 * POJO for game configuration loaded from YAML.
 */
public class GameConfig {
    private List<SpawnPosition> spawnPositions;
    private int maxPlayers;
    private int autoStartPlayers;

    // Inner class to hold spawn position information
    public static class SpawnPosition {
        private String world;
        private double x;
        private double y;
        private double z;

        // Getters and setters
        public String getWorld() {
            return world;
        }
        public void setWorld(String world) {
            this.world = world;
        }
        public double getX() {
            return x;
        }
        public void setX(double x) {
            this.x = x;
        }
        public double getY() {
            return y;
        }
        public void setY(double y) {
            this.y = y;
        }
        public double getZ() {
            return z;
        }
        public void setZ(double z) {
            this.z = z;
        }
    }

    // Getters and setters for GameConfig
    public List<SpawnPosition> getSpawnPositions() {
        return spawnPositions;
    }
    public void setSpawnPositions(List<SpawnPosition> spawnPositions) {
        this.spawnPositions = spawnPositions;
    }
    public int getMaxPlayers() {
        return maxPlayers;
    }
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
    public int getAutoStartPlayers() {
        return autoStartPlayers;
    }
    public void setAutoStartPlayers(int autoStartPlayers) {
        this.autoStartPlayers = autoStartPlayers;
    }
}
