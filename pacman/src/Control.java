import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Control implements KeyListener {
	Pacman gui;
	
	public Control (Pacman in){
		gui = in;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 87) { // up
			gui.map[gui.playerR][gui.playerC] = 0;
			gui.playerR--;
			gui.map[gui.playerR][gui.playerC] = 1;
		} 
		else if (e.getKeyCode() == 83) { // down
			gui.map[gui.playerR][gui.playerC] = 0;
			gui.playerR++;
			gui.map[gui.playerR][gui.playerC] = 1;
		} 
		else if (e.getKeyCode() == 68) { // right
			gui.map[gui.playerR][gui.playerC] = 0;
			gui.playerC++;
			gui.map[gui.playerR][gui.playerC] = 1;
		} 
		else if (e.getKeyCode() == 65) { // left
			gui.map[gui.playerR][gui.playerC] = 0;
			gui.playerC--;
			gui.map[gui.playerR][gui.playerC] = 1;
		} 
		gui.mapRead();
		gui.printMap(); 
	}	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}