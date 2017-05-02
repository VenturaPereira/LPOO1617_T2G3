package com.mygdx.game.sprites;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

public class Samurai extends Sprite{
	public enum State{WALKING, STANDING, ATTACKING};
	public State currentState;
	public State previousState;
	public World world;
	public Body b2body;
	private TextureRegion standing;
	private Animation samuraiWalk;
	private Animation samuraiAttack;
	private float stateTimer;
	private boolean walkingRight;

	
	public Samurai(World world, PlayScreen screen){
		super(screen.getAtlas().findRegion("samurai_walk"));
		this.world = world;
		currentState = State.STANDING;
		previousState = State.STANDING;
		stateTimer = 0;
		walkingRight = true;
		
		Array<TextureRegion> frames = new Array<TextureRegion>();
		frames.add(new TextureRegion(getTexture(), 170, 180, 78, 160));
		frames.add(new TextureRegion(getTexture(), 253, 180, 78, 160));
		frames.add(new TextureRegion(getTexture(), 336, 180, 78, 160));
		frames.add(new TextureRegion(getTexture(), 0, 180, 78, 160));
		samuraiWalk = new Animation(0.1f, frames);
		frames.clear();
		
		frames.add(new TextureRegion(getTexture(), 0, 5, 63, 160));
		frames.add(new TextureRegion(getTexture(), 65, 5, 110, 160));
		frames.add(new TextureRegion(getTexture(), 182, 5, 110, 160));
		frames.add(new TextureRegion(getTexture(), 298, 5, 110, 160));
		samuraiAttack = new Animation(0.1f, frames);
		frames.clear();


		defineSamurai();
		standing = new TextureRegion(getTexture(), 92, 183, 78, 157);
		setBounds(0,0,85/MyGdxGame.PPM, 145/MyGdxGame.PPM);
		setRegion(standing);
	}
	
	public void update(float dt){
		setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y-getHeight()/8);
		setRegion(getFrame(dt));
	}
	
	public TextureRegion getFrame(float dt) {
		currentState = getState();
		
		TextureRegion region;
		switch(currentState){
		case WALKING:
			region = (TextureRegion) samuraiWalk.getKeyFrame(stateTimer, true);
			break;
		case ATTACKING:
			region = (TextureRegion) samuraiAttack.getKeyFrame(stateTimer);
			break;
		case STANDING:
		default:
			region = standing;
			break;
		}
		
		if((b2body.getLinearVelocity().x < 0 || !walkingRight) && !region.isFlipX()){
			region.flip(true, false);
			walkingRight = false;
		}
		else if((b2body.getLinearVelocity().x > 0 || walkingRight) && region.isFlipX()){
			region.flip(true, false);
			walkingRight = true;
		}
		
		stateTimer = currentState == previousState ? stateTimer +dt : 0;
		previousState = currentState;
		return region;
		
	}

	public State getState() {
		if(b2body.getLinearVelocity().x != 0)
			return State.WALKING;
		else if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
			return State.ATTACKING;
		else
			return State.STANDING;
	}

	public void defineSamurai(){
		BodyDef bdef  = new BodyDef();
		bdef.position.set(50/MyGdxGame.PPM, 150/MyGdxGame.PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = world.createBody(bdef);
		
		FixtureDef fdef1 = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(15/MyGdxGame.PPM);
		
		fdef1.shape = shape;
		b2body.createFixture(fdef1);

        FixtureDef fdef2 = new FixtureDef();
        EdgeShape katanaLeft = new EdgeShape();

        katanaLeft.set(new Vector2(48/MyGdxGame.PPM, -20/MyGdxGame.PPM), new Vector2(48/MyGdxGame.PPM, 100/MyGdxGame.PPM));
        fdef2.shape = katanaLeft;
        fdef2.isSensor = true;

        b2body.createFixture(fdef2).setUserData("katana");

        FixtureDef fdef3 = new FixtureDef();
        EdgeShape katanaRight = new EdgeShape();

        katanaRight.set(new Vector2(-48/MyGdxGame.PPM, -20/MyGdxGame.PPM), new Vector2(-48/MyGdxGame.PPM, 100/MyGdxGame.PPM));
        fdef3.shape = katanaRight;
        fdef3.isSensor = true;

        b2body.createFixture(fdef3).setUserData("katana");

	}

	
}