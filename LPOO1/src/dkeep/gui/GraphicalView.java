package dkeep.gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameLogic.Game;

public class GraphicalView{

	private JFrame frame, initialFrame;
	private GamePanel panel;

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
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame info = new JFrame("Information");
				String name = JOptionPane.showInputDialog(frame, "Choose the Guard", "What Guard?",JOptionPane.WARNING_MESSAGE);
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
		initialFrame.add(start);
		
		initialFrame.setBounds(300, 25, 700, 700);
		initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialFrame.setVisible(true);
		
		 
		
	}

}
