package com.github.elic0de.zombieEscape.state;

import com.github.elic0de.zombieEscape.countdown.CountdownTask;
import com.github.elic0de.zombieEscape.minigame.ZombieEscapeMinigame;
import org.bukkit.plugin.java.JavaPlugin;

public class CountdownState extends GameState {
    private CountdownTask countdownTask;

    public CountdownState(ZombieEscapeMinigame game, JavaPlugin plugin) {
        super(game, plugin);
    }

    @Override
    public void enter() {
        // カウントダウン処理開始
        countdownTask = new CountdownTask(plugin, 10, () -> {
            // カウントダウン終了後、ゲーム進行状態へ
            game.getStateManager().setState(new InGameState(game, plugin));
        });
        countdownTask.start();
    }

    @Override
    public void execute() {
        // カウントダウン中は処理不要
    }

    @Override
    public void exit() {
        if (countdownTask != null) {
            countdownTask.cancel();
        }
    }
}
