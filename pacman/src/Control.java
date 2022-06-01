import java.awt.*;
import java.awt.event.*;

public class Control implements KeyListener {
	boolean up, down, left, right;
	Pacman gui = new Pacman();
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 87) {
			up = true;
			down = false;
			left = false;
			right = false;
		} else if (e.getKeyCode() == 83) {
			up = false;
			down = true;
			left = false;
			right = false;
		} else if (e.getKeyCode()==65) {
			up = false;
			down = false;
			left = true;
			right = false;
		} else if (e.getKeyCode()==68) {
			up = false;
			down = false;
			left = false;
			right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
