package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

import gameLogic.Drunken;
import gameLogic.Enemy;
import gameLogic.GameOver;
import gameLogic.Levels;
import gameLogic.Mapa1;
import gameLogic.Mapa2;
import gameLogic.Orde;
import gameLogic.Rookie;
import gameLogic.Suspicious;
import gameLogic.WinGame;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;

public class RunAsGui {
    
	private JFrame frame;
	private Levels leveling;

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
		
		
		
		
		JLabel lblPressNewGame = new JLabel("Press New Game to play");
		lblPressNewGame.setBounds(10, 236, 194, 14);
		frame.getContentPane().add(lblPressNewGame);
		
		
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
		comboBox.addItem("Suspicious");
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(132, 36, 94, 20);
		
		frame.getContentPane().add(comboBox);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(323, 227, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(20, 76, 246, 161);
		frame.getContentPane().add(textArea);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					for(int i =0; i < leveling.getLevels().size(); i++){
						if(leveling.getLevels().get(i).getRunning()){
							WinGame win = new WinGame(leveling.getLevels().get(i));

							
							if(leveling.getLevels().get(i) instanceof Mapa1){
								GameOver gmae = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard(), leveling.getLevels().get(i));
							leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), 'a');
							leveling.getLevels().get(i).getGuard().enemyMove(leveling.getLevels().get(i));
							if(gmae.getGameOver(leveling.getLevels().get(i))){	
								textArea.setText("You looooost, noob");
								lblPressNewGame.setText("You were defeated");
							}
								else if(win.getWin()){
									int a = i+1;
									textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));
								}
								else{
									textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard()));
									}

							}
							else if( leveling.getLevels().get(i) instanceof Mapa2){
								GameOver lvltwo = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde(), leveling.getLevels().get(i));
								leveling.getLevels().get(i).getOrde().moveOrde(leveling.getLevels().get(i));
								leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), 'a');
								if(lvltwo.getGameOver(leveling.getLevels().get(i))){	
									textArea.setText("You looooost, noob");
									lblPressNewGame.setText("You were defeated");
								}
									else if(win.getWin()){
										int a = i+1;
										textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));
									}
									else{
										textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde()));
										}

								}
							
							
							
							break;
						}
						
					}
				
				
			}
		});
		btnLeft.setEnabled(false);
		btnLeft.setBounds(287, 118, 60, 23);
		frame.getContentPane().add(btnLeft);
		
		
		JButton btnRight = new JButton("Right");
		btnRight.setEnabled(false);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i =0; i < leveling.getLevels().size(); i++){
					if(leveling.getLevels().get(i).getRunning()){
						WinGame win = new WinGame(leveling.getLevels().get(i));

						
						if(leveling.getLevels().get(i) instanceof Mapa1){
							GameOver gmae = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard(), leveling.getLevels().get(i));
						leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), 'd');
						leveling.getLevels().get(i).getGuard().enemyMove(leveling.getLevels().get(i));
						if(gmae.getGameOver(leveling.getLevels().get(i))){	
							textArea.setText("You looooost, noob");
							lblPressNewGame.setText("You were defeated");
						}
							else if(win.getWin()){
								int a = i+1;
								textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));
							}
							else{
								textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard()));
								}

						}
						else if( leveling.getLevels().get(i) instanceof Mapa2){
							GameOver lvltwo = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde(), leveling.getLevels().get(i));
							leveling.getLevels().get(i).getOrde().moveOrde(leveling.getLevels().get(i));
							leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), 'd');
							if(lvltwo.getGameOver(leveling.getLevels().get(i))){	
								textArea.setText("You looooost, noob");
								lblPressNewGame.setText("You were defeated");
							}
								else if(win.getWin()){
									int a = i+1;
									textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));
								}
								else{
									textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde()));
									}

							}
						
						
						
						break;
					}
					
				}
				}
		});
		btnRight.setBounds(357, 118, 67, 23);
		frame.getContentPane().add(btnRight);
		
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i =0; i < leveling.getLevels().size(); i++){
					if(leveling.getLevels().get(i).getRunning()){
						WinGame win = new WinGame(leveling.getLevels().get(i));

						
						if(leveling.getLevels().get(i) instanceof Mapa1){
							GameOver gmae = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard(), leveling.getLevels().get(i));
						leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), 's');
						leveling.getLevels().get(i).getGuard().enemyMove(leveling.getLevels().get(i));
						if(gmae.getGameOver(leveling.getLevels().get(i))){	
							textArea.setText("You looooost, noob");
							lblPressNewGame.setText("You were defeated");
						}
							else if(win.getWin()){
								int a = i+1;
								textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));
							}
							else{
								textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard()));
								}

						}
						else if( leveling.getLevels().get(i) instanceof Mapa2){
							GameOver lvltwo = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde(), leveling.getLevels().get(i));
							leveling.getLevels().get(i).getOrde().moveOrde(leveling.getLevels().get(i));
							leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), 's');
							if(lvltwo.getGameOver(leveling.getLevels().get(i))){	
								textArea.setText("You looooost, noob");
								lblPressNewGame.setText("You were defeated");
							}
								else if(win.getWin()){
									int a = i+1;
									textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));
								}
								else{
									textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde()));
									}

							}
						
						
						
						break;
					}
					
				}
					}
		});
		btnDown.setEnabled(false);
		btnDown.setBounds(322, 152, 72, 23);
		frame.getContentPane().add(btnDown);
		
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i =0; i < leveling.getLevels().size(); i++){
					if(leveling.getLevels().get(i).getRunning()){
						WinGame win = new WinGame(leveling.getLevels().get(i));

						
						if(leveling.getLevels().get(i) instanceof Mapa1){
							GameOver gmae = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard(), leveling.getLevels().get(i));
						leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), 'w');
						leveling.getLevels().get(i).getGuard().enemyMove(leveling.getLevels().get(i));
						if(gmae.getGameOver(leveling.getLevels().get(i))){	
							textArea.setText("You looooost, noob");
							lblPressNewGame.setText("You were defeated");
						}
							else if(win.getWin()){
								int a = i+1;
								textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));
							}
							else{
								textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard()));
								}

						}
						else if( leveling.getLevels().get(i) instanceof Mapa2){
							GameOver lvltwo = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde(), leveling.getLevels().get(i));
							leveling.getLevels().get(i).getOrde().moveOrde(leveling.getLevels().get(i));
							leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), 'w');
							if(lvltwo.getGameOver(leveling.getLevels().get(i))){	
								textArea.setText("You looooost, noob");
								lblPressNewGame.setText("You were defeated");
							}
								else if(win.getWin()){
									int a = i+1;
									textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));
								}
								else{
									textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde()));
									}

							}
						
						
						
						break;
					}
					
				}
							}
					
		});
		btnUp.setEnabled(false);
		btnUp.setBounds(323, 84, 60, 23);
		frame.getContentPane().add(btnUp);
		
		
		
		
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblPressNewGame.setText("You can now play");
				btnRight.setEnabled(true);
				btnUp.setEnabled(true);
				btnLeft.setEnabled(true);
				btnDown.setEnabled(true);
				leveling = new Levels();
				Mapa1 map1= new Mapa1(leveling);
				String name = comboBox.getSelectedItem().toString();
				switch(name){
				case "Suspicious":
					Enemy guard = new Suspicious();
					map1.setGuard(guard);
					break;
				case "Drunken":
					Enemy guard1 = new Drunken();
					map1.setGuard(guard1);
					break;
				case "Rookie":
					Enemy guard2 = new Rookie();
					map1.setGuard(guard2);
					break;
				
				}
				
				Mapa2 map2 = new Mapa2(leveling);
				int number = Integer.parseInt(textPane.getText());
				Orde orde = new Orde(number);
				map2.setOrde(orde);
				map1.setRunning(true);
				textArea.setText(map1.printBoard(map1.getHero(), map1.getGuard()));
				
			}
		});
		btnNewGame.setBounds(305, 32, 119, 23);
		frame.getContentPane().add(btnNewGame);
	}

	public Levels getMaps() {
		return leveling;
	}

	public void setMaps(Levels maps) {
		this.leveling = maps;
	}
}
