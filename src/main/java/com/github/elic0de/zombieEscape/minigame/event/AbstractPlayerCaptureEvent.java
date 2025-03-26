package com.github.elic0de.zombieEscape.minigame.event;

public abstract class AbstractPlayerCaptureEvent extends AbstractMinigameEvent {

    public AbstractPlayerCaptureEvent(Minigame minigame, Plugin plugin) {
        super(minigame, plugin);
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Zombie && event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            // 抽象メソッドで捕獲時の処理を委譲
            onPlayerCaptured(player, event);
        }
    }

    /**
     * プレイヤーがゾンビに捕まった際の処理を実装するための抽象メソッド
     */
    protected abstract void onPlayerCaptured(Player player, EntityDamageByEntityEvent event);
}
