package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;


/**
 * Created by Luís on 31/05/2017.
 */

public class Bat extends Enemy {

    private float stateTime;
    private Animation flyingAnimation;
    private Array<TextureRegion> frames;


    public Bat(PlayScreen screen, float x, float y, float distance){
        super(screen, x, y, distance);
        frames = new Array<TextureRegion>();
        for(int i = 0; i < 5; i++){
            frames.add(new TextureRegion(screen.getBatAtlas().findRegion("bat sprite"), i*47, 0, 47, 47));
        }

        for(int i = 0; i < 5; i++){
            frames.get(i).flip(true, false);
        }

        flyingAnimation = new Animation(0.2f, frames);
        this.stateTime = 0;
        setBounds(getX(), getY(), 47*2/ MyGdxGame.PPM, 47*2/MyGdxGame.PPM);

    }

    public void update(float dt) {
        stateTime += dt;
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setRegion((TextureRegion) flyingAnimation.getKeyFrame(stateTime, true));
        b2body.setLinearVelocity(velocity);
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
        fdef1.filter.categoryBits = MyGdxGame.BAT_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.BAT_BIT | MyGdxGame.SAMURAI_BIT | MyGdxGame.BULLET_BIT;

        fdef1.shape = shape;
        b2body.createFixture(fdef1).setUserData(this);
    }

    @Override
    public int randomHeightBetween(int min, int max) {
        return super.randomHeightBetween(min, max);
    }

    @Override
    public void hit() {

    }
}
