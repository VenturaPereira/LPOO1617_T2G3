package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Luís on 26/05/2017.
 */

public abstract class Boss extends Sprite{
    protected World world;
    protected PlayScreen screen;


    /**
     * Boss constructor
     * @param screen
     */
    public Boss(PlayScreen screen){
        this.world = screen.getWorld();
        this.screen = screen;
        defineBoss();
    }

    /**
     * Defines the body of the boss
     */
    protected abstract void defineBoss();

    /**
     * Gets the health points of the boss
     * @return boss health points
     */
    public abstract int getBossHp();

    /**
     * Inflicts a certain damage to the boss
     * @param damage
     */
    public abstract void damage(int damage);



}
