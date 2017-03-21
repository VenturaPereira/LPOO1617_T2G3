package dkeep.gui;

import javax.swing.JPanel;

import org.imgscalr.Scalr;

import gameLogic.Game;
import gameLogic.MapGame;

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
	private Game game = new Game(1,"Rookie");
	private int offsetW, offsetH, gridH, gridW;
	private BufferedImage guard, hero, sleepyGuard, ogre, wall ,floor, door, openDoor;
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
	}
	
	//redraws the panel, only when requested by SWING
	public void paintComponent(Graphics g){
		super.paintComponent(g); //limpa fundo
		MapGame gamemap = game.getMap1();
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
				}
			}
		}
		for(int i = 0; i < gamemap.getMap().length; i++){
			for(int j = 0; j < gamemap.getMap()[i].length; j++){
        		if(i ==  gamemap.getHero().getHi() && j == gamemap.getHero().getHj()){
        			g.drawImage(hero, j*offsetH, i * offsetW, this);
        		} 
        		if(i == gamemap.getGuard().getI() && j == gamemap.getGuard().getJ()){
        			g.drawImage(guard,  j*offsetH, i * offsetW, this);
        		}
			}
		}
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			game.getMap1().getHero().commandMove((MapGame)game.getMap1(), 'a');
			System.out.println("what");
			break;
		case KeyEvent.VK_RIGHT: 
			game.getMap1().getHero().commandMove((MapGame)game.getMap1(), 'd');  
			break;
		case KeyEvent.VK_UP:  
			game.getMap1().getHero().commandMove((MapGame)game.getMap1(), 'w');
			break;
		case KeyEvent.VK_DOWN: 
			game.getMap1().getHero().commandMove((MapGame)game.getMap1(), 's');
			break;
		}
		game.getMap1().getGuard().enemyMove((MapGame)game.getMap1());
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
