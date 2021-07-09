package com.yuxuwu.roguelike;

import java.util.ArrayList;

public class Map {
    ArrayList<ArrayList<Tile>> map;

    Map() {
        map = new ArrayList<>();

        for (int x = 0; x < 100; x++) {
            map.add(new ArrayList<Tile>());
            for (int y = 0; y < 100; y++) {
                map.get(x).add(Tile.Floor);
            }
        }

        map.get(54).set(54, Tile.Wall);
        map.get(54).set(55, Tile.Wall);
        map.get(54).set(56, Tile.Wall);
    }
}
