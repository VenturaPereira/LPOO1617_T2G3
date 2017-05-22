package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Luís on 16/05/2017.
 */

public class FireBall extends Enemy {


    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;
    private Samurai samurai;
    private float timeToShoot;


    public FireBall(PlayScreen screen, float x, float y) {

        super(screen, x, y);
        frames = new Array<TextureRegion>();
        for(int i = 0; i < 5; i++){
            frames.add(new TextureRegion(screen.getEnemiesAtlas().findRegion("flame_sprite"), i*141, 10, 142, 100));
        }
timeToShoot = 10;
        for(int i = 0; i < 5; i++){
            frames.get(i).flip(true, false);
        }

        walkAnimation = new Animation(0.1f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 142 / MyGdxGame.PPM, 100/MyGdxGame.PPM);
    }

    public void update(float dt){
        stateTime += dt;
        b2body.setLinearVelocity(velocity);
        setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y - getHeight()/2);
        setRegion((TextureRegion) walkAnimation.getKeyFrame(stateTime, true));

    }

    @Override
    protected void defineEnemy() {
        BodyDef bdef  = new BodyDef();
        bdef.position.set(1000/MyGdxGame.PPM, 200/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef1 = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(25/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.ENEMY_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT | MyGdxGame.ENEMY_BIT;

        fdef1.shape = shape;
        b2body.createFixture(fdef1);
    }

    public float getTimeToShoot() {
        return timeToShoot;
    }

    public void setTimeToShoot(float timeToShoot) {
        this.timeToShoot = timeToShoot;
    }
}
