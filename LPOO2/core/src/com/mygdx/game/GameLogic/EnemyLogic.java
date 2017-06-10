package com.mygdx.game.GameLogic;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Luís on 06/06/2017.
 */

public class EnemyLogic {

    GameLogic gameLogic;
    Body body;
    float x, y;

    public EnemyLogic(float x, float y){
        this.x = x;
        this.y = y;
        BodyDef bdef  = new BodyDef();
        bdef.position.set(x/MyGdxGame.PPM , y/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = gameLogic.world.createBody(bdef);
        FixtureDef fdef1 = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(25/MyGdxGame.PPM);
    }
}
