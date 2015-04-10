package com.pong.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Pong extends ApplicationAdapter {
	private OrthographicCamera camera;
    SpriteBatch batch;
	Texture ship;
    Texture ball;

    private Rectangle playerShip;
    private Rectangle computerShip;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 600);
		ship = new Texture("badlogic.jpg");
        ball = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(ship, 0, 0);
		batch.end();
	}
}