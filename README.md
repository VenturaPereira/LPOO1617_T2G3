# LPOO1617_T2G3
[![BCH compliance](https://bettercodehub.com/edge/badge/luigicorreia/LPOO1617_T2G3?token=16c621d1f4a422cf1748248249bade7c08109f92)](https://bettercodehub.com/)
Luís Miguel Correia - up201503342 ;
Ventura de Sousa Pereira - up201404690 

# Final Project Intermediate Check-Point


 ![alt text](https://cloud.githubusercontent.com/assets/22820323/25565706/55ee223c-2dc4-11e7-9cfa-8c62d3ffc61e.png)

## SamuraiGame Class

This one is the main class, where all the other classes are called.

## Engine Package

This package contains all the game's logic and physics engines.

### Physics Class

This class contains all the 2D physics in the game: it creates bodies and physic worlds. It handles collisions (implements a WorldContactListener from the libgdx library), impulses, forces (ex: gravity) and shapes. This physics engine is based on the libgdx extension, Box2D. 

### Logic Class

This class as all the logic around the game. Examples: dying when th health bar is empty, proceeding to the next level, beating a boss.

## GameController Package

### KeyboardInput Class

This class handles all the input made by the user, triggering animations and manipulating the physics world.

## Screens Package

### Screen Class

This is a abstract class that represents a screen of the game. It renders the background and all the layout of the screen. A screen will use a Screen from the libgdx library.

#### PlayScreenClass

This screen will be a level of the game, it will have a map, textures and sprites.

#### MenuScreen Class

This screen will be the menu screen, it will have buttons to navigate the game's structure, changing settings that suits the user.

## Entities Package

This package contains the entities of the game: the Samurai, the enemies and the bosses.

### Samurai Class

This class has the sprites of the samurai and the Samurai body. The sprites are used for the Samurai's animation (jumping, walking, attacking).

### Enemy Class

This is an abstract class for the various enemies in the game. All of them have sprites, animations and a body.

### Boss Class

This is an abstract class for the bosses in the game. Like the enemies, bosses have sprites, animations and body, but they also have some extra features as health bar, weak spots and attacking patterns.
