package com.yuxuwu.roguelike;

import com.badlogic.gdx.graphics.Texture;

public class Entity {
    public int x, y;
    public Texture texture;

    Entity (int x, int y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
    }

    Entity (Texture texture) { this(0, 0, texture); }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
