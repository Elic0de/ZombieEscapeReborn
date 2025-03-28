package com.github.elic0de.zombieEscape.countdown;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CountdownTask {
    private final JavaPlugin plugin;
    private final int startSeconds;
    private final Runnable onFinish;
    private BukkitRunnable task;

    public CountdownTask(JavaPlugin plugin, int startSeconds, Runnable onFinish) {
        this.plugin = plugin;
        this.startSeconds = startSeconds;
        this.onFinish = onFinish;
    }

    public void start() {
        task = new BukkitRunnable() {
            int seconds = startSeconds;
            @Override
            public void run() {
                if (seconds <= 0) {
                    cancel();
                    onFinish.run();
                } else {
                    // カウントダウン中の処理（例：全体に残り秒数を表示）
                    plugin.getServer().broadcastMessage("残り " + seconds + " 秒");
                    seconds--;
                }
            }
        };
        task.runTaskTimer(plugin, 0L, 20L);
    }

    public void cancel() {
        if (task != null) {
            task.cancel();
        }
    }
}