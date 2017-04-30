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

## GameController Package

### KeyboardInput Class

This class handles all the input made by the user, triggering animations and manipulating the physics world.

## Screens Package

### Screen Class

This is a abstract class that represents a screen of the game. It renders the background and all the layout of the screen. A screen will use a ScreenAdapter from the libgdx library.

#### PlayScreenClass

This is a abstract class that represents a level of the game. A playscreen will use a ScreenAdapter from the libgdx library  
