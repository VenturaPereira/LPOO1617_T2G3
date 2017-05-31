package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.PlayScreen;
import com.mygdx.game.screens.StartMenu;


public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100;

	public static final short GROUND_BIT = 1;
	public static final short SAMURAI_BIT = 2;
	public static final short WALL_BIT = 4;
	public static final short FIREBALL_BIT = 8;
	public static final short BULLET_BIT = 16;
	public static final short FIREBOSS_BIT = 32;
	public static final short TRIGGER_BIT = 64;
	public static final short FIREBOSS_HEAD_BIT = 128;
	public static final short BAT_BIT = 256;

    public static AssetManager manager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new AssetManager();
		manager.load("music/final_countdown.ogg", Music.class);
        manager.finishLoading();
		setScreen(new StartMenu(this));
	}
	
	
	@Override
	public void render () {
		super.render();
		manager.update();
	}
	
	
}
