package com.github.elic0de.zombieEscape.manager;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BossBarManager {
    private final BossBar bossBar;
    private final List<Player> players = new ArrayList<>();

    public BossBarManager(String title, BarColor color, BarStyle style) {
        this.bossBar = Bukkit.createBossBar(title, color, style);
        this.bossBar.setVisible(true);
    }

    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
            bossBar.addPlayer(player);
        }
    }

    public void removePlayer(Player player) {
        players.remove(player);
        bossBar.removePlayer(player);
    }

    public void removeAllPlayers() {
        for (Player player : players) {
            bossBar.removePlayer(player);
        }
        players.clear();
    }

    public void setTitle(String title) {
        bossBar.setTitle(title);
    }

    public void setProgress(double progress) {
        bossBar.setProgress(progress);
    }

    public void setVisible(boolean visible) {
        bossBar.setVisible(visible);
    }

    public void clear() {
        removeAllPlayers();
        bossBar.setVisible(false);
    }
}