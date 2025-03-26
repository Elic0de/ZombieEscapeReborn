package com.github.elic0de.zombieEscape.minigame;

public interface Minigame {
    /**
     * 初期化処理。リソースの確保やイベント登録など。
     */
    void init();

    /**
     * ゲーム開始処理。
     */
    void start();

    /**
     * ゲーム停止処理。
     */
    void stop();

    /**
     * ゲーム名を返す。
     */
    String getName();
}