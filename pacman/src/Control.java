import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Control implements KeyListener {
	Pacman gui;
	final int BOARD_SIZE = gui.BOARD_SIZE;
//	key = gui.e.getKeycode();
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 87 || e.getKeyCode() == 38) {
			System.exit(0);
			for (int row = 0; row < BOARD_SIZE; row++) {
				for (int col = 0; col < BOARD_SIZE; col++) {
					if (gui.map[row][col] == 1) {
						gui.map[row][col] = 0;
						gui.map[row + 1][col] = 1;
						break;
					}
				}
			}
			
			gui.mapRead();
		} 
	}	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
