package com.mygdx.game.GameLogic;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Luís on 06/06/2017.
 */


public class SamuraiLogic {
    GameLogic gameLogic;
    Body body;
    float x, y;
    private boolean alive;

    public SamuraiLogic(float x, float y){
        BodyDef bdef  = new BodyDef();
        bdef.position.set(x, y);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = gameLogic.world.createBody(bdef);

        FixtureDef fdef1 = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(20/MyGdxGame.PPM, 60/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.SAMURAI_BIT;
        fdef1.filter.maskBits = MyGdxGame.SAMURAI_BIT | MyGdxGame.GROUND_BIT | MyGdxGame.FIREBALL_BIT| MyGdxGame.WALL_BIT | MyGdxGame.FIREBOSS_BIT | MyGdxGame.TRIGGER_BIT | MyGdxGame.FIREBOSS_HEAD_BIT | MyGdxGame.BAT_BIT | MyGdxGame.DARKBALL_BIT | MyGdxGame.ITEM_BIT;

        fdef1.shape = shape;
        body.createFixture(fdef1).setUserData(this);
        alive = true;
    }

    public Body getBody() {
        return body;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isAlive() {
        return alive;
    }
}
