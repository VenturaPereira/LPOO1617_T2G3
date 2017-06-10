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
import com.mygdx.game.scenes.HudBoss;
import com.mygdx.game.sprites.Bat;
import com.mygdx.game.sprites.BlueBullet;
import com.mygdx.game.sprites.DarkBall;
import com.mygdx.game.sprites.FireBall;
import com.mygdx.game.sprites.FireBoss;
import com.mygdx.game.sprites.HealthItem;
import com.mygdx.game.sprites.MageBoss;
import com.mygdx.game.sprites.Obstacle;
import com.mygdx.game.sprites.Samurai;
import com.mygdx.game.tools.B2WorldCreator;
import com.mygdx.game.tools.Trigger;
import com.mygdx.game.tools.WorldContactListener;


public class PlayScreen implements Screen{

	private Texture gameOver;
	private Texture endGame;
	private SpriteBatch batch;

	private MyGdxGame game;
	private TextureAtlas samuraiAtlas;
	private TextureAtlas enemiesAtlas;
	private TextureAtlas firebossAtlas;
	private TextureAtlas batAtlas;
	private TextureAtlas blueBulletAtlas;
	private TextureAtlas magebossAtlas;
	private TextureAtlas darkballAtlas;
	private TextureAtlas healthAtlas;
	private TextureAtlas obstacleAtlas;
	private OrthographicCamera gamecam;
	private Viewport gamePort;

	private Music music;

	private Hud hud;
	private HudBoss hudBoss;
	private HudBoss hudSecondBoss;
	private Hud hudNew;
	private TmxMapLoader mapLoader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;

	//Box2d variables
	private World world;
	private Box2DDebugRenderer b2dr;

	private HealthItem item;
	private Samurai character;
	private FireBall fireBall;
	private DarkBall darkBall;
	private Bat bat;
	private BlueBullet blueBullet;
	private FireBoss fireBoss;
	private MageBoss mageBoss;
	private ArrayList<FireBall> fireBalls = new ArrayList<FireBall>();
	private ArrayList<DarkBall> darkBalls = new ArrayList<DarkBall>();
	private ArrayList<FireBall> bossFireBalls = new ArrayList<FireBall>();
	private ArrayList<BlueBullet> blueBullets = new ArrayList<BlueBullet>();
	private ArrayList<Bat> bats = new ArrayList<Bat>();
	private Trigger trigger1, trigger2;
	private Obstacle obstacle;
	private ArrayList<Trigger> triggers;
	private Filter f;

	private float fireDelay;
	private float ballDelay;

	/**
	 * PlayScreen constructor
	 * @param game
	 */
	public PlayScreen(MyGdxGame game) {
		loadAtlas();
		this.game = game;
		gamecam = new OrthographicCamera();
		//gamecam.zoom += 0.1f;
		gamePort = new FitViewport(1920/ MyGdxGame.PPM, 920/MyGdxGame.PPM,gamecam);
		gameOver=new Texture(Gdx.files.internal("game_over.jpg"));
		endGame= new Texture(Gdx.files.internal("end_game.jpg"));
		batch= new SpriteBatch();
		mapLoader = new TmxMapLoader();
		map = mapLoader.load("first_level_background.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1/MyGdxGame.PPM);
		gamecam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);
		world = new World(new Vector2(0,-10), true);
		b2dr = new Box2DDebugRenderer();
        b2dr.setDrawBodies(false);
		new B2WorldCreator(this);
		initializeEntities();
		loadHuds();
		fireDelay = 0;
		ballDelay = 0;
		world.setContactListener(new WorldContactListener());
		music = MyGdxGame.manager.get("music/final_countdown.ogg",Music.class);
		music.setLooping(true);
		music.play();
	}

	public void initializeEntities(){
		character = new Samurai(this);
		fireBoss = new FireBoss(this);
		mageBoss = new MageBoss(this);
		trigger1 = new Trigger(this, 2300f, 150f);
		trigger2 = new Trigger(this, 7500f, 150f);
		fireBalls = new ArrayList<FireBall>();
		darkBalls = new ArrayList<DarkBall>();
		triggers = new ArrayList<Trigger>();
		triggers.add(trigger1);
		triggers.add(trigger2);
		obstacle = new Obstacle(this, 3370f, 290f);
		bats = new ArrayList<Bat>();
		item = new HealthItem(this, 5000f, 150f);
	}

