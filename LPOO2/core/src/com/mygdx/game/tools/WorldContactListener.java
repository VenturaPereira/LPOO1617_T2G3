package com.mygdx.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;


import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.BlueBullet;
import com.mygdx.game.sprites.Enemy;
import com.mygdx.game.sprites.InteractiveTileObject;
import com.mygdx.game.sprites.Samurai;

public class WorldContactListener implements ContactListener{

	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		System.out.println("contact");
		int cDef= fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;
		if(fixA.getUserData() == "katana" || fixB.getUserData() == "katana"){
			Fixture katana = fixA.getUserData() == "katana" ? fixA : fixB;
			Fixture object = katana == fixA ? fixB : fixA;

			if(object.getUserData() != null && object.getUserData() instanceof InteractiveTileObject) {
				((InteractiveTileObject)object.getUserData()).onKatanaHit();
			}
		}

		switch (cDef){
			case MyGdxGame.ENEMY_BIT | MyGdxGame.SAMURAI_BIT:
				if(fixA.getFilterData().categoryBits == MyGdxGame.ENEMY_BIT){
					((Enemy)fixA.getUserData()).hit();
					((Samurai)fixA.getUserData()).hpLoss();

					System.out.print("i enter here");
				} else {
					if (fixB.getFilterData().categoryBits == MyGdxGame.ENEMY_BIT) {
						((Enemy) fixB.getUserData()).hit();
						((Samurai) fixA.getUserData()).hpLoss();

						System.out.print("i enter here2");
					}
				}
				break;
			case MyGdxGame.WALL_BIT | MyGdxGame.ENEMY_BIT:
				if(fixA.getFilterData().categoryBits == MyGdxGame.ENEMY_BIT){
					((Enemy)fixA.getUserData()).hit();
				} else if(fixB.getFilterData().categoryBits == MyGdxGame.ENEMY_BIT) {
					((Enemy) fixB.getUserData()).hit();

				}
				break;
			case MyGdxGame.BULLET_BIT | MyGdxGame.ENEMY_BIT:
				if(fixA.getFilterData().categoryBits == MyGdxGame.ENEMY_BIT){
					((Enemy)fixA.getUserData()).hit();
					((BlueBullet)fixB.getUserData()).hit();
				} else if(fixB.getFilterData().categoryBits == MyGdxGame.ENEMY_BIT) {
					((BlueBullet)fixA.getUserData()).hit();
					((Enemy) fixB.getUserData()).hit();

				}
				break;
		}
	}

	@Override
	public void endContact(Contact contact) {
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}
	
}
