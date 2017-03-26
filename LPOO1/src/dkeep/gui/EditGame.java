package dkeep.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.imgscalr.Scalr;

import gameLogic.Game;
import gameLogic.MapGame;

// TODO: Auto-generated Javadoc
/**
 * The Class EditGame.
 */
public class EditGame extends JPanel implements MouseListener {
	
	/** The grid W. */
	private int offsetW, offsetH, gridH, gridW;
	
	/** The game. */
	private Game game = new Game(0,"Rookie");
	
	/** The hero. */
	private BufferedImage wall, floor, door, ogre, weapon, key, hero;
	
	/** The to add. */
	private char toAdd;
	
	/** The b. */
	private int a, b;
	
	/** The door exists. */
	private boolean doorExists = false;
	
	/** The hero exists. */
	private boolean heroExists = false;
	
	/** The ogre exists. */
	private boolean ogreExists = false;
	
	/** The key exists. */
	private boolean keyExists = false;

	
	/**
	 * Instantiates a new edits the game.
	 *
	 * @param height the height
	 * @param width the width
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws ImagingOpException the imaging op exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public EditGame(int height, int width) throws IllegalArgumentException, ImagingOpException, IOException{
 		addMouseListener(this);
 		gridH = getGame().getMap2().getMap()[0].length;
		gridW = getGame().getMap2().getMap().length;
		offsetW = Math.round(width / gridW);
		offsetH = Math.round(height/gridH);
		this.hero = Scalr.resize(ImageIO.read(new File("images/Anduin_wrynn_Cata.png")), offsetW);
		this.floor = Scalr.resize(ImageIO.read(new File("images/floor.jpg")), Scalr.Mode.FIT_EXACT, offsetW);
		this.wall = Scalr.resize(ImageIO.read(new File("images/images.jpg")), Scalr.Mode.FIT_EXACT, offsetW);
		this.door = Scalr.resize(ImageIO.read(new File("images/door.png")), Scalr.Mode.FIT_TO_HEIGHT, offsetW);
		this.ogre = Scalr.resize(ImageIO.read(new File("images/guldan_WoD.png")), offsetW);
		this.weapon = Scalr.resize(ImageIO.read(new File("images/weapon.png")), offsetW);
		this.key = Scalr.resize(ImageIO.read(new File("images/TWW_Boss_Key.png")), offsetW);
	}
	
	
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
	
		MapGame gamemap = getGame().getMap2();
		
		for(int i = 0; i < gamemap.getMap().length; i++){
			for(int j = 0; j < gamemap.getMap()[i].length; j++){
				g.drawImage(floor, i * offsetW, j * offsetH, this);
			}
		}
		for(int i = 0; i < gamemap.getMap().length; i++ ){
			for(int j =0; j < gamemap.getMap()[i].length; j++){
				char component = gamemap.getMap()[i][j];
				switch(component){
				case 'X':
					g.drawImage(wall, j * offsetH, i* offsetW, this);
					break;
				case 'I':
					g.drawImage(door, j* offsetH, i * offsetW, this);
					break;
					
				case 'k':
					if(!gamemap.getHero().getPickedKey()){
					g.drawImage(key , j* offsetH, i* offsetW,this);
					}
					break;
				case 'H':
					g.drawImage(hero , j* offsetH, i* offsetW,this);
				    break;
				case '0':
					g.drawImage(ogre , j* offsetH, i* offsetW,this);
					break;
			}
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {	
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		int i = (e.getX())/offsetW;
		int j =   (e.getY())/offsetH;
		if(getToAdd() == 'H'){
			this.setHeroExists(true);
		}
		if(getToAdd() == 'k'){
			this.setKeyExists(true);
		}
		if(getToAdd() == '0'){
			this.setOgreExists(true);
		}
		if(getToAdd() == 'I'){
			this.setDoorExists(true);
		}
		game.getMap2().getMap()[j][i] = getToAdd();
		repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}



	/**
	 * Gets the game.
	 *
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}



	/**
	 * Sets the game.
	 *
	 * @param game the new game
	 */
	public void setGame(Game game) {
		this.game = game;
	}



	/**
	 * Gets the to add.
	 *
	 * @return the to add
	 */
	public char getToAdd() {
		return toAdd;
	}



	/**
	 * Sets the to add.
	 *
	 * @param toAdd the new to add
	 */
	public void setToAdd(char toAdd) {
		this.toAdd = toAdd;
	}



	/**
	 * Gets the b.
	 *
	 * @return the b
	 */
	public int getB() {
		return b;
	}



	/**
	 * Sets the b.
	 *
	 * @param b the new b
	 */
	public void setB(int b) {
		this.b = b;
	}



	/**
	 * Gets the a.
	 *
	 * @return the a
	 */
	public int getA() {
		return a;
	}



	/**
	 * Sets the a.
	 *
	 * @param a the new a
	 */
	public void setA(int a) {
		this.a = a;
	}



	/**
	 * Checks if is door exists.
	 *
	 * @return true, if is door exists
	 */
	public boolean isDoorExists() {
		return doorExists;
	}



	/**
	 * Sets the door exists.
	 *
	 * @param doorExists the new door exists
	 */
	public void setDoorExists(boolean doorExists) {
		this.doorExists = doorExists;
	}



	/**
	 * Checks if is hero exists.
	 *
	 * @return true, if is hero exists
	 */
	public boolean isHeroExists() {
		return heroExists;
	}



	/**
	 * Sets the hero exists.
	 *
	 * @param heroExists the new hero exists
	 */
	public void setHeroExists(boolean heroExists) {
		this.heroExists = heroExists;
	}



	/**
	 * Checks if is ogre exists.
	 *
	 * @return true, if is ogre exists
	 */
	public boolean isOgreExists() {
		return ogreExists;
	}



	/**
	 * Sets the ogre exists.
	 *
	 * @param ogreExists the new ogre exists
	 */
	public void setOgreExists(boolean ogreExists) {
		this.ogreExists = ogreExists;
	}



	/**
	 * Checks if is key exists.
	 *
	 * @return true, if is key exists
	 */
	public boolean isKeyExists() {
		return keyExists;
	}



	/**
	 * Sets the key exists.
	 *
	 * @param keyExists the new key exists
	 */
	public void setKeyExists(boolean keyExists) {
		this.keyExists = keyExists;
	}

}
