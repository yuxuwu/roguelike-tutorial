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

    public void move(int dx, int dy, Map mapRef) {
        int newX = this.x + dx;
        int newY = this.y + dy;
        if(mapRef.getTileAtXY(newX, newY).walkable) {
            this.x = newX;
            this.y = newY;
        }
    }
}
