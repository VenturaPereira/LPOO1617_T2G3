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

import java.util.ArrayList;

/**
 * Created by Luís on 26/05/2017.
 */

public class FireBoss extends Boss{

    PlayScreen screen;
    public Body body;
    private Array<TextureRegion> frames, frames2;
    private Animation idleAnimation;
    private Animation runningAnimation;
    private Animation attackingAnimation;
    private Animation defeatedAnimation;
    private float stateTime;
    private Vector2 velocity;
    private boolean stage1;
    private boolean stage2;
    private boolean stage3;
    private boolean defeated;
    private int bossHp;
    private boolean activated;
    private float delta;
    private FireBall fireBall1, fireBall2;
    private ArrayList<FireBall> fireBalls;

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

        frames2 = new Array<TextureRegion>();
        frames2.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 0, 349, 43, 60));
        frames2.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 47, 349, 47, 60));
        frames2.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 102, 349, 47, 60));
        attackingAnimation = new Animation(0.3f, frames2);
        frames2.clear();

        frames2.add(new TextureRegion(screen.getFirebossAtlas().findRegion("fire_boss_spritesheet"), 0, 170, 50, 33));
        defeatedAnimation = new Animation(0.2f, frames2);
        stateTime = 0;
        delta = 3f;
        setBounds(0, 0, 252/MyGdxGame.PPM, 300/MyGdxGame.PPM);

        velocity = new Vector2(-4,0);
        stage1 = false;
        stage2 = false;
        activated=false;
        defeated = false;
        bossHp=300;

    }
    public void setActivated(boolean bool){
        this.activated=bool;
    }
    public boolean getActivated(){
        return activated;
    }

    public void update(float dt){
        stateTime += dt;
        delta -= dt;

        setPosition(body.getPosition().x - getWidth()/1.7f, body.getPosition().y-getHeight()/2.1f);
        setRegion((TextureRegion) idleAnimation.getKeyFrame(stateTime, true));
        if(stage1) {
            body.setLinearVelocity(velocity);
            setRegion((TextureRegion) runningAnimation.getKeyFrame(stateTime, true));
        }

        if(bossHp < 200 && bossHp > 100){
            stage1 = false;
            body.setLinearVelocity(new Vector2(velocity.x*1.5f, velocity.y));
            setRegion((TextureRegion) runningAnimation.getKeyFrame(stateTime, true));
            stage2 = true;
        }

        if(bossHp <= 100 && bossHp > 5){
            stage2 = false;
            stage3 = true;
            body.setLinearVelocity(new Vector2(0, 0));
            setRegion((TextureRegion) attackingAnimation.getKeyFrame(stateTime, true));
        }

        if(bossHp == 0){
            stage3 = false;
            body.setLinearVelocity(new Vector2(0, 0));
            setRegion((TextureRegion) defeatedAnimation.getKeyFrame(stateTime, false));
          /*  if(delta <= -2f) {
                world.destroyBody(body);
                defeated = true;
            }*/
        }
    }

    @Override
    protected void defineBoss() {
        BodyDef bdef  = new BodyDef();
        bdef.position.set(2700/ MyGdxGame.PPM, 150/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef1 = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(70/MyGdxGame.PPM, 100/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.FIREBOSS_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT | MyGdxGame.SAMURAI_BIT | MyGdxGame.FIREBOSS_BIT | MyGdxGame.BULLET_BIT | MyGdxGame.FIREBOSS_HEAD_BIT;

        fdef1.shape = shape;
        body.createFixture(fdef1).setUserData(this);

        FixtureDef fdef2 = new FixtureDef();
        PolygonShape shape1 = new PolygonShape();
        Vector2[] vertices = new Vector2[4];
        vertices[0] = new Vector2(70,24).scl(1/MyGdxGame.PPM);
        vertices[1] = new Vector2(-70,24).scl(1/MyGdxGame.PPM);
        vertices[2] = new Vector2(-70,100).scl(1/MyGdxGame.PPM);
        vertices[3] = new Vector2(70,100).scl(1/MyGdxGame.PPM);
        shape1.set(vertices);


        fdef2.filter.categoryBits = MyGdxGame.FIREBOSS_HEAD_BIT;
        fdef2.filter.maskBits = MyGdxGame.WALL_BIT | MyGdxGame.SAMURAI_BIT | MyGdxGame.FIREBOSS_HEAD_BIT | MyGdxGame.BULLET_BIT | MyGdxGame.FIREBOSS_BIT;

        fdef2.shape = shape1;
        body.createFixture(fdef2).setUserData(this);
    }

    public void reverseVelocity(){
        if(stage1 || stage2) {
            velocity.x = -velocity.x;
            for(int i = 0; i < frames.size; i++){
                frames.get(i).flip(true, false);
            }
        }
    }

    public void setStage1(boolean stage1) {
        this.stage1 = stage1;
    }

    public int getBossHp() {
        return bossHp;
    }

    public void damage(int damage) {
        if(stage1 || stage2 || stage3) {
            if (bossHp >= damage) {
                bossHp -= damage;
            } else
                bossHp = 0;
        }
    }

    public boolean isStage1() {
        return stage1;
    }

    public boolean isStage2() {
        return stage2;
    }

    public boolean isStage3(){
        return stage3;
    }

    public boolean isDefeated() {
        return defeated;
    }
}
