package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.screens.PlayScreen;

import java.util.Random;

/**
 * Created by Luís on 16/05/2017.
 */

public abstract class Enemy extends Sprite{

    protected World world;
    protected PlayScreen screen;
    public Body b2body;
    public Vector2 velocity;
    public float distance;
    public Vector2 counterVelocity;
    public Vector2 batVelocity, batCounterVelocity;


    public Enemy(PlayScreen screen, float x, float y, float distance){
      this.world = screen.getWorld();
      this.screen = screen;
      this.distance = distance;
      setPosition(x,y);
      defineEnemy();
      velocity = new Vector2(-3,0);
      counterVelocity = new Vector2(3,0);
      batVelocity = new Vector2(-2,0);
      batCounterVelocity = new Vector2(2,0);
    }

    protected abstract void defineEnemy();
    public abstract void hit();

    public int randomHeightBetween(int min, int max){
        Random r = new Random();

        return r.nextInt(max-min) + min;
    }


}
