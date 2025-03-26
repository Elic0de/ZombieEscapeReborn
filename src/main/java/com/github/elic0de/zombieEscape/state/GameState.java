package com.github.elic0de.zombieEscape.state;

import com.github.elic0de.zombieEscape.minigame.ZombieEscapeMinigame;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class GameState {
    protected final ZombieEscapeMinigame game;
    protected final JavaPlugin plugin;

    public GameState(ZombieEscapeMinigame game, JavaPlugin plugin) {
        this.game = game;
        this.plugin = plugin;
    }

    /**
     * 状態に入ったときの初期化処理
     */
    public abstract void enter();

    /**
     * 状態がアクティブな間に実行する処理（必要に応じてタイマーなどで呼び出す）
     */
    public abstract void execute();

    /**
     * 状態から抜けるときの後処理
     */
    public abstract void exit();
}