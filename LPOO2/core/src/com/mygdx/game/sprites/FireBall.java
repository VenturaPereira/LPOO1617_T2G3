package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

import java.util.Random;

/**
 * Created by Luís on 16/05/2017.
 */

public class FireBall extends Enemy{

    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;
    private boolean setToDestroy;
    private boolean destroyed;

    /**
     *
     * FireBall constructor
     * @param screen
     * @param x
     * @param y
     * @param distance
     */
    public FireBall(PlayScreen screen, float x, float y, float distance) {

        super(screen, x, y, distance);
        frames = new Array<TextureRegion>();
        for(int i = 0; i < 5; i++){
            frames.add(new TextureRegion(screen.getEnemiesAtlas().findRegion("flame_sprite"), i*141, 10, 142, 100));
        }

        for(int i = 0; i < 5; i++){
            frames.get(i).flip(true, false);
        }

        walkAnimation = new Animation(0.1f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 142 / MyGdxGame.PPM, 100/MyGdxGame.PPM);
        setToDestroy=false;
        destroyed=false;
    }

    /**
     * FireBall update constructor
     * @param dt
     */
    public void update(float dt){
        stateTime += dt;
        if(setToDestroy && !destroyed){
            world.destroyBody((b2body));
            destroyed=true;
        } else if(!destroyed) {
            b2body.setLinearVelocity(velocity);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) walkAnimation.getKeyFrame(stateTime, true));
        }
    }

    /**
     * Checks if the fire ball is destroyed
     * @return - destroyed boolean
     */
    public boolean getDestroyed(){
        return destroyed;
    }

    /**
     * Defines the fire ball body
     */
    @Override
    protected void defineEnemy() {
        BodyDef bdef  = new BodyDef();
        bdef.position.set(distance/MyGdxGame.PPM, randomHeightBetween(50, 500)/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        b2body.isBullet();

        FixtureDef fdef1 = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(25/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.FIREBALL_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.FIREBALL_BIT | MyGdxGame.SAMURAI_BIT | MyGdxGame.BULLET_BIT;

        fdef1.shape = shape;
        b2body.createFixture(fdef1).setUserData(this);
    }

    /**
     * If the fire ball hits something it gets set to be destroyed
     */
    @Override
    public void hit() {
       setToDestroy = true;
    }

    /**
     * Generates a random height between a minimum and a maximum value
     *
     * @param min
     * @param max
     * @return - height between min and max
     */
    @Override
    public int randomHeightBetween(int min, int max){
       return super.randomHeightBetween(min, max);
    }



}
