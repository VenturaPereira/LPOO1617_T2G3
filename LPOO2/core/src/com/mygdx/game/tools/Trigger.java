package com.mygdx.game.tools;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;
import com.mygdx.game.sprites.FireBoss;

/**
 * Created by Luís on 28/05/2017.
 */

public class Trigger{

    Body body;
    private float x;
    private float y;
    PlayScreen screen;
    World world;
    private boolean setToDestroy;
    private boolean destroyed;
    float stateTime;
    FireBoss fireBoss;

    public Trigger(PlayScreen screen, float x, float y) {
        this.x = x;
        this.y = y;
        this.screen = screen;
        this.world = screen.getWorld();
        this.fireBoss = screen.getFireBoss();
        setToDestroy = false;
        destroyed = false;
        stateTime = 0;
        defineTriggerBody();
    }

    public void defineTriggerBody(){
        BodyDef bdef  = new BodyDef();
        bdef.position.set(x/ MyGdxGame.PPM, y/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef1 = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(10/MyGdxGame.PPM, 10/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.TRIGGER_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT | MyGdxGame.ENEMY_BIT | MyGdxGame.SAMURAI_BIT | MyGdxGame.FIREBOSS_BIT | MyGdxGame.BULLET_BIT | MyGdxGame.TRIGGER_BIT;

        fdef1.shape = shape;
        body.createFixture(fdef1).setUserData(this);
    }

    public void update(float dt){
        stateTime += dt;
        if(setToDestroy && !destroyed) {
            world.destroyBody(body);
            destroyed = true;
        }
    }

    public void hit(){
        setToDestroy = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void startFireboss(){
        fireBoss.setStage1(true);
    }
}
