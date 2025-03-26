package com.github.elic0de.zombieEscape.selector;

import org.bukkit.entity.Player;
import java.util.List;

public abstract class PlayerSelector {
    /**
     * プレイヤーリストからゾンビに選出する処理
     */
    public abstract Player selectZombie(List<Player> players);
}
