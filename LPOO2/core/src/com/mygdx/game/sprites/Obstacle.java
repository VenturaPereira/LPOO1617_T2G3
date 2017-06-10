package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Luís on 07/06/2017.
 */

public class Obstacle extends Sprite{
    public Body body;
    private float x;
    private float y;
    PlayScreen screen;
    World world;
    float stateTime;
    private boolean destroyed;

    /**
     * Obstacle constructor
     * @param screen
     * @param x
     * @param y
     */
    public Obstacle(PlayScreen screen, float x, float y){
        super(screen.getObstacleAtlas().findRegion("block_rock"));
        this.screen = screen;
        this.world = screen.getWorld();
        this.x = x;
        this.y = y;
        stateTime = 0;
        setBounds(getX(), getY(), 58 / MyGdxGame.PPM, 73/MyGdxGame.PPM);
        setRegion(new TextureRegion(getTexture(), 2, 6, 173, 218));
        defineBody();

    }

    /**
     * Obstacle update method
     * @param dt
     */
    public void update(float dt){
        stateTime += dt;
        if(screen.getFireBoss().isDefeated() && !destroyed) {
            world.destroyBody(body);
            destroyed = true;
        }
        else if(!destroyed){
            setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2.3f);
        }
    }

    /**
     * Defines the body of the obstacle
     */
    public void defineBody(){
        BodyDef bdef  = new BodyDef();
        bdef.position.set(x/ MyGdxGame.PPM, y/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.StaticBody;
        body = world.createBody(bdef);

        FixtureDef fdef1 = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(20/MyGdxGame.PPM, 20/MyGdxGame.PPM);
        fdef1.filter.categoryBits = MyGdxGame.OBSTACLE_BIT;
        fdef1.filter.maskBits = MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT |MyGdxGame.SAMURAI_BIT;

        fdef1.shape = shape;
        fdef1.friction = 1.0f;
        fdef1.density = 0.9f;
        body.createFixture(fdef1).setUserData(this);
    }

    /**
     * Checks if the obstacle is destroyed
     * @return destroyed boolean
     */
    public boolean isDestroyed() {
        return destroyed;
    }
}
