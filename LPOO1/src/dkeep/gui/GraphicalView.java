package dkeep.gui;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

public class GraphicalView{

	private JFrame frame;
	private GamePanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicalView window = new GraphicalView();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("World of Warcraft : Legion");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setBounds(300, 25, 700, 700);
		frame.setResizable(false);
		panel = new GamePanel(700,700);
		panel.setBounds(0, 0, 700,700);
		frame.getContentPane().add(panel);
		//panel.addKeyListener(panel);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		 
		
	}

}
