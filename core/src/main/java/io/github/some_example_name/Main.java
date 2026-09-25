package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Main extends Game {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private character player1;
    @Override
    public void create() {
        setScreen(new FirstScreen());
    }
    {
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

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player1.draw(batch);
        batch.end();
    }







}
