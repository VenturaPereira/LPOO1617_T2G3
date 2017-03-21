package dkeep.gui;

import javax.swing.JPanel;

import org.imgscalr.Scalr;

import gameLogic.Game;
import gameLogic.MapGame;
import gameLogic.Mapa1;
import gameLogic.Mapa2;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class GamePanel extends JPanel  implements MouseListener, MouseMotionListener, KeyListener{
   //coordenadas do "bounding rectangle" do eclipse
	private int x1 = 0, y1 = 0, x2 =0, y2=0;
	private Game game = new Game(2,"Rookie");
	private int offsetW, offsetH, gridH, gridW;
	private BufferedImage pickedHero, key, weapon, guard, hero, sleepyGuard, ogre, wall ,floor, door, openDoor, pulledLever, notPulledLever;
	//construtor que adiciona listeners para o rato e teclado
	
	public GamePanel(int width, int height) throws IOException{
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		gridH = game.getMap1().getMap()[0].length;
		gridW = game.getMap1().getMap().length;
		offsetW = Math.round(width / gridW);
		offsetH = Math.round(height/gridH);
		
		this.hero = Scalr.resize(ImageIO.read(new File("images/Anduin_wrynn_Cata.png")), offsetW);
		this.floor = Scalr.resize(ImageIO.read(new File("images/floor.jpg")), Scalr.Mode.FIT_EXACT, offsetW);
		this.wall = Scalr.resize(ImageIO.read(new File("images/images.jpg")), Scalr.Mode.FIT_EXACT, offsetW);
		this.openDoor = Scalr.resize(ImageIO.read(new File("images/CastleDoor1.png")), offsetW);
		this.door = Scalr.resize(ImageIO.read(new File("images/door.png")), Scalr.Mode.FIT_TO_HEIGHT, offsetW);
		this.guard = Scalr.resize(ImageIO.read(new File("images/rookie.png")), offsetW);
		this.pulledLever = Scalr.resize(ImageIO.read(new File("images/pulled.png")), offsetW);
		this.notPulledLever = Scalr.resize(ImageIO.read(new File("images/not_pulled.png")), offsetW);
		this.ogre = Scalr.resize(ImageIO.read(new File("images/guldan_WoD.png")), offsetW);
		this.weapon = Scalr.resize(ImageIO.read(new File("images/weapon.png")), offsetW);
		this.key = Scalr.resize(ImageIO.read(new File("images/TWW_Boss_Key.png")), offsetW);
		this.pickedHero = Scalr.resize(ImageIO.read(new File("images/picked_Key.png")), offsetW);
	}
	
	//redraws the panel, only when requested by SWING
	public void paintComponent(Graphics g){
		super.paintComponent(g); //limpa fundo
		MapGame gamemap = game.getCurrentMap();
		//g.fillOval(x1, y1, x2-x1 +1, y2 - y1 +1);
		//drawing floor
		for(int i = 0; i < gridH; i++){
			for(int j = 0; j < gridH; j++){
				g.drawImage(floor, i * offsetW, j * offsetH, this);
			}
		}
		//drawing components
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
				
				case 'S':
					g.drawImage(openDoor, j* offsetH, i* offsetW, this);
					break;
					
				case 'k':
					if(!gamemap.getHero().getPickedKey()){
					g.drawImage(key , j* offsetH, i* offsetW,this);
					}
				}
			}
		}
		//draw hero, guard, ogre and weapon
		for(int i = 0; i < gamemap.getMap().length; i++){
			for(int j = 0; j < gamemap.getMap()[i].length; j++){
        		if(i ==  gamemap.getHero().getHi() && j == gamemap.getHero().getHj()){
        			System.out.println(gamemap.getHero().getPickedKey());
        			if(!gamemap.getHero().getPickedKey()){
        			g.drawImage(hero, j*offsetH, i * offsetW, this);
        			}
        			else if(gamemap instanceof Mapa2){
        				g.drawImage(pickedHero, j*offsetH, i * offsetW, this);
        			}
        		} 
        		if(gamemap instanceof Mapa1){
        		if(i == gamemap.getGuard().getI() && j == gamemap.getGuard().getJ()){
        			g.drawImage(guard,  j*offsetH, i * offsetW, this);
        		}
        		if(i == 8 && j == 7 && gamemap.getMap()[5][0] == 'I'){
        			
        				g.drawImage(notPulledLever, j* offsetH, i* offsetW, this);
        		}else if(gamemap.getMap()[5][0] == 'S' && i == 8 && j == 7){
        			
    				g.drawImage(pulledLever, j* offsetH, i* offsetW, this);
        			
    			}
        		}
        		else if(gamemap instanceof Mapa2){
        		 for(int a =0; a < gamemap.getOrde().getOrde().size(); a++){
        			 if(gamemap.getOrde().getOrde().get(a).getI() == i && j ==gamemap.getOrde().getOrde().get(a).getJ() ){
        				 g.drawImage(ogre, j* offsetH, i* offsetW, this);
        			 }
        			 if(gamemap.getOrde().getOrde().get(a).getWeaponI() == i && gamemap.getOrde().getOrde().get(a).getWeaponJ() == j){
        				 g.drawImage(weapon, j* offsetH, i* offsetW, this);
        			 }
        		 }
        		}
			}
		}
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			game.getCurrentMap().getHero().commandMove(game.getCurrentMap(), 'a');
			System.out.println("what");
			break;
		case KeyEvent.VK_RIGHT: 
			game.getCurrentMap().getHero().commandMove(game.getCurrentMap(), 'd');  
			break;
		case KeyEvent.VK_UP:  
			game.getCurrentMap().getHero().commandMove(game.getCurrentMap(), 'w');
			break;
		case KeyEvent.VK_DOWN: 
			game.getCurrentMap().getHero().commandMove(game.getCurrentMap(), 's');
			break;
		}
		if(game.getCurrentMap() instanceof Mapa1){
		game.getCurrentMap().getGuard().enemyMove(game.getCurrentMap());
		}else if(game.getCurrentMap() instanceof Mapa2){
			game.getCurrentMap().getOrde().moveOrde(game.getCurrentMap());
		}
		repaint();
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		x2 = x1 = e.getX();
		y2 = y1 = e.getY();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
