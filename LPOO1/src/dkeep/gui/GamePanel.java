package dkeep.gui;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel  implements MouseListener, MouseMotionListener, KeyListener{
   //coordenadas do "bounding rectangle" do eclipse
	private int x1 = 0, y1 = 0, x2 =0, y2=0;
	
	//construtor que adiciona listeners para o rato e teclado
	public GamePanel(int width, int height){
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}
	
	//redraws the panel, only when requested by SWING
	public void paintComponent(Graphics g){
		super.paintComponent(g); //limpa fundo
		g.fillOval(x1, y1, x2-x1 +1, y2 - y1 +1);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: x1--; x2--; repaint(); break;
		case KeyEvent.VK_RIGHT: x1++; x2++; repaint(); break;
		case KeyEvent.VK_UP: y1--; y2--; repaint(); break;
		case KeyEvent.VK_DOWN: y1++; y2++; repaint(); break;
		}
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
