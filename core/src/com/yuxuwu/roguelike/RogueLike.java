package com.yuxuwu.roguelike;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class RogueLike extends ApplicationAdapter {
	final Color backgroundColor = new Color(.99f, .99f, .99f, 1);
	final int tileSize = 32;

	private ArrayList<Entity> entities;
	private Entity protagonist;
	private OrthographicCamera camera;

	private SpriteBatch batch;
	private AssetManager manager;

	OrthographicCamera getCamera() {return camera;}
	Entity getProtagonist() {return protagonist;}

	private OrthogonalTiledMapRenderer tiledMapRenderer;

	@Override
	public void create () {
		/// Resources and Devices
		manager = new AssetManager();
		manager.setLoader(TiledMap.class, new TmxMapLoader());
		manager.load("map.tmx", TiledMap.class);
		manager.finishLoading();
		TiledMap tMap = manager.get("map.tmx", TiledMap.class);

		GameInputProcessor gameInputProcessor = new GameInputProcessor();
		gameInputProcessor.game = this;
		Gdx.input.setInputProcessor(gameInputProcessor);
		batch = new SpriteBatch();
		camera = new OrthographicCamera(800, 400);
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tMap);

		/// Game objects
		// Entities
		protagonist = new Entity(new Texture(Gdx.files.internal("protagonist.png")));
	    entities = new ArrayList<>();
		entities.add(protagonist);
		//npc
		entities.add(new Entity(51, 51, new Texture(Gdx.files.internal("protagonist.png"))));

		// Everyone in their places
		protagonist.x = 0;
		protagonist.y = 0;
	}

	@Override
	public void render () {
		ScreenUtils.clear(backgroundColor);
		camera.position.set(protagonist.x*tileSize + tileSize/2, protagonist.y*tileSize + tileSize/2, 0);
		camera.update();
		tiledMapRenderer.setView(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			tiledMapRenderer.render();
			// Draw Entities
			for(Entity entity : entities)
				batch.draw(entity.texture, entity.x *tileSize, entity.y *tileSize);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		manager.dispose();
	}
}
