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
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import static com.mygdx.game.MyGdxGame.PPM;

/**
 * Created by Ventura on 31/05/2017.
 */

public class PauseScreen implements Screen {
    private PlayScreen screen;
    private MyGdxGame game;
    private SpriteBatch batch;
    private Texture pauseTexture;
    private Texture buttonTest;
    private Texture background;
    private Texture quit;
    private Stage stage;
    private FillViewport viewport;
    private ImageButton buttonResume;
    private ImageButton buttonQuit;
    private final int  TABLE_WIDTH =20;
    private final int  TABLE_HEIGHT =20;



    public PauseScreen(PlayScreen screen, MyGdxGame game){
       this.screen=screen;
       this.game=game;
       this.batch= new SpriteBatch();
        viewport=new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        pauseTexture=new Texture(Gdx.files.internal("play_button.png"));
        buttonTest = new Texture(Gdx.files.internal("trophy.png"));
        background = new Texture(Gdx.files.internal("main_menu_image.jpg"));
        quit = new Texture(Gdx.files.internal("exit_button.png"));
        stage = new Stage(viewport, ((MyGdxGame) game).batch);
        buttonResume = new ImageButton(new TextureRegionDrawable(new TextureRegion(pauseTexture,pauseTexture.getWidth(), pauseTexture.getHeight())),
                                new TextureRegionDrawable(new TextureRegion(buttonTest,buttonTest.getWidth(), buttonTest.getHeight())));
        buttonQuit = new ImageButton(new TextureRegionDrawable(new TextureRegion(quit,pauseTexture.getWidth()+200, quit.getHeight())),
                new TextureRegionDrawable(new TextureRegion(buttonTest,buttonTest.getWidth(), buttonTest.getHeight())));
        Table table = new Table();
        table.center();
        table.setFillParent(true);
        table.add(buttonResume).size(TABLE_WIDTH,TABLE_HEIGHT);
        table.row();
        table.add(buttonQuit).size(TABLE_WIDTH*1500,TABLE_HEIGHT);
        stage.addActor(table);
    }



    @Override
    public void show() {

    }

    @Override
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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(background,0,-200,MyGdxGame.V_WIDTH/PPM*300,MyGdxGame.V_HEIGHT/PPM*475);
        batch.end();
        Gdx.input.setInputProcessor(stage);
        stage.act();
        stage.draw();





    }

    @Override
    public void resize(int width, int height) {

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
