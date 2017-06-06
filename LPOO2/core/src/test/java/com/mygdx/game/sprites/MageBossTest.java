package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.PlayScreen;
import com.mygdx.game.tools.Trigger;

import org.junit.Test;

import test.GameTest;

import static org.junit.Assert.*;

/**
 * Created by Luís on 05/06/2017.
 */
public class MageBossTest{

  @Test
    public void createMageboss(){

    MyGdxGame game = new MyGdxGame();

    PlayScreen screen = new PlayScreen(game);

    Trigger trigger = new Trigger(screen,2,2);

    assertFalse(trigger.isDestroyed());
  }

}