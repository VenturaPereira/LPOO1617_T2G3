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



    public Boss(PlayScreen screen){
        this.world = screen.getWorld();
        this.screen = screen;
        defineBoss();
    }

    protected abstract void defineBoss();
    public abstract int getBossHp();
    public abstract void damage(int damage);



}
