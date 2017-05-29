package com.mygdx.game.screens;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.scenes.Hud;
import com.mygdx.game.sprites.BlueBullet;
import com.mygdx.game.sprites.FireBall;
import com.mygdx.game.sprites.FireBoss;
import com.mygdx.game.sprites.Samurai;
import com.mygdx.game.tools.B2WorldCreator;
import com.mygdx.game.tools.Trigger;
import com.mygdx.game.tools.WorldContactListener;

public class PlayScreen implements Screen{

	private Texture gameOver;
	private SpriteBatch batch;

	private MyGdxGame game;
	private TextureAtlas samuraiAtlas;
	private TextureAtlas enemiesAtlas;
	private TextureAtlas firebossAtlas;
	private TextureAtlas blueBulletAtlas;
	private OrthographicCamera gamecam;
	private Viewport gamePort;

	private Music music;

	private Hud hud;
	private TmxMapLoader mapLoader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;

	//Box2d variables
	private World world;
	private Box2DDebugRenderer b2dr;

	private Samurai character;
	private FireBall fireBall;
	private BlueBullet blueBullet;
	private FireBoss fireBoss;
	private ArrayList<FireBall> fireBalls = new ArrayList<FireBall>();
	private List<BlueBullet> blueBullets = new ArrayList<>();
	private Trigger trigger;

	private float fireDelay;

	public PlayScreen(MyGdxGame game) {
		samuraiAtlas = new TextureAtlas("SamuraiGame.pack");
		enemiesAtlas = new TextureAtlas("Enemies.pack");
		firebossAtlas = new TextureAtlas("FireBoss.pack");
		blueBulletAtlas = new TextureAtlas("BlueBullet.pack");
		this.game = game;
		gamecam = new OrthographicCamera();
		gamePort = new FitViewport(1200/ MyGdxGame.PPM, 800/MyGdxGame.PPM,gamecam);
		gameOver=new Texture(Gdx.files.internal("gameover.png"));
		batch= new SpriteBatch();
		mapLoader = new TmxMapLoader();
		map = mapLoader.load("first_level_background.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1/MyGdxGame.PPM);

		gamecam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);

		world = new World(new Vector2(0,-10), true);
		b2dr = new Box2DDebugRenderer();

		new B2WorldCreator(this);

		character = new Samurai(world,this);
		fireBoss = new FireBoss(this);
		trigger = new Trigger(this, 2300f, 150f);


		hud = new Hud(game.batch, character);
		//fireBall = new FireBall(this, .32f, 0.32f);
		rainingFire();




		world.setContactListener(new WorldContactListener());
		music = MyGdxGame.manager.get("music/final_countdown.ogg",Music.class);
		music.setLooping(true);
		music.play();
	}

	public TextureAtlas getSamuraiAtlas(){
		return samuraiAtlas;
	}

	public TextureAtlas getEnemiesAtlas(){return enemiesAtlas;};

	public TextureAtlas getFirebossAtlas() {
		return firebossAtlas;
	}

	public TextureAtlas getBlueBullet() {
		return blueBulletAtlas;
	}

	public Samurai getSamurai() {
		return character;
	}

	public FireBoss getFireBoss() {
		return fireBoss;
	}

	public void shoot(int i){


		BlueBullet blueBullet = new BlueBullet(this);


		blueBullets.add(blueBullet);
		Vector2 velocity = new Vector2();

		if(i == 0){
			velocity = new Vector2(4.5f,0);
		}
		else if(i == 1){
			velocity = new Vector2(-5,0);
		}
		else if(i == 2){
			velocity = new Vector2(0,2);
		}
		else if(i == 3){
			velocity = new Vector2(0,-2);
		}

		blueBullet.body.setLinearVelocity(velocity);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	public void handleInput(float dt) {

		fireDelay -= dt;

		if(Gdx.input.isKeyPressed(Input.Keys.P) && Gdx.input.isKeyPressed(Input.Keys.D)){
			if(fireDelay <= 0){
				shoot(0);
				fireDelay += 0.3f;
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.P) &&  Gdx.input.isKeyPressed(Input.Keys.A)){
			if(fireDelay <= 0){
				shoot(1);
				fireDelay += 0.3f;
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.P)){
			if(character.isWalkingRight()){
				if(fireDelay <= 0){
					shoot(0);
					fireDelay += 0.3f;
				}
			}
			else if(!character.isWalkingRight()){
				if(fireDelay <= 0){
					shoot(1);
					fireDelay += 0.3f;
				}
			}
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
			if(character.getY() < 3) {
				character.b2body.applyLinearImpulse(new Vector2(0, 5f), character.b2body.getWorldCenter(), true);
			}
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
		fireBoss.update(dt);
		hud.update();
		updateFireballs(dt);
		updateBullets(dt);
		updateTrigger(dt);
		gamecam.position.x = character.b2body.getPosition().x;
		gamecam.update();
		renderer.setView(gamecam);
		//System.out.print(character.getHitpoints());
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		if(character.getHitpoints() !=0) {
			update(delta);
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			renderer.render();
			game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
			hud.stage.draw();
			b2dr.render(world, gamecam.combined);

			game.batch.setProjectionMatrix(gamecam.combined);
			game.batch.begin();
			character.draw(game.batch);
			fireBoss.draw(game.batch);
			//fireBall.draw(game.batch);
			drawFireballs();
			drawBullets();
			game.batch.end();
		} else if(character.getHitpoints() ==0){
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(gameOver,10,10);
			batch.end();
		}

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

	public void drawBullets(){

		if(!blueBullets.isEmpty()) {
			for (int i = 0; i < blueBullets.size(); i++) {
				if(!blueBullets.get(i).isDestroyed())
					blueBullets.get(i).draw(game.batch);
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

	public void updateBullets(float dt){
		for(int i = 0; i < blueBullets.size(); i++){
			if(!blueBullets.get(i).isDestroyed())
				blueBullets.get(i).update(dt);
		}
	}

	public void updateTrigger(float dt){
		if(!trigger.isDestroyed()){
			trigger.update(dt);
		}
	}

}