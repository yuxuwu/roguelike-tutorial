package com.yuxuwu.roguelike;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class GameInputProcessor implements InputProcessor {
    public Entity protagonistEntity;

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.L:
                protagonistEntity.positionX++;
                break;
            case Input.Keys.H:
                protagonistEntity.positionX--;
                break;
            case Input.Keys.J:
                protagonistEntity.positionY--;
                break;
            case Input.Keys.K:
                protagonistEntity.positionY++;
                break;
        }
        return false;
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
