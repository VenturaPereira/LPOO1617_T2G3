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
import gameLogic.Mapa2;
import gameLogic.Ogre;
import gameLogic.Orde;

public class GraphicalView{

	private JFrame frame, initialFrame, editLevel;
	private GamePanel panel;
	private EditGame editPanel = new EditGame(500,500);
	private ImageIcon hero, wall, key, ogre, door;
	private char toAdd;
	private JButton heroToPress = new JButton();
	private JButton keyToPress = new JButton();
    private JButton ogreToPress = new JButton();
    private JButton doorToPress = new JButton();
    private JButton wallToPress = new JButton();
    private JButton saving = new JButton("Save");
    private Mapa2 map2 = null;
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
	private void initialize() throws IOException {
		
		
		heroToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				toAdd= 'H';
				editPanel.setToAdd(toAdd);
			}
			});
		keyToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				toAdd= 'k';
				editPanel.setToAdd(toAdd);
			}
			});
		ogreToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				toAdd= '0';
				editPanel.setToAdd(toAdd);
			}
			});
		doorToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				toAdd= 'I';
				editPanel.setToAdd(toAdd);
			}
			});
		wallToPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				toAdd= 'X';
				editPanel.setToAdd(toAdd);
			}
			});
		
		saving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				map2 = editPanel.getGame().getMap2();
				System.out.println(map2.printBoard(map2.getHero(), map2.getOrde()));
				editLevel.setVisible(false);
			}
			});
		initialFrame = new JFrame("Welcome");
		
		initialFrame.setContentPane(new JPanel(){
			BufferedImage image = ImageIO.read(new File("images/world-of-warcraft-legion-release-date.jpg"));
			
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(image,0, 0 ,690, 690, this);
			}
		});
		

		JButton start = new JButton("Start Game");
		JButton edit = new JButton("Edit Level");
		
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				final String[] mapSizes = {"5", "6", "7" ,"8" ,"9" , "10" , "11" , "12"};
				int number = Integer.parseInt((String)(JOptionPane.showInputDialog(editLevel, "Choose the squared map sizes", "Size?", JOptionPane.QUESTION_MESSAGE, null ,mapSizes, null)));
                char newmap[][] = new char[number+1][number+1];
                editPanel.getGame().getMap2().setMap(newmap);
				editLevel = new JFrame("Edit this level");	
				editLevel.setTitle("Editing");
				editLevel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				editLevel.setVisible(true);
				editLevel.getContentPane().setLayout(null);
				editLevel.setBounds(300, 25, 700, 525);
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
					heroToPress.setBounds(500,0 , 100, 100);
					heroToPress.setContentAreaFilled(false);
					heroToPress.setFocusable(false);
					
					
					
					
					editLevel.add(heroToPress);
					
					keyToPress.setIcon(key);
					keyToPress.setBounds(600, 0 , 100, 100);
					keyToPress.setContentAreaFilled(false);
					keyToPress.setFocusable(false);	
					editLevel.add(keyToPress);
					
					ogreToPress.setIcon(ogre);
					ogreToPress.setBounds(500,100, 100, 100);
					ogreToPress.setContentAreaFilled(false);
					ogreToPress.setFocusable(false);
					editLevel.add(ogreToPress);
					
					doorToPress.setIcon(door);
					doorToPress.setBounds(600,100, 100, 100);
					doorToPress.setContentAreaFilled(false);
					doorToPress.setFocusable(false);
					editLevel.add(doorToPress);
					
					wallToPress.setIcon(wall);
					wallToPress.setBounds(500,200, 100, 100);
					wallToPress.setContentAreaFilled(false);
					wallToPress.setFocusable(false);
					editLevel.add(wallToPress);
					
					saving.setBounds(500, 350, 100,50);
	
					editLevel.add(saving);
				editPanel.setBounds(0, 0, 700,700);
				editLevel.getContentPane().add(editPanel);
				
				
			}
		});
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String[] guards = {"Suspicious", "Rookie", "Drunken"};
				String name = (String)JOptionPane.showInputDialog(frame, "Choose the Guard", "What Guard?",JOptionPane.QUESTION_MESSAGE, null, guards, null);
				JFrame infoNext  = new JFrame("info");
				int number = Integer.parseInt(JOptionPane.showInputDialog(infoNext, "Choose the number of Ogres.", "Number of Ogres?", JOptionPane.WARNING_MESSAGE));
				frame = new JFrame();
				frame.setTitle("World of Warcraft : Legion");
				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(false);
				frame.getContentPane().setLayout(null);
				frame.setBounds(300, 25, 700, 700);
				frame.setResizable(false);
				try {
					panel = new GamePanel(700,700);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel.setBounds(0, 0, 700,700);
				
			//	panel.setGame(new Game(number, name));
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
								if(i == map2.getMap().length-2 && j == map2.getMap()[1].length-2){
									ogre.setWeaponI(i-1);
									ogre.setWeaponJ(j);
								}else if(i == 1 && j ==1){
									ogre.setWeaponI(i);
									ogre.setWeaponJ(j+1);
								}else if(i == 1 && j == map2.getMap()[1].length-2){
									ogre.setWeaponI(i+1);
									ogre.setWeaponJ(j);
								}else if(i == map2.getMap().length-2 && j == 1){
									ogre.setWeaponI(i);
									ogre.setWeaponJ(j+1);
								}else if(i == map2.getMap().length-2 || i == 1){
									ogre.setWeaponI(i);
									ogre.setWeaponJ(j+1);
								}else if(j == map2.getMap()[1].length-1 || j == 1){
									ogre.setWeaponI(i+1);
									ogre.setWeaponJ(j);
								}else{
									ogre.setWeaponI(i+1);
									ogre.setWeaponJ(j);
								}
							//	System.out.println(i);
								//System.out.println(j);
								orde.getOrde().add(ogre);
							}
							if(map2.getMap()[i][j] == 'H'){
								editPanel.getGame().getMap2().getMap()[i][j] = ' ';
                                
								  heroo.setHi(i);
								
								  heroo.setHj(j);
								
								
							}
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
				else{
					panel.setGame(new Game(number, name));
				}
				//System.out.println(panel.getGame().getMap2().printBoard(panel.getGame().getMap2().getHero(), panel.getGame().getOrde()));
				frame.getContentPane().add(panel);
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