	public void loadAtlas(){
		samuraiAtlas = new TextureAtlas("SamuraiGame.pack");
		enemiesAtlas = new TextureAtlas("Enemies.pack");
		firebossAtlas = new TextureAtlas("FireBoss.pack");
		magebossAtlas = new TextureAtlas("Mage Boss.pack");
		blueBulletAtlas = new TextureAtlas("BlueBullet.pack");
		darkballAtlas = new TextureAtlas("DarkBall.pack");
		batAtlas = new TextureAtlas("Bat.pack");
		healthAtlas = new TextureAtlas("HealthItem.pack");
		obstacleAtlas = new TextureAtlas("Obstacle.pack");
	}

	/**
	 * Loads the hud to the constructor
	 */
	public void loadHuds(){
		hud = new Hud(game.batch, character,1);
		hudBoss= new HudBoss(game.batch, character,fireBoss);
		hudSecondBoss= new HudBoss(game.batch, character, mageBoss);
		hudNew = new Hud(game.batch, character,2);
	}

	/**
	 * Gets the samurai sprite atlas
	 * @return
	 */
	public TextureAtlas getSamuraiAtlas(){
		return samuraiAtlas;
	}

	/**
	 * Gets the fireballs sprite atlas
	 * @return
	 */
	public TextureAtlas getEnemiesAtlas(){return enemiesAtlas;};

	/**
	 * Gets the fireboss sprite atlas
	 * @return
	 */
	public TextureAtlas getFirebossAtlas() {
		return firebossAtlas;
	}

	/**
	 * Gets the bat sprite atlas
	 * @return
	 */
	public TextureAtlas getBatAtlas() {
		return batAtlas;
	}

	/**
	 * Gets the bullet sprite atlas
	 * @return
	 */
	public TextureAtlas getBlueBullet() {
		return blueBulletAtlas;
	}

	/**
	 * Gets the mageboss sprite class
	 * @return
	 */
	public TextureAtlas getMagebossAtlas() {
		return magebossAtlas;
	}

	/**
	 * Gets the darkball sprite atlas
	 * @return
	 */
	public TextureAtlas getDarkballAtlas() {
		return darkballAtlas;
	}

	/**
	 * Gets the health item sprite atlas
	 * @return
	 */
	public TextureAtlas getHealthAtlas() {
		return healthAtlas;
	}

	/**
	 * Gets the obstacle sprite atlas
	 * @return
	 */
	public TextureAtlas getObstacleAtlas() {
		return obstacleAtlas;
	}

	/**
	 * Gets the samurai entity
	 * @return
	 */
	public Samurai getSamurai() {
		return character;
	}

	/**
	 * Gets the fireboss entity
	 * @return
	 */
	public FireBoss getFireBoss() {
		return fireBoss;
	}

	/**
	 * Gets the mageboss entity
	 * @return
	 */
	public MageBoss getMageBoss() {return mageBoss;}

