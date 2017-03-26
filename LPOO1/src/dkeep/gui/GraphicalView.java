package dkeep.gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.imgscalr.Scalr;

import gameLogic.Game;
import gameLogic.GameOver;
import gameLogic.Hero;
import gameLogic.Mapa1;
import gameLogic.Mapa2;
import gameLogic.Ogre;
import gameLogic.Orde;
import gameLogic.WinGame;

public class GraphicalView{

	private JFrame frame, initialFrame, editLevel;
	private GamePanel panel;
	private EditGame editPanel = new EditGame(500,500);
	private ImageIcon hero, wall, key, ogre, door;
	private char toAdd;
	private JButton btnUp = new JButton("up");
	private JButton btnDown = new JButton("down");
	private JButton btnLeft = new JButton("left");
	private JButton btnRight = new JButton("right");
	private JButton heroToPress = new JButton();
	private JButton keyToPress = new JButton();
    private JButton ogreToPress = new JButton();
    private JButton doorToPress = new JButton();
    private JButton wallToPress = new JButton();
    private JButton saving = new JButton("Save");
    private Mapa2 map2 = null;
    private boolean clicked = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicalView window = new GraphicalView();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GraphicalView() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	public void checkState(char direction){
	
			
				
				if(panel.getGame().getCurrentMap() instanceof Mapa1){
					panel.getGame().getCurrentMap().getGuard().enemyMove(panel.getGame().getCurrentMap());
					panel.getGame().getCurrentMap().getHero().commandMove(panel.getGame().getCurrentMap(), direction);
				
				
				}else if( panel.getGame().getCurrentMap() instanceof Mapa2){
					panel.getGame().getCurrentMap().getOrde().moveOrde(panel.getGame().getCurrentMap());
					panel.getGame().getCurrentMap().getHero().commandMove(panel.getGame().getCurrentMap(), direction);
					

					}
				panel.repaint();
			}
			
	

	
	private void initialize() throws IOException {
	
		heroToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){toAdd= 'H';editPanel.setToAdd(toAdd);}});
		keyToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){toAdd= 'k';editPanel.setToAdd(toAdd);}});
		ogreToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){toAdd= '0';editPanel.setToAdd(toAdd);}});
		doorToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){toAdd= 'I';editPanel.setToAdd(toAdd);}});
		wallToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){toAdd= 'X';editPanel.setToAdd(toAdd);}});
		
		saving.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e){if(editPanel.isDoorExists() && editPanel.isOgreExists() && editPanel.isHeroExists() && editPanel.isKeyExists()){clicked = true;	map2 = editPanel.getGame().getMap2();	System.out.println(map2.printBoard(map2.getHero(), map2.getOrde()));		editLevel.setVisible(false);	}else {			JOptionPane.showConfirmDialog(editLevel, "Components missing");}	}});
		initialFrame = new JFrame("Welcome");
		
		initialFrame.setContentPane(new JPanel(){
			BufferedImage image = ImageIO.read(new File("images/world-of-warcraft-legion-release-date.jpg"));
			
			public void paintComponent(Graphics g){super.paintComponent(g);g.drawImage(image,0, 0 ,690, 690, this);}});
		
		JButton start = new JButton("Start Game");
		JButton edit = new JButton("Edit Level");
		
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				final String[] mapSizes = {"5", "6", "7" ,"8" ,"9" , "10"};
				int number = Integer.parseInt((String)(JOptionPane.showInputDialog(editLevel, "Choose the squared map sizes", "Size?", JOptionPane.QUESTION_MESSAGE, null ,mapSizes, null)));
                char newmap[][] = new char[number+1][number+1];
                editPanel.getGame().getMap2().setMap(newmap);
				editLevel = new JFrame("Edit this level");	
				editLevel.setTitle("Editing");
				editLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				editLevel.setVisible(true);
				editLevel.getContentPane().setLayout(null);
				editLevel.setBounds(300, 25, 1000, 1000);
				editLevel.setResizable(false);
				hero = new ImageIcon("images/Anduin_wrynn_Cata.png");
				hero = new ImageIcon(hero.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				wall = new ImageIcon("images/images.jpg");
				wall = new ImageIcon(wall.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				ogre = new ImageIcon("images/Guldan_WoD.png");
				ogre = new ImageIcon(ogre.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				key = new ImageIcon("images/TWW_Boss_Key.png");
				key = new ImageIcon(key.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				door = new ImageIcon("images/door.png");
				door = new ImageIcon(door.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			
					heroToPress.setIcon(hero);
					heroToPress.setBounds(800,0 , 100, 100);
					heroToPress.setContentAreaFilled(false);
					heroToPress.setFocusable(false);
					editLevel.add(heroToPress);
					
					keyToPress.setIcon(key);
					keyToPress.setBounds(900, 0 , 100, 100);
					keyToPress.setContentAreaFilled(false);
					keyToPress.setFocusable(false);	
					editLevel.add(keyToPress);
					
					ogreToPress.setIcon(ogre);
					ogreToPress.setBounds(800,100, 100, 100);
					ogreToPress.setContentAreaFilled(false);
					ogreToPress.setFocusable(false);
					editLevel.add(ogreToPress);
					
					doorToPress.setIcon(door);
					doorToPress.setBounds(900,100, 100, 100);
					doorToPress.setContentAreaFilled(false);
					doorToPress.setFocusable(false);
					editLevel.add(doorToPress);
					
					wallToPress.setIcon(wall);
					wallToPress.setBounds(800,200, 100, 100);
					wallToPress.setContentAreaFilled(false);
					wallToPress.setFocusable(false);
					editLevel.add(wallToPress);
					
					saving.setBounds(900, 350, 100,50);
	
					editLevel.add(saving);
				editPanel.setBounds(0, 0, 1000,1000);
				editLevel.getContentPane().add(editPanel);
				
				
			}
		});
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String[] guards = {"Suspicious", "Rookie", "Drunken"};
				String name = (String)JOptionPane.showInputDialog(frame, "Choose the Guard", "What Guard?",JOptionPane.QUESTION_MESSAGE, null, guards, null);
				JFrame infoNext  = new JFrame("info");
				int number = 0;
				if(clicked == false ){
				while((number == 0 || number > 5)){
				 number = Integer.parseInt(JOptionPane.showInputDialog(infoNext, "Choose the number of Ogres.", "Number of Ogres?", JOptionPane.WARNING_MESSAGE));
				}}
				frame = new JFrame();
				btnLeft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {checkState('a');panel.requestFocusInWindow();
					}
				});
				btnLeft.setEnabled(true);
				btnLeft.setBounds(750, 150, 100, 50);
				frame.getContentPane().add(btnLeft);
				
				btnRight.setEnabled(true);
				btnRight.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { checkState('d'); panel.requestFocusInWindow();}
				});
				btnRight.setBounds(850, 150, 100, 50);
				frame.getContentPane().add(btnRight);
				
				btnDown.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {checkState('s');panel.requestFocusInWindow();}
				});
				btnDown.setEnabled(true);
				btnDown.setBounds(800, 200, 100, 50);
				frame.getContentPane().add(btnDown);
				
				btnUp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {checkState('w');panel.requestFocusInWindow();}
				});
				btnUp.setEnabled(true);
				btnUp.setBounds(800, 100, 100, 50);
				frame.getContentPane().add(btnUp);
				frame.setTitle("World of Warcraft : Legion");
				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(false);
				frame.getContentPane().setLayout(null);
				frame.setBounds(300, 25, 1000, 1000);
				frame.setResizable(false);
				try {
					panel = new GamePanel(600,600);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				panel.setBounds(0, 0, 1000,1000);
				if(map2 != null){
					Orde orde= new Orde(0);
					 Hero heroo= new Hero();
					for(int i = 0; i < map2.getMap().length; i++){
						for(int j=0; j < map2.getMap()[0].length; j++){
							if(map2.getMap()[i][j] == '0'){
								editPanel.getGame().getMap2().getMap()[i][j] = ' ';
								Ogre ogre= new Ogre();
								ogre.setI(i);
								ogre.setJ(j);
								if(i == map2.getMap().length-2 && j == map2.getMap()[1].length-2){ogre.setWeaponI(i-1); ogre.setWeaponJ(j);}
								else if(i == 1 && j ==1){ogre.setWeaponI(i);ogre.setWeaponJ(j+1);}
								else if(i == 1 && j == map2.getMap()[1].length-2){ogre.setWeaponI(i+1);ogre.setWeaponJ(j);}
								else if(i == map2.getMap().length-2 && j == 1){ogre.setWeaponI(i);ogre.setWeaponJ(j+1);}
								else if(i == map2.getMap().length-2 || i == 1){ogre.setWeaponI(i);ogre.setWeaponJ(j+1);}
								else if(j == map2.getMap()[1].length-1 || j == 1){ogre.setWeaponI(i+1);ogre.setWeaponJ(j);}
								else{ogre.setWeaponI(i+1);ogre.setWeaponJ(j);}
							orde.getOrde().add(ogre);
							}
							if(map2.getMap()[i][j] == 'H'){editPanel.getGame().getMap2().getMap()[i][j] = ' ';heroo.setHi(i);heroo.setHj(j);}
						}
					}
				
					editPanel.getGame().setOrde(orde);
					for(int b =0; b < orde.getOrde().size(); b++){
						System.out.println(editPanel.getGame().getOrde().getOrde().get(b).getI() +" , "+ editPanel.getGame().getOrde().getOrde().get(b).getJ());
					}
				    panel.setGame(new Game(orde.getOrde().size(), name));
					panel.getGame().getMap2().setMap(editPanel.getGame().getMap2().getMap());
					panel.getGame().getMap2().setHero(heroo);
					panel.getGame().getMap2().setOrde(orde);
					panel.getGame().setGameOverlvl2(new GameOver(panel.getGame().getMap2().getHero(),  panel.getGame().getMap2().getOrde(), panel.getGame().getMap2()));
					
				}
				else{panel.setGame(new Game(number, name));}
				frame.getContentPane().add(panel);
				System.out.println(panel.getGame().getMap2().printBoard(panel.getGame().getMap2().getHero(), (panel.getGame().getMap2().getOrde())));
				panel.setFocusable(true);
				panel.requestFocusInWindow();
				initialFrame.setVisible(false);
				frame.setVisible(true);
			}	
			});
		initialFrame.getContentPane().add(start);
		initialFrame.getContentPane().add(edit);
		
		initialFrame.setBounds(300, 25, 700, 700);
		initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialFrame.setVisible(true);
		}

}
