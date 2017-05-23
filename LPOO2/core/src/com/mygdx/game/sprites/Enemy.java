package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Luís on 16/05/2017.
 */

public abstract class Enemy extends Sprite{

    protected World world;
    protected PlayScreen screen;
    public Body b2body;
    public Vector2 velocity;
    public int distance;

    public Enemy(PlayScreen screen, float x, float y, int distance){
      this.world = screen.getWorld();
      this.screen = screen;
      this.distance = distance;
      setPosition(x,y);
        defineEnemy();
      velocity = new Vector2(-3,.1f);
    }

    protected abstract void defineEnemy();


}
