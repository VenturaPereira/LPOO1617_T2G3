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
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.MyGdxGame.PPM;


/**
 * Created by Ventura on 28/05/2017.
 */

public class StartMenu implements Screen{

    private FillViewport viewport;
    private Stage stage;
    private Texture start;
   private SpriteBatch batch;
    private Game game;

    public StartMenu(Game game){
        this.game=game;
        viewport=new FillViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((MyGdxGame) game).batch);
        start=new Texture(Gdx.files.internal("main_menu_image.jpg"));
        batch= new SpriteBatch();
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label startMenu = new Label("Welcome",font);
        Label playGame = new Label("Press to play",font);
        table.add(startMenu).expandX();
        table.row();
        table.add(playGame).expandX().padTop(10f);
        stage.addActor(table);


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
          Gdx.app.exit();
        }
        if (Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen((MyGdxGame) game));
            dispose();
        }

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            batch.draw(start,0,-200, MyGdxGame.V_WIDTH/PPM*300, MyGdxGame.V_HEIGHT/PPM*475);
            batch.end();
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
       stage.dispose();
    }
}
