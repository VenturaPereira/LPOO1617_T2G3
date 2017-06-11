package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;


import static com.mygdx.game.MyGdxGame.PPM;

/**
 * Created by Ventura on 31/05/2017.
 */

public class PauseScreen implements Screen {
    private PlayScreen screen;
    private HintsScreen hintsScreen;
    private MyGdxGame game;
    private SpriteBatch batch;
    private Texture pauseTexture;
    private Texture buttonTest, buttonTest2;
    private Texture background;
    private Texture hintButtonTexture;
    private Texture quit;
    private Stage stage;
    private FillViewport viewport;
    private ImageButton buttonResume;
    private ImageButton buttonQuit;
    private ImageButton buttonHint;
    private final int  TABLE_WIDTH =20;
    private final int  TABLE_HEIGHT =20;


    /**
     * Pause screen constructor
     * @param screen
     * @param game
     */
    public PauseScreen(PlayScreen screen, MyGdxGame game){
        this.screen=screen;
        this.game=game;
        this.batch= new SpriteBatch();
        hintsScreen = new HintsScreen(this, (MyGdxGame)game);
        viewport=new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        pauseTexture=new Texture(Gdx.files.internal("play_button.png"));
        buttonTest = new Texture(Gdx.files.internal("exit_button.png"));
        buttonTest2 = new Texture(Gdx.files.internal("hints_Button.png"));
        background = new Texture(Gdx.files.internal("pause_menu_image.jpg"));
        hintButtonTexture = new Texture(Gdx.files.internal("hints_Button.png"));
        quit = new Texture(Gdx.files.internal("exit_button.png"));
        stage = new Stage(viewport, ((MyGdxGame) game).batch);
        buttonResume = new ImageButton(new TextureRegionDrawable(new TextureRegion(pauseTexture,pauseTexture.getWidth(), pauseTexture.getHeight())), new TextureRegionDrawable(new TextureRegion(buttonTest,buttonTest.getWidth(), buttonTest.getHeight())));
        buttonQuit = new ImageButton(new TextureRegionDrawable(new TextureRegion(quit,pauseTexture.getWidth()+200, quit.getHeight())), new TextureRegionDrawable(new TextureRegion(buttonTest,buttonTest.getWidth(), buttonTest.getHeight())));
        buttonHint = new ImageButton(new TextureRegionDrawable(new TextureRegion(hintButtonTexture,hintButtonTexture.getWidth(), hintButtonTexture.getHeight())), new TextureRegionDrawable(new TextureRegion(buttonTest2,buttonTest2.getWidth(), buttonTest2.getHeight())));
        Table table = new Table();
        table.center();
        table.setFillParent(true);
        table.add(buttonResume).size(TABLE_WIDTH,TABLE_HEIGHT);
        table.row();
        table.add(buttonHint).size(TABLE_WIDTH*1000, TABLE_HEIGHT);
        table.row();
        table.add(buttonQuit).size(TABLE_WIDTH*1500,TABLE_HEIGHT);
        stage.addActor(table);
    }



    @Override
    public void show() {

    }

    @Override
    /**
     * Render method.
     */
    public void render(float delta) {
        //aqui é o listener do botão

        buttonResume.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                game.setScreen(screen);
                screen.getMusic().play();
                 dispose();
            }


        });
        buttonQuit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                Gdx.app.exit();
            }
        });
        buttonHint.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                game.setScreen(hintsScreen);
                screen.getMusic().play();
            }
        });
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(background,0,-200,MyGdxGame.V_WIDTH/PPM*300,MyGdxGame.V_HEIGHT/PPM*475);
        batch.end();
        Gdx.input.setInputProcessor(stage);
        stage.act();
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
        pauseTexture.dispose();
        quit.dispose();
        this.stage.dispose();
    }
}
