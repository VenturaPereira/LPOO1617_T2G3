package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.MyGdxGame.PPM;

/**
 * Created by Luís on 07/06/2017.
 */

public class HintsScreen implements Screen{

    private Viewport viewport;
    private Stage stage;
    private Texture hints;
    private SpriteBatch batch;
    private Game game;
    private PauseScreen pauseScreen;
    private OrthographicCamera gamecam;

    /**
     * The hints screen constructor
     *
     * @param pause
     * @param game
     */
    public HintsScreen(PauseScreen pause, Game game) {
        this.game = game;
        this.pauseScreen = pause;
        this.gamecam = new OrthographicCamera();
        viewport = new FillViewport(1600/ MyGdxGame.PPM, 800/MyGdxGame.PPM,gamecam);
        stage = new Stage(viewport, ((MyGdxGame) game).batch);
        hints = new Texture(Gdx.files.internal("hint_menu_image.jpg"));
        batch = new SpriteBatch();
    }


    @Override
    public void show() {

    }

    /**
     * Hints screen render
     * @param delta
     */
    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
       if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
           game.setScreen(pauseScreen);
       }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(hints,0,-200, MyGdxGame.V_WIDTH/PPM*300, MyGdxGame.V_HEIGHT/PPM*475);
        batch.end();
        stage.draw();


    }

    /**
     * Resize method.
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
