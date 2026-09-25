package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class character
{
    Rectangle bottom, left, right, top;
    Sprite sprite;
    Texture texture;
    int action;
    float veolocityY;
    //springen verwenden
    float velocityY = 0;
    float gravity = -500;   // zieht runter
    float jumpStrength = 250; // wie stark du springst
    boolean onGround = false;
    //Entry Point
    public character()
    {
        bottom = new Rectangle(0.0f, 0.0f, 128.0f, 128.0f);
        texture = new Texture(Gdx.files.internal("character.png"));
        sprite = new Sprite(texture,0, 0, 128, 128);
        this.setPosition(0, 0);

    }

    public int hits (Rectangle r)
    {
        if (bottom.overlaps(r))
        {
            return 1;
        }
        return -1;
    }
    //colission
    public void action(int type)
    {

    }
    //natural movement
    public void update(float delta)
    {
        // Gravity anwenden
        velocityY += gravity * delta;

        // Position updaten
        setPosition(bottom.x, bottom.y + velocityY * delta);

        // Boden check
        if (bottom.y <= 0)
        {
            bottom.y = 0;
            velocityY = 0;
            onGround = true;
        }
        else
        {
            onGround = false;
        }
    }
    public void setPosition(float x, float y)
    {
        bottom.x = x;
        bottom.y = y;
        sprite.setPosition(x, y);
    }
    public void moveLeft(float delta)
    {
        bottom.x -= (200 * delta);
        sprite.setPosition(bottom.x, bottom.y);
    }
    public void moveRight(float delta)
    {
        bottom.x += (200 * delta);
        sprite.setPosition(bottom.x, bottom.y);
    }
    public void jump()
    {
        if (onGround)
        {
            velocityY = jumpStrength;
            onGround = false;
        }
    }
    public void draw(SpriteBatch batch)
    {
        sprite.draw(batch);
    }
}
