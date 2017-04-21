package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;

public class Samurai extends Sprite{
	public World world;
	public Body b2body;
	private TextureRegion standing;
	
	public Samurai(World world, PlayScreen screen){
		super(screen.getAtlas().findRegion("samurai_walk"));
		this.world = world;
		defineSamurai();
		standing = new TextureRegion(getTexture(), 0, 0, 85, 145);
		setBounds(0,0,85/MyGdxGame.PPM, 145/MyGdxGame.PPM);
		setRegion(standing);
	}
	
	public void update(float dt){
		setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y-getHeight()/8);
	}
	
	public void defineSamurai(){
		BodyDef bdef  = new BodyDef();
		bdef.position.set(50/MyGdxGame.PPM, 150/MyGdxGame.PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(15/MyGdxGame.PPM);
		
		fdef.shape = shape;
		b2body.createFixture(fdef);
		
	}
}
