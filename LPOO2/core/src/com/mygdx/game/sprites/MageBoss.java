package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Luís on 31/05/2017.
 */



public class MageBoss extends Boss {

    public Body body;
    private Array<TextureRegion> frames, frames2;
    private TextureRegion furious;
    private Animation idleAnimation, attackingAnimation;
    private float stateTime;
    private boolean teleporting;
    private boolean stage1, stage2,stage3, activated;
    private int hp;

    /**
     * Mage Boss constructor
     * @param screen
     */
    public MageBoss(PlayScreen screen){
        super(screen);
        furious = new TextureRegion(screen.getMagebossAtlas().findRegion("Mage Boss"), 7, 184, 73, 77);
        frames = new Array<TextureRegion>();
        for(int i = 0; i < 4; i++) {
            frames.add(new TextureRegion(screen.getMagebossAtlas().findRegion("Mage Boss"), i * 65, 8, 65, 78));
        }
        flip();
        idleAnimation= new Animation(0.2f, frames);

        frames2 = new Array<TextureRegion>();
        for(int i = 0; i < 2; i++)
            frames2.add(new TextureRegion(screen.getMagebossAtlas().findRegion("Mage Boss"), i * 72, 456, 72, 85));

        attackingAnimation = new Animation(0.2f, frames2);

        stateTime = 0;
        setBounds(0, 0, 65*2.3f/ MyGdxGame.PPM, 78*2.3f/MyGdxGame.PPM);
        teleporting = false;
        stage1 = false;
        stage2 = false;
        stage3 = false;
        hp = 500;
    }

    /**
     * MageBoss update method
     * @param dt
     */
    public void update(float dt){
        stateTime += dt;
        float samuraiX = screen.getSamurai().b2body.getPosition().x;
        float samuraiY = screen.getSamurai().b2body.getPosition().y;
        setPosition(body.getPosition().x - getWidth()/2f, body.getPosition().y-getHeight()/2.1f);
        setRegion((TextureRegion) idleAnimation.getKeyFrame(stateTime, true));
        if(teleporting){
            if(samuraiX < body.getPosition().x){
                body.setTransform(samuraiX - 2f, samuraiY, 0);
                flip();
            }
            else if(samuraiX > body.getPosition().x){
                body.setTransform(samuraiX + 2f, samuraiY, 0);
                flip();
            }
            teleporting = false;
        }
        if(hp <= 400 && hp > 150){
            stage1 = false;
            stage2 = true;
            body.setTransform(8000/MyGdxGame.PPM, 500/MyGdxGame.PPM, 0);
            body.setGravityScale(0);
            setRegion(furious);
        }
        if(hp <= 150){
            stage2 = false;
            stage3 = true;
            body.setTransform(8000/MyGdxGame.PPM, 150/MyGdxGame.PPM, 0);
            setRegion((TextureRegion) attackingAnimation.getKeyFrame(stateTime, true));
        }
        if(hp == 0){
            stage3 = false;
            setRegion(furious);
        }

    }


    /**
     * Defines the mage boss body
     */
    @Override
    protected void defineBoss() {
        BodyDef bdef  = new BodyDef();
        bdef.position.set(8000/ MyGdxGame.PPM, 150/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef1 = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(45/MyGdxGame.PPM, 80/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.MAGEBOSS_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT | MyGdxGame.FIREBOSS_BIT | MyGdxGame.BULLET_BIT | MyGdxGame.MAGEBOSS_BIT;

        fdef1.shape = shape;
        body.createFixture(fdef1).setUserData(this);

    }

    /**
     * Sets teleporting to true when the mage boss is in stage 1
     */
    public void teleport(){
       if(stage1)teleporting = true;
    }

    /**
     * Flips the mage boss sprite
     */
    public void flip(){
        for(int i = 0; i < frames.size; i++) {
            frames.get(i).flip(true, false);
        }
    }

    /**
     * Inflicts a certain damage to the mage boss
     * @param damage
     */
    public void damage(int damage) {
        if(activated) {
            if (hp >= damage) {
                hp -= damage;
            } else
                hp = 0;

        }
    }

    /**
     * Sets the mage boss to be in stage 1
     * @param stage1
     */
    public void setStage1(boolean stage1) {
        this.stage1 = stage1;
    }

    /**
     * Checks if the mage boss is in sttage 1
     * @return stage1 boolean
     */
    public boolean isStage1() {
        return stage1;
    }

    /**
     * Checks if the mage boss is in stage 2
     * @return stage2 boolean
     */
    public boolean isStage2() {
        return stage2;
    }

    /**
     * Checks if the mage boss is in stage 3
     * @return stage3 boolean
     */
    public boolean isStage3() {
        return stage3;
    }

    /**
     * Gets the mage boss health points
     * @return boss health points
     */
    public int getBossHp() {
        return hp;
    }

    /**
     * Checks if the mage boss is activated
     * @return activated boolean
     */
    public boolean isActivated() {
        return activated;
    }

    /**
     * Activates and deactivates the mage boss
     * @param activated
     */
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
