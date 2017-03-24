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

public class EditGame extends JPanel implements MouseListener {
	private int offsetW, offsetH, gridH, gridW;
	private Game game = new Game(0,"Rookie");
	private BufferedImage wall, floor, door, ogre, weapon, key, hero;
	private char toAdd;

	
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int i = (e.getX())/offsetW;
		int j =   (e.getY())/offsetH;
		game.getMap2().getMap()[j][i] = getToAdd();
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public Game getGame() {
		return game;
	}



	public void setGame(Game game) {
		this.game = game;
	}



	public char getToAdd() {
		return toAdd;
	}



	public void setToAdd(char toAdd) {
		this.toAdd = toAdd;
	}

}
