package com.github.elic0de.zombieEscape.minigame;

public abstract class AbstractMinigame implements Minigame {
    protected String name;

    public AbstractMinigame(String name) {
        this.name = name;
    }

    @Override
    public void init() {
        // 共通の初期化処理（ログ出力、リソース確保など）
    }

    @Override
    public void start() {
        // 共通の開始処理（タイマー開始など）
    }

    @Override
    public void stop() {
        // 共通の停止処理（タイマー停止、リソース解放など）
    }

    @Override
    public String getName() {
        return name;
    }
}