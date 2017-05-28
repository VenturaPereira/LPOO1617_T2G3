package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Samurai;

/**
 * Created by Ventura on 26/05/2017.
 */

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private Integer life;
    private Samurai character;

    Label scoreLabel;
    Label level;
    Label world;
    Label samurai;

    public Hud(SpriteBatch sb, Samurai character){
        this.character= character;
        life = character.getHitpoints();
        viewport = new FitViewport(MyGdxGame.V_WIDTH*2, MyGdxGame.V_HEIGHT*2, new OrthographicCamera());
        stage = new Stage(viewport, sb);


        Table table = new Table();
        table.top();
        table.setFillParent(true);
        scoreLabel=new Label(String.format("%03d",life), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        level=new Label("1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        world=new Label("Level", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        samurai= new Label("HP", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(samurai).expandX();
        table.add(world).expandX();
        table.row();
        table.add(scoreLabel).expandX().top();
        table.add(level).expandX().top();


        stage.addActor(table);
    }


    public void update(){
      life=this.character.getHitpoints();
        scoreLabel.setText(String.format("%03d",life));
    }



}
