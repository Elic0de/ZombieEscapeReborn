package com.github.elic0de.zombieEscape.minigame.event;

import com.github.elic0de.zombieEscape.minigame.Minigame;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractMinigameEvent implements Listener {
    protected final Minigame minigame;
    protected final JavaPlugin plugin;

    public AbstractMinigameEvent(Minigame minigame, JavaPlugin plugin) {
        this.minigame = minigame;
        this.plugin = plugin;
    }

    /**
     * イベントの登録（Spigot のイベントリスナーとして登録）
     */
    public void register() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /**
     * イベント解除などのクリーンアップ処理（必要に応じてオーバーライド）
     */
    public void unregister() {
        // Spigot の場合、明示的な解除は通常行わずサーバ停止時に全リスナが解放される
    }
}