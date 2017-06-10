package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Luís on 02/06/2017.
 */

public class DarkBall extends Enemy {
    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;
    private boolean setToDestroy;
    private boolean destroyed;
    public float height;
    private MageBoss mageBoss;

    /**
     * DarkBall constructor
     * @param screen
     * @param x
     * @param y
     * @param distance
     * @param height
     */
    public DarkBall(PlayScreen screen, float x, float y, float distance, float height) {

        super(screen, x, y, distance);
        this.height = height;
        frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(screen.getDarkballAtlas().findRegion("darkball"), 0, 0, 115, 121));


        walkAnimation = new Animation(0.1f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 115/2 / MyGdxGame.PPM, 121/2/MyGdxGame.PPM);
        setToDestroy=false;
        destroyed=false;
        this.mageBoss = screen.getMageBoss();
    }

    /**
     * DarkBall update constructor
     * @param dt
     */
    public void update(float dt){
        stateTime += dt;

        if(setToDestroy && !destroyed){
            world.destroyBody((b2body));
            destroyed=true;
        } else if(!destroyed) {

            b2body.setGravityScale(0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) walkAnimation.getKeyFrame(stateTime, true));
        }
    }


    /**
     * Checks if the dark ball is destroyed
     * @return destroyed boolean
     */
    public boolean getDestroyed(){
        return destroyed;
    }

    /**
     * Defines the dark ball body
     */
    @Override
    protected void defineEnemy() {
        BodyDef bdef  = new BodyDef();
        bdef.position.set(distance/MyGdxGame.PPM , 150/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        //b2body.isBullet();

        FixtureDef fdef1 = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(25/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.DARKBALL_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.SAMURAI_BIT | MyGdxGame.BULLET_BIT;

        fdef1.shape = shape;
        b2body.createFixture(fdef1).setUserData(this);
    }

    /**
     * If the dark ball hits something gets set to be destroyed
     */
    @Override
    public void hit() {

            setToDestroy = true;

    }


}
