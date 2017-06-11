# LPOO1617_T2G3
[![BCH compliance](https://bettercodehub.com/edge/badge/luigicorreia/LPOO1617_T2G3?token=16c621d1f4a422cf1748248249bade7c08109f92)](https://bettercodehub.com/)
Luís Miguel Correia - up201503342 ;
Ventura de Sousa Pereira - up201404690 

# Final Project Intermediate Check-Point


 ![alt text](https://cloud.githubusercontent.com/assets/22820323/25566756/c47b5fb8-2dd7-11e7-8e1d-1ee314a41776.png)

## SamuraiGame Class

This one is the main class, where all the other classes are called.

## Engine Package

This package contains all the game's logic and physics engines.

### Physics Class

This class contains all the 2D physics in the game: it creates bodies and physic worlds. It handles collisions (implements a ContactListener from the libgdx library), impulses, forces (ex: gravity) and shapes. This physics engine is based on the libgdx extension, Box2D. 

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



## Behaviour aspects design

### Game sequence

![alt text](https://cloud.githubusercontent.com/assets/22820323/25568043/6ba35fa6-2df2-11e7-81a3-286c95709c32.png)


### Samurai state diagram

![alt_text](https://cloud.githubusercontent.com/assets/22820323/25567052/708c3e3a-2ddd-11e7-9e23-2c097ce1a927.png)


## Design patterns

### Singleton

The Engine Package and the main class are singletons. The SamuraiGame, Engine and GameController will be easily accessed

### State

The Samurai Class will use a State depending on the user input.

### Update Method

The update method will be used because most of the objects are independent from one another and there's several objects running at the same time. This will enable the game to run smoother.

### Template

The template pattern is already used by libgdx. Therefore, the SamuraiGame class extends Game. The main loop is the same in every game. It runs until the user wants to quit, it handles input, updates the models and renders the displayed frame.

### Observer

The observer pattern will be used to check for collisions. The physics engine will use a ContactListener from the libgdx library.

## GUI Design

#### Title Screen
 - Title
 - Level option
 - Link to Settings Menu

#### Settings Menu
 - Sound options
 - Brightness option
 - Fullscreen option

#### Game Window
 - Link to Settings Menu
 - Health bar

### GUI Mock-ups

![alt_text](https://cloud.githubusercontent.com/assets/22820323/25567194/5941882c-2de0-11e7-9e6c-98a0e88872a5.png)
![alt_text](https://cloud.githubusercontent.com/assets/22820323/25567198/695fe8ac-2de0-11e7-83a3-ddd9109046b4.png)
![alt_text](https://cloud.githubusercontent.com/assets/22820323/25567206/ac0750b4-2de0-11e7-8b86-2b7479946982.png)
![alt_text](https://cloud.githubusercontent.com/assets/22820323/25567211/b775514e-2de0-11e7-87a5-a88722fd3579.png)


## Test Design

- Meele collisions
- Projectile collisions
- Saving progress
- Killing enemies
- Killing bosses
- Bosses attacking pattern according to their health bar
- Checking bosses weak spots
- Game Over
- Transitions between levels
















# Final Delivery 
Setup/Installation:

Our project uses libgdx's library, being generated throught it.
However, even though, in our executable, one of our components (music) is fully functional, in the compilation of the project, if in other computers but the one who implemented it, an error appears- which doesn't stop it from running.
To play/run our game it's only necessary to execute the jar.



## Development documentation:


### Relevant decisions:

We decided to use fragments, in order to ensure the smoothness and good function of the game.



### Design Patterns:

#### -Strategy:
 Our AI is implemented through this method. Both our bosses inherit the class Boss. This class has a move function, that varies depending on which type of boss is activated.

#### -Singleton:
 We have a class that creates the game, our instances. Only one instance of it can exist.

#### -State:
 Our bosses and our hero have states that alter their behavior accordingly.


### Major difficulties:

During this project we had some difficulties.
In the early stages of development, we had some troubles getting used to the new library. Trying to implement the necessary requirements, we came across some challenges, such as the way collisions(the physics) were supposed to work, how to associate a fixture to it's sprite. 
Eventually this all led to some troubles trying to compose the MVC structure - we believe we haven't been keen on doing so.
Furthermore, we had some issues trying to construct a competetive game due to the choice of it's category. Being a platform based game, we came across doubts whether was it competitibe enough or not.
Lastly, due the MVC difficulties it was hard for us to run tests, as our view is somewhat connected to our model.

### Lessons learned:

We believe that the biggest lesson we learned was about planning.

Even though we managed to create the game we wanted through good planning, we are convicted that we should improve our pre-development effeciency. Specially when it comes to the clear separation of a game's/program's components - Model , viewer,  controller.
Nonetheless, we also comprehend the need and how to get used to new working enviroments.

### Time spent:

87 hours, approximated.

### Distribuição de tarefas:

Luís Correia (50%)
-Implementação de sprites
-Fisica
-Documentação
Ventura Pereira (50%)
-Screens
-Fisica
-AI

### User Manual:

This will appear when you run it. Use your mouse to click on it and start.
![image](https://user-images.githubusercontent.com/22984170/27007375-48ab4104-4e49-11e7-85ac-577604bfd2af.png)

You'll be redirected to the screen!
![image](https://user-images.githubusercontent.com/22984170/27007394-f0448ccc-4e49-11e7-83e5-b60017500539.png)

To pause, press 'E' and you'll go to here
![image](https://user-images.githubusercontent.com/22984170/27007397-130e404a-4e4a-11e7-956b-8af1dc465b67.png)

If you desire some tips to overcome your opponents, press the middle button
![image](https://user-images.githubusercontent.com/22984170/27007401-2483374a-4e4a-11e7-9f16-f1d05bde506f.png)