	/**
	 * Adds a bullet to the list and gives it a velocity, dependeding on the direction (i)
	 * @param i
	 */
	public void shoot(int i){
		BlueBullet blueBullet = new BlueBullet(this);
		blueBullets.add(blueBullet);
		Vector2 velocity = new Vector2();
		if(i == 0){
			velocity = new Vector2(5f,0);
		}
		else if(i == 1){
			velocity = new Vector2(-5,0);
		}
		else if(i == 2){
			velocity = new Vector2(0,5);
		}
		blueBullet.body.setLinearVelocity(velocity);
        blueBullet.body.setGravityScale(0);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	/**
	 * Handles the input made by the user
	 * @param dt
	 */
	public void handleInput(float dt) {

		fireDelay -= dt;
		if(Gdx.input.isKeyPressed(Input.Keys.P) && Gdx.input.isKeyPressed(Input.Keys.D)){
			if(fireDelay <= 0){
				shoot(0);
				fireDelay = 0.3f;
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.P) &&  Gdx.input.isKeyPressed(Input.Keys.A)){
			if(fireDelay <= 0){
				shoot(1);
				fireDelay = 0.3f;
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.P) &&  Gdx.input.isKeyPressed(Input.Keys.W)){
			if(fireDelay <= 0){
				shoot(2);
				fireDelay = 0.3f;
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.P)){
			if(character.isWalkingRight()){
				if(fireDelay <= 0){
					shoot(0);
					fireDelay = 0.3f;
				}
			}
			else if(!character.isWalkingRight()){
				if(fireDelay <= 0){
					shoot(1);
					fireDelay = 0.3f;
				}
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			game.setScreen(new PauseScreen(this,(MyGdxGame) game));
			music.stop();
            //dispose();
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			if(character.getY() < 3 && character.getCounter()==0 || character.getY() <3 && character.getCounter()%2!=0) {
				character.b2body.applyLinearImpulse(new Vector2(0, 5f), character.b2body.getWorldCenter(), true);
				character.setCounter(character.getCounter()+1);
			}
			else if(character.getY() < 3 && character.getCounter()==0 || character.getY() <3 && character.getCounter()%2!=0){
				character.b2body.applyLinearImpulse(new Vector2(0, 5f), character.b2body.getWorldCenter(), true);
				character.setCounter(character.getCounter()+1);
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

	/**
	 * Update method for all the entities
	 * @param dt
	 */
	public void update(float dt){
		handleInput(dt);
		world.step(1/60f, 6, 2);
		character.update(dt);
		updateFireboss(dt);
		updateMageboss(dt);
		mageBoss.update(dt);
		updateBats(dt);
		updateFireballs(dt);
		updateBullets(dt);
		updateTriggers(dt);
		updateDarkballs(dt);
		updateItem(dt);
		updateObstacle(dt);
		gamecam.position.x = character.b2body.getPosition().x;
		gamecam.update();
		renderer.setView(gamecam);
	}

	/**
	 * Render method for all the entities
	 * @param delta
	 */
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		if(character.getHitpoints() !=0 && mageBoss.getBossHp() !=0) {
			update(delta);
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			renderer.render();
			game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
			hudRender();
			b2dr.render(world, gamecam.combined);
			game.batch.setProjectionMatrix(gamecam.combined);
			game.batch.begin();
			character.draw(game.batch);
			fireBoss.draw(game.batch);
			if(fireBoss.isDefeated()){
				setNewFilter();
			}
			if(fireBoss.isStage2()){
				drawBossFireballs();
			}
			mageBoss.draw(game.batch);
			//fireBall.draw(game.batch);
			drawFireballs();
			drawBullets();
			drawBats();
			drawDarkballs();
			drawItem();
			drawObstacle();
			game.batch.end();
		} else if(character.getHitpoints() ==0){
			showGameOverScreen();
		} else if(mageBoss.getBossHp() ==0){
			showEndScreen();
		}

		//game.batch.setProjectionMatrix(gamecam.combined);;


	}

	/**
	 * Resize method
	 * @param width
	 * @param height
	 */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		gamePort.update(width, height);
	}

	/**
	 * Gets the music
	 * @return
	 */
	public  Music getMusic(){
		return music;
	}

	/**
	 * Gets the tiled map
	 * @return
	 */
	public TiledMap getMap() {
		return map;
	}

	/**
	 * Gets the game world
	 * @return
	 */
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

	/**
	 * Shoots fireballs depending on the fireboss stage
	 */
	public void shootFireball(){
		int height = 3800;
		fireBall = new FireBall(this, .32f, 0.32f, height);
		fireBalls.add(fireBall);
	}

	/**
	 * Shoots dakballs depending on the mageboss stage
	 */
	public void shootDarkballs(){

		float samuraiX = character.b2body.getPosition().x;
		float magebossX = mageBoss.body.getPosition().x;


		if(mageBoss.isStage1()) {
			darkBall = new DarkBall(this, .32f, 0.32f, mageBoss.body.getPosition().x * MyGdxGame.PPM, 150);

			if (samuraiX < magebossX)
				darkBall.b2body.setLinearVelocity(new Vector2(-3, 0));
			else if (samuraiX > magebossX)
				darkBall.b2body.setLinearVelocity(new Vector2(3, 0));

			darkBalls.add(darkBall);
		}
		else if(mageBoss.isStage2()){
			darkBall = new DarkBall(this, .32f, 0.32f, character.b2body.getPosition().x * MyGdxGame.PPM + 5f, 150);
			darkBall.b2body.setLinearVelocity(0, 2);
			darkBalls.add(darkBall);
		}
		else if(mageBoss.isStage3()){
			DarkBall darkBall1 = new DarkBall(this, .32f, 0.32f, mageBoss.body.getPosition().x * MyGdxGame.PPM , 150);
			DarkBall darkBall2 = new DarkBall(this, .32f, 0.32f, mageBoss.body.getPosition().x * MyGdxGame.PPM , 150);
			DarkBall darkBall3 = new DarkBall(this, .32f, 0.32f, mageBoss.body.getPosition().x * MyGdxGame.PPM , 150);
			DarkBall darkBall4 = new DarkBall(this, .32f, 0.32f, mageBoss.body.getPosition().x * MyGdxGame.PPM , 150);

			darkBall1.b2body.setLinearVelocity(-3,0);
			darkBall2.b2body.setLinearVelocity(-3,3);
			darkBall3.b2body.setLinearVelocity(3,3);
			darkBall4.b2body.setLinearVelocity(3,0);

			darkBalls.add(darkBall1);
			darkBalls.add(darkBall2);
			darkBalls.add(darkBall3);
			darkBalls.add(darkBall4);
		}

	}

	/**
	 * Creates a new bat every single time gap
	 */
	public void createBat(){
		int height = 5050;
		bat = new Bat(this, .32f, 0.32f, height);
		bats.add(bat);
	}

	/**
	 * Draws the bat sprite
	 */
	public void drawBats(){
		if(!bats.isEmpty()) {
			for (int i = 0; i < bats.size(); i++) {
				if(!bats.get(i).isDestroyed())
					bats.get(i).draw(game.batch);
			}
		}
	}

	/**
	 * Draws the fireballs sprite
	 */
	public void drawFireballs(){
		for(int i = 0; i < fireBalls.size(); i++) {
			if (!fireBalls.get(i).getDestroyed()) {
				fireBalls.get(i).draw(game.batch);
			}
		}
	}

	/**
	 * Draws the bullets sprite
	 */
	public void drawBullets(){

		if(!blueBullets.isEmpty()) {
			for (int i = 0; i < blueBullets.size(); i++) {
				if(!blueBullets.get(i).isDestroyed())

					blueBullets.get(i).draw(game.batch);
			}
		}
	}

	/**
	 * Updates the fireballs movement if not destroyed
	 * @param dt
	 */
	public void updateFireballs(float dt){
		if(!fireBalls.isEmpty()) {
			for (int i = 0; i < fireBalls.size(); i++) {
				if (!fireBalls.get(i).getDestroyed()) {
					fireBalls.get(i).update(dt);
				}
			}
		}
	}

	/**
	 * Updates the bullets movement if not destroyed
	 * @param dt
	 */
	public void updateBullets(float dt){

		if(!blueBullets.isEmpty()) {
			for (int i = 0; i < blueBullets.size(); i++) {
				if (!blueBullets.get(i).isDestroyed())
					blueBullets.get(i).update(dt);
			}
		}
	}

	/**
	 * Updates the trigger if not destroyed
	 * @param dt
	 */
	public void updateTriggers(float dt){
		for(int i = 0; i < triggers.size(); i++) {
			if (!triggers.get(i).isDestroyed()) {
				triggers.get(i).update(dt);
			}
		}
	}

	/**
	 * Updates the bats movement if not destroyed
	 * @param dt
	 */
	public void updateBats(float dt){
		if(!bats.isEmpty()) {
			for (int i = 0; i < bats.size(); i++) {
				if(!bats.get(i).isDestroyed())
					bats.get(i).update(dt);
			}
		}
	}

	/**
	 * Updates the darkballs movement if not destroyed
	 * @param dt
	 */
	public void updateDarkballs(float dt){
		if(!darkBalls.isEmpty()) {
			for (int i = 0; i < darkBalls.size(); i++) {
				if (!darkBalls.get(i).getDestroyed()) {
					darkBalls.get(i).update(dt);
				}
			}
		}
	}

	/**
	 * Updates the item if not destroyed
	 * @param dt
	 */
	public void updateItem(float dt){
		if(!item.isDestroyed())
			item.update(dt);
	}

	/**
	 * Updates the obstacle if not destroyed
	 * @param dt
	 */
	public void updateObstacle(float dt){
		if(!obstacle.isDestroyed())
			obstacle.update(dt);
	}

	/**
	 * Updates the fireboss movements if not destroyed
	 * @param dt
	 */
	public void updateFireboss(float dt){
		if(!fireBoss.isDefeated()){
			fireBoss.update(dt);
		}
		if(!fireBoss.getActivated()) {
			hud.update();
		}else if(fireBoss.getActivated() && !fireBoss.isDefeated()){
			hudBoss.update();
		}
		else if(fireBoss.isDefeated() && !mageBoss.isActivated()){
			hudNew.update();
		} else if(mageBoss.isActivated()){
			hudSecondBoss.update();
		}
		ballDelay -= dt;
		if(fireBoss.isStage2()) {
			if (ballDelay <= 0) {
				shootFireball();
				ballDelay = 2.1f;
			}
		}
		else if(fireBoss.isStage3()){
			if (ballDelay <= 0) {
				for(int i = 0; i < 4; i++)
					shootFireball();
				ballDelay = 3f;
			}
		}
		if(fireBoss.isDefeated() && !mageBoss.isActivated()){
			if(ballDelay <= 1) {
				createBat();
				ballDelay = 5f;
			}
		}

	}

	/**
	 * Updates the mageboss movements if not destroyed
	 * @param dt
	 */
	public void updateMageboss(float dt){

		if(mageBoss.getBossHp() != 0){

			mageBoss.update(dt);
		}
		if(mageBoss.isStage1()){
			if(ballDelay <= 1) {
				shootDarkballs();
				ballDelay = 3f;
			}
		}
		if(mageBoss.isStage2()){
			if(ballDelay <= 1) {
				shootDarkballs();
				ballDelay = 3f;
			}
		}
		if(mageBoss.isStage3()){
			if(ballDelay <= 1) {
				shootDarkballs();
				ballDelay = 2.5f;
			}
		}
	}

	/**
	 * Draws the sprite of the fireballs during the fireboss fight
	 */
	public void drawBossFireballs(){
		for(int i = 0; i < bossFireBalls.size(); i++) {
			if (!bossFireBalls.get(i).getDestroyed()) {
				bossFireBalls.get(i).draw(game.batch);
			}
		}
	}

	/**
	 * Draws the sprite of the darkballs during the mageboss fight
	 */
	public void drawDarkballs(){
		for(int i = 0; i < darkBalls.size(); i++) {
			if (!darkBalls.get(i).getDestroyed()) {
				darkBalls.get(i).draw(game.batch);
			}
		}
	}

	/**
	 * Draws the health item sprite
	 */
	public void drawItem(){
		if(!item.isDestroyed())
			item.draw(game.batch);
	}

	/**
	 * Draws the obstacle sprite
	 */
	public void drawObstacle(){
		if(!obstacle.isDestroyed())
			obstacle.draw(game.batch);
	}

	/**
	 * Draws the huds depending on the level of the game
	 */
	public void hudRender(){
		if(!fireBoss.getActivated()) {
			hud.stage.draw();

		}else if(fireBoss.getActivated() && !fireBoss.isDefeated()){
			hud.stage.dispose();
			hudBoss.stage.draw();
		}else if(fireBoss.isDefeated() && !mageBoss.isActivated() ){
			hudBoss.stage.dispose();

			hudNew.stage.draw();
		}else if(mageBoss.isActivated()){
			hudNew.stage.dispose();
			hudSecondBoss.stage.draw();
		}
	}

	/**
	 * Displays the game's end screen
	 */
	public void showEndScreen(){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(endGame,10,10,1200,600);
		batch.end();
	}

	/**
	 * Displays the game's game over screen
	 */
	public void showGameOverScreen(){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(gameOver,10,10,1200,600);
		batch.end();
	}

	/**
	 * Sets a new collision filter to the fireboss, after defeat
	 */
	public void setNewFilter(){
		f = new Filter();
		f.categoryBits= MyGdxGame.FIREBOSS_BIT;
		f.maskBits=  MyGdxGame.GROUND_BIT | MyGdxGame.WALL_BIT | MyGdxGame.FIREBOSS_BIT | MyGdxGame.FIREBOSS_HEAD_BIT;
		for(int i=0; i < fireBoss.body.getFixtureList().size; i++){
			fireBoss.body.getFixtureList().get(i).setFilterData(f);
		}
	}
}