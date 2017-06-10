package com.mygdx.game.GameLogic;

import com.badlogic.gdx.physics.box2d.World;


/**
 * Created by Luís on 06/06/2017.
 */

public class GameLogic {
    World world;
    SamuraiLogic samuraiLogic;
    BulletLogic bulletLogic;
    EnemyLogic enemyLogic;


    public GameLogic(){
        samuraiLogic = new SamuraiLogic(100, 100);
        bulletLogic = new BulletLogic();
        enemyLogic = new EnemyLogic(300, 100);
    }

    public SamuraiLogic getSamuraiLogic() {
        return samuraiLogic;
    }

    public BulletLogic getBulletLogic() {
        return bulletLogic;
    }

    public void update(float dt){

    }
}
