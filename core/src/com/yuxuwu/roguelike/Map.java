package com.yuxuwu.roguelike;

import java.util.ArrayList;

public class Map {
    ArrayList<ArrayList<Tile>> map;

    Map() {
        map = new ArrayList<>();

        for (int x = 0; x < 25; x++) {
            map.add(new ArrayList<Tile>());
            for (int y = 0; y < 12; y++) {
                map.get(x).add(Tile.Floor);
            }
        }

        map.get(3).set(4, Tile.Wall);
        map.get(3).set(5, Tile.Wall);
        map.get(3).set(6, Tile.Wall);
    }
}
