package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Main extends Game {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private character player1;
    @Override
    public void create() {


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();

        player1 = new character();
        player1.setPosition(200,100);
    }



    public void dispose()
    {
        batch.dispose();
    }
    public void render()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float delta = Gdx.graphics.getDeltaTime();

        // controls
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            player1.moveLeft(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            player1.moveRight(delta);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            player1.jump();
        }

        // update (gravity etc.)
        player1.update(delta);

        // draw
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player1.draw(batch);
        batch.end();
    }







}
