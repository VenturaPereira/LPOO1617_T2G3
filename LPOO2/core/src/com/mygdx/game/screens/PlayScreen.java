package com.mygdx.game.screens;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.FireBall;
import com.mygdx.game.sprites.Samurai;
import com.mygdx.game.tools.B2WorldCreator;
import com.mygdx.game.tools.WorldContactListener;

public class PlayScreen implements Screen{
	
	private MyGdxGame game;
	private TextureAtlas samuraiAtlas;
	private TextureAtlas enemiesAtlas;
	private TextureAtlas firebossAtlas;
	private OrthographicCamera gamecam;
	private Viewport gamePort;
	private ArrayList<FireBall> fireBalls = new ArrayList<FireBall>();


	private TmxMapLoader mapLoader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	
	//Box2d variables
	private World world;
	private Box2DDebugRenderer b2dr;
	
	private Samurai character;
	private FireBall fireBall;

	int i = 0;

	public PlayScreen(MyGdxGame game) {
		samuraiAtlas = new TextureAtlas("SamuraiGame.pack");
		enemiesAtlas = new TextureAtlas("Enemies.pack");
		this.game = game;
		gamecam = new OrthographicCamera();
		gamePort = new FitViewport(1200/ MyGdxGame.PPM, 800/MyGdxGame.PPM,gamecam);
		mapLoader = new TmxMapLoader();
		map = mapLoader.load("first_level_background.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1/MyGdxGame.PPM);
		
		gamecam.position.set(gamePort.getWorldWidth()/4, gamePort.getWorldHeight()/2, 0);
		
		world = new World(new Vector2(0,-10), true);
		b2dr = new Box2DDebugRenderer();
		
		new B2WorldCreator(this);
		
		character = new Samurai(world,this);

		//fireBall = new FireBall(this, .32f, 0.32f);
		rainingFire();


		
		world.setContactListener(new WorldContactListener());
		
	}
	
	public TextureAtlas getSamuraiAtlas(){
		return samuraiAtlas;
	}

	public TextureAtlas getEnemiesAtlas(){return enemiesAtlas;};


	public TextureAtlas getFirebossAtlas() {
		return firebossAtlas;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void handleInput(float dt) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
			character.b2body.applyLinearImpulse(new Vector2(0, 4f), character.b2body.getWorldCenter(), true);
		}
	
		else if(Gdx.input.isKeyPressed(Input.Keys.D) && character.b2body.getLinearVelocity().x <= 2){
			character.b2body.applyLinearImpulse(new Vector2(0.1f, 0), character.b2body.getWorldCenter(), true);
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.A) && character.b2body.getLinearVelocity().x >= -2){
			character.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), character.b2body.getWorldCenter(), true);
		}	

			
		
		
			
		/*else if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT))
			character.endsAttack();*/
			
	}
	
	public void update(float dt){
		handleInput(dt);
		
		world.step(1/60f, 6, 2);
		character.update(dt);
		//fireBall.update(dt);
		updateFireballs(dt);
		gamecam.position.x = character.b2body.getPosition().x;
		gamecam.update();
		renderer.setView(gamecam);
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.render();
		
		b2dr.render(world, gamecam.combined);
		
		game.batch.setProjectionMatrix(gamecam.combined);
		game.batch.begin();
		character.draw(game.batch);
		//fireBall.draw(game.batch);
		drawFireballs();
		game.batch.end();
		
		//game.batch.setProjectionMatrix(gamecam.combined);;
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		gamePort.update(width, height);
	}

    public TiledMap getMap() {
        return map;
    }

    public World getWorld(){
        return world;
    }

    @Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		map.dispose();
		renderer.dispose();
		world.dispose();
		b2dr.dispose();
		
	}

	public void rainingFire(){

		int height = 1000;

		for(int i = 0; i < 300; i++) {
			fireBall = new FireBall(this, .32f, 0.32f, height);
			fireBalls.add(fireBall);
			if(height < 100000)
				height += 500;
		}
	}

	public void drawFireballs(){
		for(int i = 0; i < fireBalls.size(); i++) {
			if (!fireBalls.get(i).getDestroyed()) {
				fireBalls.get(i).draw(game.batch);
			}
		}
	}

	public void updateFireballs(float dt){
		for(int i = 0; i < fireBalls.size(); i++) {
			if (!fireBalls.get(i).getDestroyed()) {
				fireBalls.get(i).update(dt);
			}
		}
	}

}
