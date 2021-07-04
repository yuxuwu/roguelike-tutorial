package com.yuxuwu.roguelike;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public class RogueLike extends ApplicationAdapter {
	private final Color backgroundColor = new Color(.99f, .99f, .99f, 1);
	private final short tileSize = 32;

	private Texture characterTile;
	private Entity protagonistEntity;

	private GameInputProcessor gameInputProcessor;

	private SpriteBatch batch;

	@Override
	public void create () {
		characterTile = new Texture(Gdx.files.internal("protagonist.png"));
		protagonistEntity = new Entity();

		gameInputProcessor = new GameInputProcessor();
		Gdx.input.setInputProcessor(gameInputProcessor);

		batch = new SpriteBatch();

		// Register entities
		gameInputProcessor.protagonistEntity = protagonistEntity;
	}

	@Override
	public void render () {
		ScreenUtils.clear(backgroundColor);
		batch.begin();
		batch.draw(characterTile, protagonistEntity.positionX*tileSize, protagonistEntity.positionY*tileSize);
		batch.end();
	}

	@Override
	public void dispose () {
	}
}
