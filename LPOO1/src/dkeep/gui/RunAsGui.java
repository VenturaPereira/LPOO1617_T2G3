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


/**
 * The Class RunAsGui.
 */
public class RunAsGui {
    
	/** The frame. */
	private JFrame frame;
	
	/** The leveling. */
	private Levels leveling;
	
	/** The lost. */
	public boolean lost = false;
	
	/** The btn new game. */
	JButton btnNewGame = new JButton("New Game");
	
	/** The btn right. */
	JButton btnRight = new JButton("Right");
	
	/** The lbl press new game. */
	JLabel lblPressNewGame = new JLabel("Press New Game to play");
	
	/** The btn left. */
	JButton btnLeft = new JButton("Left");
	
	/** The lbl ent. */
	JLabel lblEnt = new JLabel("Number Of Ogres");
	
	/** The text pane. */
	JTextPane textPane = new JTextPane();
	
	/** The btn exit. */
	JButton btnExit = new JButton("Exit");
	
	/** The btn down. */
	JButton btnDown = new JButton("Down");
	
	/** The btn up. */
	JButton btnUp = new JButton("Up");
	
	/** The text area. */
	JTextArea textArea = new JTextArea();








	/**
	 * Launch the application.
	 *
	 * @param args the arguments
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
	 * Check state.
	 *
	 * @param direction the direction
	 */
	public void checkState(char direction){
		for(int i =0; i < leveling.getLevels().size(); i++){
			if(leveling.getLevels().get(i).getRunning()){
				WinGame win = new WinGame(leveling.getLevels().get(i));

				
				if(leveling.getLevels().get(i) instanceof Mapa1){
					GameOver gmae = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard(), leveling.getLevels().get(i));
				leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), direction);
				leveling.getLevels().get(i).getGuard().enemyMove(leveling.getLevels().get(i));
				if(gmae.getGameOver(leveling.getLevels().get(i))){	
					lost = true;
					btnRight.setEnabled(false);
					btnLeft.setEnabled(false);
					btnUp.setEnabled(false);
					btnDown.setEnabled(false);
					textArea.setText("You looooost, noob");
					lblPressNewGame.setText("You were defeated");
				}
					else if(win.getWin()){
						int a = i+1;
						textArea.setText(leveling.getLevels().get(a).printBoard(leveling.getLevels().get(a).getHero(), leveling.getLevels().get(a).getOrde()));					
					}else{
						textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getGuard()));
		}
				}else if( leveling.getLevels().get(i) instanceof Mapa2){
					GameOver lvltwo = new GameOver(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde(), leveling.getLevels().get(i));
					leveling.getLevels().get(i).getOrde().moveOrde(leveling.getLevels().get(i));
					leveling.getLevels().get(i).getHero().commandMove(leveling.getLevels().get(i), direction);
					if(lvltwo.getGameOver(leveling.getLevels().get(i))){	
						lost = true;
						btnRight.setEnabled(false);
						btnLeft.setEnabled(false);
						btnUp.setEnabled(false);
						btnDown.setEnabled(false);
						textArea.setText("You lost, noob");
						lblPressNewGame.setText("You were defeated");
					}
						else if(win.getWin()){
						textArea.setText("You won");	

						}
						else{
							textArea.setText(leveling.getLevels().get(i).printBoard(leveling.getLevels().get(i).getHero(), leveling.getLevels().get(i).getOrde()));
							}

					}
			}
			
	}

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
		
		lblPressNewGame.setBounds(10, 236, 194, 14);
		frame.getContentPane().add(lblPressNewGame);
		
		lblEnt.setBounds(10, 11, 102, 14);
		frame.getContentPane().add(lblEnt);
		
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
		
		btnExit.setBounds(323, 227, 89, 23);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){System.exit(0);}
		});
		frame.getContentPane().add(btnExit);
		
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(20, 76, 246, 161);
		frame.getContentPane().add(textArea);
		
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {checkState('a');}
		});
		btnLeft.setEnabled(false);
		btnLeft.setBounds(287, 118, 60, 23);
		frame.getContentPane().add(btnLeft);
		
		btnRight.setEnabled(false);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {checkState('d');}
		});
		btnRight.setBounds(357, 118, 67, 23);
		frame.getContentPane().add(btnRight);
		
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {checkState('s');}
		});
		btnDown.setEnabled(false);
		btnDown.setBounds(322, 152, 72, 23);
		frame.getContentPane().add(btnDown);
		
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {checkState('w');}
		});
		btnUp.setEnabled(false);
		btnUp.setBounds(323, 84, 60, 23);
		frame.getContentPane().add(btnUp);
		
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
				if(number == 0 || number > 5){
					lblPressNewGame.setText("Insert a valid number for ogres");
				}else{
				Orde orde = new Orde(number);
				map2.setOrde(orde);
				map1.setRunning(true);
				textArea.setText(map1.printBoard(map1.getHero(), map1.getGuard()));
				}
				}
		});
		btnNewGame.setBounds(305, 32, 119, 23);
		frame.getContentPane().add(btnNewGame);
	}

	
	/**
	 * Gets the maps.
	 *
	 * @return the maps
	 */
	public Levels getMaps() {
		return leveling;
	}

	/**
	 * Sets the maps.
	 *
	 * @param maps the new maps
	 */
	public void setMaps(Levels maps) {
		this.leveling = maps;
	}
}
