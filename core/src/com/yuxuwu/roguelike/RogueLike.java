package com.yuxuwu.roguelike;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class RogueLike extends ApplicationAdapter {
	final Color backgroundColor = new Color(.99f, .99f, .99f, 1);
	final int tileSize = 32;

	ArrayList<Entity> entities;
	Entity protagonist;
	Map map;

	private GameInputProcessor gameInputProcessor;
	private SpriteBatch batch;

	@Override
	public void create () {
		/// Resources and Devices
		gameInputProcessor = new GameInputProcessor();
		Gdx.input.setInputProcessor(gameInputProcessor);
		batch = new SpriteBatch();

		/// Game objects
		// Entities
		protagonist = new Entity(new Texture(Gdx.files.internal("protagonist.png")));
	    entities = new ArrayList<Entity>();
		entities.add(protagonist);
		entities.add(new Entity(4, 2, new Texture(Gdx.files.internal("protagonist.png"))));
		// Tiles
		map = new Map();


		// Register entities
		gameInputProcessor.protagonistEntity = protagonist;
	}

	@Override
	public void render () {
		ScreenUtils.clear(backgroundColor);
		batch.begin();
			// Draw Tiles
			for(int x = 0; x < map.map.size(); x++) {
				for (int y = 0; y < map.map.get(x).size(); y++)	{
				    Tile tile = map.map.get(x).get(y);
					batch.draw(tile.texture, x*tileSize, y*tileSize);
				}
			}
			// Draw Entities
			for(Entity entity : entities)
				batch.draw(entity.texture, entity.x *tileSize, entity.y *tileSize);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
