package dkeep.gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameLogic.Game;

public class GraphicalView{

	private JFrame frame, initialFrame, editLevel;
	private GamePanel panel;
	private EditGame editPanel = new EditGame(500,500);
	private ImageIcon hero, wall, key, ogre, door;

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
				JButton heroToPress = new JButton();
					heroToPress.setIcon(hero);
					heroToPress.setBounds(500,0 , 100, 100);
					heroToPress.setContentAreaFilled(false);
					heroToPress.setFocusable(false);
					editLevel.add(heroToPress);
					JButton keyToPress = new JButton();
					keyToPress.setIcon(key);
					keyToPress.setBounds(600, 0 , 100, 100);
					keyToPress.setContentAreaFilled(false);
					keyToPress.setFocusable(false);	
					editLevel.add(keyToPress);
					JButton ogreToPress = new JButton();
					ogreToPress.setIcon(ogre);
					ogreToPress.setBounds(500,100, 100, 100);
					ogreToPress.setContentAreaFilled(false);
					ogreToPress.setFocusable(false);
					editLevel.add(ogreToPress);
					JButton doorToPress = new JButton();
					doorToPress.setIcon(door);
					doorToPress.setBounds(600,100, 100, 100);
					doorToPress.setContentAreaFilled(false);
					doorToPress.setFocusable(false);
					editLevel.add(doorToPress);
					JButton wallToPress = new JButton();
					wallToPress.setIcon(wall);
					wallToPress.setBounds(500,200, 100, 100);
					wallToPress.setContentAreaFilled(false);
					wallToPress.setFocusable(false);
					editLevel.add(wallToPress);
					
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
				panel.setGame(new Game(number, name));
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
