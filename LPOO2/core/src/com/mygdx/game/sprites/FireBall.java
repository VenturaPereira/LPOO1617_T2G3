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

public class FireBall extends Enemy {


    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;
    private Samurai samurai;
    private float timeToShoot;
    private boolean setToDestroy;
    private boolean destroyed;


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
    public boolean getSetToDestroy(){
        return setToDestroy;
    }

    public boolean getDestroyed(){
        return destroyed;
    }

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
        fdef1.filter.categoryBits = MyGdxGame.ENEMY_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.ENEMY_BIT | MyGdxGame.SAMURAI_BIT | MyGdxGame.BULLET_BIT;

        fdef1.shape = shape;
        b2body.createFixture(fdef1).setUserData(this);
    }

    @Override
    public void hit() {
       setToDestroy = true;
        //System.out.print("riiip");
    }

    public int randomHeightBetween(int min, int max){
        Random r = new Random();

        return r.nextInt(max-min) + min;
    }



}
