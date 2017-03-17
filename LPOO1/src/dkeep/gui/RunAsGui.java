package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

import gameLogic.GameOver;
import gameLogic.Levels;
import gameLogic.Mapa1;
import gameLogic.WinGame;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;

public class RunAsGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunAsGui window = new RunAsGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RunAsGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.setBounds(323, 84, 60, 23);
		frame.getContentPane().add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setEnabled(false);
		btnLeft.setBounds(287, 118, 60, 23);
		frame.getContentPane().add(btnLeft);
		
		JButton btnNewButton = new JButton("Right");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(357, 118, 67, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDown = new JButton("Down");
		btnDown.setEnabled(false);
		btnDown.setBounds(322, 152, 72, 23);
		frame.getContentPane().add(btnDown);
		
		JLabel lblEnt = new JLabel("Number Of Ogres");
		lblEnt.setBounds(10, 11, 102, 14);
		frame.getContentPane().add(lblEnt);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(122, 5, 21, 20);
		frame.getContentPane().add(textPane);
		
		JLabel lblGuardPersonalty = new JLabel("Guard personality");
		lblGuardPersonalty.setBounds(10, 36, 102, 14);
		frame.getContentPane().add(lblGuardPersonalty);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 36, 72, 20);
		frame.getContentPane().add(comboBox);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(323, 227, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(20, 76, 246, 161);
		frame.getContentPane().add(textArea);
		
		
		JLabel lblPressNewGame = new JLabel("Press New Game to play");
		lblPressNewGame.setBounds(10, 236, 194, 14);
		frame.getContentPane().add(lblPressNewGame);
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Levels leveling = new Levels();
				Mapa1 map1= new Mapa1(leveling);
				map1.setRunning(true);
				GameOver game= new GameOver(map1.getHero(), map1.getGuard(), map1);
				WinGame win = new WinGame(map1);
				textArea.setText(map1.printBoard(map1.getHero(), map1.getGuard()));
				
				
			}
		});
		btnNewGame.setBounds(305, 32, 119, 23);
		frame.getContentPane().add(btnNewGame);
	}
}
