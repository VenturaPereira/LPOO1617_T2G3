package com.mygdx.game.GameLogic;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.mygdx.game.MyGdxGame;


/**
 * Created by Luís on 06/06/2017.
 */

public class BulletLogic {

    GameLogic gameLogic;
    Body body;



    public BulletLogic() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(gameLogic.getSamuraiLogic().body.getPosition().x, gameLogic.getSamuraiLogic().body.getPosition().y);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = gameLogic.world.createBody(bdef);


        FixtureDef fdef1 = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(15 / MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.BULLET_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT | MyGdxGame.FIREBALL_BIT | MyGdxGame.FIREBOSS_BIT | MyGdxGame.FIREBOSS_HEAD_BIT | MyGdxGame.MAGEBOSS_BIT | MyGdxGame.BAT_BIT | MyGdxGame.DARKBALL_BIT;

        fdef1.shape = shape;
        body.createFixture(fdef1).setUserData(this);
    }
}
