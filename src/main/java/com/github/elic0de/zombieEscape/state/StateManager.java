package com.github.elic0de.zombieEscape.state;

import org.bukkit.plugin.java.JavaPlugin;

public class StateManager {
    private GameState currentState;
    private final JavaPlugin plugin;

    public StateManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void setState(GameState newState) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        currentState.enter();
    }

    /**
     * 定期的に現在の状態の execute() を呼び出すなど、タイマー処理を仕込むことも可能
     */
    public void update() {
        if (currentState != null) {
            currentState.execute();
        }
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
