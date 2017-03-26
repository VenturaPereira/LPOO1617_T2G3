package dkeep.gui;

import javax.swing.JPanel;

import org.imgscalr.Scalr;

import gameLogic.Drunken;
import gameLogic.Game;
import gameLogic.MapGame;
import gameLogic.Mapa1;
import gameLogic.Mapa2;
import gameLogic.Rookie;
import gameLogic.Suspicious;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


// TODO: Auto-generated Javadoc
/**
 * The Class GamePanel.
 */
public class GamePanel extends JPanel  implements MouseListener, MouseMotionListener, KeyListener{
   
   /** The y 2. */
   //coordenadas do "bounding rectangle" do eclipse
	private int x1 = 0, y1 = 0, x2 =0, y2=0;
	
	/** The game. */
	private Game game = new Game(2,"Rookie");
	
	/** The grid W. */
	private int offsetW, offsetH, gridH, gridW;
	
	/** The not pulled lever. */
	private BufferedImage win, stunnedOgre, suspicious, defeat, pickedHero, key, weapon, guard, hero, sleepyGuard, ogre, wall ,floor, door, openDoor, pulledLever, notPulledLever;
	//construtor que adiciona listeners para o rato e teclado
	
	/**
	 * Instantiates a new game panel.
	 *
	 * @param width the width
	 * @param height the height
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public GamePanel(int width, int height) throws IOException{
		
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		gridH = getGame().getCurrentMap().getMap()[0].length;
		gridW = getGame().getCurrentMap().getMap().length;
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
		this.defeat = Scalr.resize(ImageIO.read(new File("images/newGameover.jpg")), Scalr.Mode.FIT_TO_WIDTH, 600, 100);
		this.sleepyGuard = Scalr.resize(ImageIO.read(new File("images/sleepGuard.png")), offsetW);
		this.suspicious = Scalr.resize(ImageIO.read(new File("images/Voljin_MoP.png")), offsetW);
		this.stunnedOgre =Scalr.resize(ImageIO.read(new File("images/stunnedOgre.png")), offsetW);
		this.win = Scalr.resize(ImageIO.read(new File("images/win1.png")), Scalr.Mode.FIT_TO_WIDTH, 600, 600);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	//redraws the panel, only when requested by SWING
	public void paintComponent(Graphics g){
	//	super.paintComponent(g); //limpa fundo
		
		MapGame gamemap = getGame().getCurrentMap();
	
			
		
		
		//drawing floor
		
		for(int i = 0; i < gamemap.getMap().length; i++){
			for(int j = 0; j < gamemap.getMap()[0].length; j++){
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
        			System.out.println(gamemap.isArrived());
        			g.drawImage(hero, j*offsetH, i * offsetW, this);
        			 if(gamemap instanceof Mapa2){
        				if(gamemap.getHero().getHi() == 1 && gamemap.getHero().getHj() == 7){
        					gamemap.pickKey();
        				}
        				if(gamemap.getHero().getPickedKey()){
        				g.drawImage(pickedHero, j*offsetH, i * offsetW, this);
        			} else{
        				g.drawImage(hero, j*offsetH, i * offsetW, this);
        			}
        		} 
        		}
        		if(gamemap instanceof Mapa1){
        		if(gamemap.getGuard() instanceof Rookie){	
        		if(i == gamemap.getGuard().getI() && j == gamemap.getGuard().getJ()){
        			g.drawImage(guard,  j*offsetH, i * offsetW, this);
        		}
        		}else if(gamemap.getGuard() instanceof Suspicious){
            		if(i == gamemap.getGuard().getI() && j == gamemap.getGuard().getJ()){
            			g.drawImage(suspicious,  j*offsetH, i * offsetW, this);		
        		}
        		}else if(gamemap.getGuard() instanceof Drunken){
        			if(i == gamemap.getGuard().getI() && j == gamemap.getGuard().getJ()){
        				if(gamemap.getGuard().isSleeping()){
            			g.drawImage(sleepyGuard,  j*offsetH, i * offsetW, this);		
        				}else{
        					g.drawImage(guard,  j*offsetH, i * offsetW, this);
        				}
        		}
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
        				 if(gamemap.getOrde().getOrde().get(a).getStunned() == 0){
        				 g.drawImage(ogre, j* offsetH, i* offsetW, this);
        				 }else{
        					 g.drawImage(stunnedOgre, j* offsetH, i* offsetW, this);
        				 }
        			 }
        			 if(gamemap.getOrde().getOrde().get(a).getWeaponI() == i && gamemap.getOrde().getOrde().get(a).getWeaponJ() == j){
        				 g.drawImage(weapon, j* offsetH, i* offsetW, this);
        				 System.out.println(i +"," + j);
  
        			 }
        		 }
        		}
			}
		}
		if(gamemap instanceof Mapa1){
			if(getGame().getGameOver().getGameOver(gamemap)){
					g.drawImage(defeat,gridH, gridW, this);
					
				}
			}else if(gamemap instanceof Mapa2){
				System.out.println(gamemap.getOrde().getOrde().size());
				if(getGame().getGameOverlvl2().getGameOver(gamemap)){
					System.out.println("bug");
					g.drawImage(defeat,gridH, gridW, this);
				}
			}
		if(gamemap instanceof Mapa2){
			if(getGame().getWinlvl2().getWin()){
				g.drawImage(win,gridH, gridW, this);
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			getGame().getCurrentMap().getHero().commandMove(getGame().getCurrentMap(), 'a');
			if(getGame().getCurrentMap() instanceof Mapa1){
				getGame().getCurrentMap().getGuard().enemyMove(getGame().getCurrentMap());
				}else if(getGame().getCurrentMap() instanceof Mapa2){
					getGame().getCurrentMap().getOrde().moveOrde(getGame().getCurrentMap());
					getGame().getStun().stun();
				}
			break;
		case KeyEvent.VK_RIGHT: 
			getGame().getCurrentMap().getHero().commandMove(getGame().getCurrentMap(), 'd');  
			if(getGame().getCurrentMap() instanceof Mapa1){
				getGame().getCurrentMap().getGuard().enemyMove(getGame().getCurrentMap());
				}else if(getGame().getCurrentMap() instanceof Mapa2){
					getGame().getCurrentMap().getOrde().moveOrde(getGame().getCurrentMap());
					getGame().getStun().stun();
				}
			break;
		case KeyEvent.VK_UP:  
			getGame().getCurrentMap().getHero().commandMove(getGame().getCurrentMap(), 'w');
			if(getGame().getCurrentMap() instanceof Mapa1){
				getGame().getCurrentMap().getGuard().enemyMove(getGame().getCurrentMap());
				}else if(getGame().getCurrentMap() instanceof Mapa2){
					getGame().getCurrentMap().getOrde().moveOrde(getGame().getCurrentMap());
					getGame().getStun().stun();
				}
			break;
		case KeyEvent.VK_DOWN: 
			getGame().getCurrentMap().getHero().commandMove(getGame().getCurrentMap(), 's');
			if(getGame().getCurrentMap() instanceof Mapa1){
				getGame().getCurrentMap().getGuard().enemyMove(getGame().getCurrentMap());
				}else if(getGame().getCurrentMap() instanceof Mapa2){
					getGame().getCurrentMap().getOrde().moveOrde(getGame().getCurrentMap());
					getGame().getStun().stun();
				}
			break;
		}
		
		repaint();
		}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		repaint();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = x1 = e.getX();
		y2 = y1 = e.getY();
		repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}
