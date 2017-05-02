package com.mygdx.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.game.sprites.InteractiveTileObject;

public class WorldContactListener implements ContactListener{

	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		System.out.println("contact");
		if(fixA.getUserData() == "katana" || fixB.getUserData() == "katana"){
			Fixture katana = fixA.getUserData() == "katana" ? fixA : fixB;
			Fixture object = katana == fixA ? fixB : fixA;

			if(object.getUserData() != null && object.getUserData() instanceof InteractiveTileObject) {
				((InteractiveTileObject)object.getUserData()).onKatanaHit();
			}
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
