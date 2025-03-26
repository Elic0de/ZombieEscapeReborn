package com.github.elic0de.zombieEscape.state;

import com.github.elic0de.zombieEscape.minigame.ZombieEscapeMinigame;
import org.bukkit.plugin.java.JavaPlugin;

public class EndState extends GameState {
    public EndState(ZombieEscapeMinigame game, JavaPlugin plugin) {
        super(game, plugin);
    }

    @Override
    public void enter() {
        // 終了画面や結果表示を実施
    }

    @Override
    public void execute() {
        // 終了状態中は基本処理不要。一定時間後にリセットなどの処理が実行されてもよい
    }

    @Override
    public void exit() {
    }
}
