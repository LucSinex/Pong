package com.pong.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Pong extends ApplicationAdapter {
	private OrthographicCamera camera;
    SpriteBatch batch;
	Texture ship;
    Texture ball;
    Vector3 touchPos;

    float screen_Width = 480;
    float screen_Height = 600;

    boolean close_to_targetPos;

    private Rectangle playerShip;
    private Rectangle computerShip;
	
	@Override
	public void create () {
        touchPos = new Vector3();

		batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 600);
		ship = new Texture("ship.png");
        ball = new Texture("ship.png");

        playerShip = new Rectangle(screen_Width / 2 - 64 / 2, 40, 64, 20);
        computerShip = new Rectangle(screen_Width / 2 - 64 / 2, screen_Height - 40, 64, 20);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(ship, playerShip.x, playerShip.y);
        batch.draw(ship, computerShip.x, computerShip.y);
        batch.end();

        if(Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            //playerShip.x = touchPos.x - 64 / 2;
        }

        close_to_targetPos = Math.abs(playerShip.x + 64 / 2 - touchPos.x) < 5;
        if (playerShip.x < touchPos.x && !close_to_targetPos) {
            playerShip.x += 200 * Gdx.graphics.getDeltaTime();
        }
        else if (playerShip.x > touchPos.x && !close_to_targetPos){
            playerShip.x -= 200 * Gdx.graphics.getDeltaTime();
        }


	}
}
