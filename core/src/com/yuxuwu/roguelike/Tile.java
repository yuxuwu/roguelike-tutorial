package com.yuxuwu.roguelike;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tile {
    boolean walkable;
    Texture texture;

    Tile(boolean walkable, Texture texture) {
        this.walkable = walkable;
        this.texture = texture;
    }

    static Tile Floor = new Tile(true, new Texture(Gdx.files.internal("floor.png")));
    static Tile Wall = new Tile(false, new Texture(Gdx.files.internal("wall.png")));
}
