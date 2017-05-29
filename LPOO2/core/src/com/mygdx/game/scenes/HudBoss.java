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
import com.mygdx.game.sprites.Boss;
import com.mygdx.game.sprites.FireBoss;
import com.mygdx.game.sprites.Samurai;

/**
 * Created by Ventura on 29/05/2017.
 */

public class HudBoss {
        public Stage stage;
        private Viewport viewport;
        private Integer life;
        private Integer bossLife;
        private Samurai character;
        private FireBoss boss;
        private Table table;
        Label scoreLabel;
        Label bossHp;
        Label firstBoss;
        Label samurai;

        public HudBoss(SpriteBatch sb, Samurai character, Boss boss){
            this.character= character;
            this.boss = (FireBoss)boss;
            life = character.getHitpoints();
             bossLife = this.boss.getBossHp();
            viewport = new FitViewport(MyGdxGame.V_WIDTH*2, MyGdxGame.V_HEIGHT*2, new OrthographicCamera());
            stage = new Stage(viewport, sb);


            this.table = new Table();
            table.top();
            table.setFillParent(true);
            scoreLabel=new Label(String.format("%03d",life), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            bossHp=new Label(String.format("%03d", bossLife), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            firstBoss=new Label("Boss", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            samurai= new Label("HP", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

            table.add(samurai).expandX();
            table.add(firstBoss).expandX();
            table.row();
            table.add(scoreLabel).expandX().top();
            table.add(bossHp).expandX().top();


            stage.addActor(table);
        }


        public void update(){
            life=this.character.getHitpoints();
            bossLife = this.boss.getBossHp();
            scoreLabel.setText(String.format("%03d",life));
            bossHp.setText(String.format("%03d", bossLife));
        }



    }


