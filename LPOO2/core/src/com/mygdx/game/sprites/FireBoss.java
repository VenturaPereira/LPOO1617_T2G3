package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Luís on 26/05/2017.
 */

public class FireBoss extends Boss{

    PlayScreen screen;
    Body body;
    private Array<TextureRegion> frames;
    private Animation idleAnimation;
    private Animation runningAnimation;
    private float stateTime;
    private Vector2 velocity;
    private boolean stage1;

    public FireBoss(PlayScreen screen){
        super(screen);
        frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 2, 64, 42, 53));
        frames.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 43, 64, 40, 53));
        idleAnimation = new Animation(0.8f, frames);
        frames.clear();

        frames.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 0, 287, 50, 48));
        frames.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 47, 287, 54, 48));
        frames.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 105, 287, 55, 52));
        runningAnimation = new Animation(0.2f, frames);

        stateTime = 0;
        setBounds(0, 0, 252/MyGdxGame.PPM, 300/MyGdxGame.PPM);

        velocity = new Vector2(-4,0);
        stage1 = false;


    }

    public void update(float dt){
        stateTime += dt;
        setPosition(body.getPosition().x - getWidth()/1.7f, body.getPosition().y-getHeight()/2.1f);
        setRegion((TextureRegion) idleAnimation.getKeyFrame(stateTime, true));
        if(stage1) {
            body.setLinearVelocity(velocity);
            setRegion((TextureRegion) runningAnimation.getKeyFrame(stateTime, true));
        }
    }

    @Override
    protected void defineBoss() {
        BodyDef bdef  = new BodyDef();
        bdef.position.set(2300/ MyGdxGame.PPM, 150/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef1 = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(70/MyGdxGame.PPM, 100/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.FIREBOSS_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT | MyGdxGame.SAMURAI_BIT | MyGdxGame.FIREBOSS_BIT | MyGdxGame.BULLET_BIT;

        fdef1.shape = shape;
        body.createFixture(fdef1).setUserData(this);
    }

    public void reverseVelocity(){
        if(stage1) {
            velocity.x = -velocity.x;
            for(int i = 0; i < frames.size; i++){
                frames.get(i).flip(true, false);
            }
        }
    }

    public void setStage1(boolean stage1) {
        this.stage1 = stage1;
    }
}
