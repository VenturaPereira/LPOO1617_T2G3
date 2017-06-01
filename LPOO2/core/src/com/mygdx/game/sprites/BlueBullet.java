package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Luís on 27/05/2017.
 */

public class BlueBullet extends Sprite{

    public Body body;
    private float stateTime;
    World world;
    Samurai samurai;
    private boolean setToDestroy;
    private boolean destroyed;


    public BlueBullet(PlayScreen screen){
        super(screen.getBlueBullet().findRegion("blueBullet"));
        stateTime = 0;
        setBounds(getX(), getY(), 50 / MyGdxGame.PPM, 50/MyGdxGame.PPM);
        this.world = screen.getWorld();
        this.samurai = screen.getSamurai();

        setRegion(new TextureRegion(getTexture(), 1,1, 172, 172));


        defineBullet();



    }


    public void defineBullet() {
        BodyDef bdef  = new BodyDef();
        bdef.position.set(samurai.b2body.getPosition().x + 0.6f, samurai.b2body.getPosition().y);
        bdef.type = BodyDef.BodyType.KinematicBody;
        body = world.createBody(bdef);

        FixtureDef fdef1 = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(15/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.BULLET_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT | MyGdxGame.FIREBALL_BIT | MyGdxGame.BULLET_BIT | MyGdxGame.FIREBOSS_BIT | MyGdxGame.FIREBOSS_HEAD_BIT | MyGdxGame.MAGEBOSS_BIT;

        fdef1.shape = shape;
        body.createFixture(fdef1).setUserData(this);
    }

    public void update(float dt){
        stateTime += dt;
        if(setToDestroy && !destroyed) {
            world.destroyBody(body);
            destroyed = true;
        }
        else if(!destroyed)
            setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);
    }

    /*
    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
    */

    public void hit() {
        setToDestroy = true;
        System.out.print(setToDestroy);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

}
