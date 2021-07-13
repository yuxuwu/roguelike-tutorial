package com.yuxuwu.roguelike;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameInputProcessor implements InputProcessor {
    RogueLike game;

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.L:
                game.getProtagonist().move(1, 0, game.getMap());
                break;
            case Input.Keys.H:
                game.getProtagonist().move(-1, 0, game.getMap());
                break;
            case Input.Keys.J:
                game.getProtagonist().move(0, -1, game.getMap());
                break;
            case Input.Keys.K:
                game.getProtagonist().move(0, 1, game.getMap());
                break;
            case Input.Keys.Y:
                game.getProtagonist().move(-1 , 1, game.getMap());
                break;
            case Input.Keys.U:
                game.getProtagonist().move(1, 1, game.getMap());
                break;
            case Input.Keys.B:
                game.getProtagonist().move(-1, -1, game.getMap());
                break;
            case Input.Keys.N:
                game.getProtagonist().move(1, -1, game.getMap());
                break;
            case Input.Keys.Q:
                game.getCamera().zoom -= 0.10;
                break;
            case Input.Keys.E:
                game.getCamera().zoom += 0.10;
                break;
        }
        //camera.zoom = clamp(camera.zoom, 0.1f, 100/camera.viewportWidth);
        return false;
    }
    static public float clamp (float value, float min, float max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
