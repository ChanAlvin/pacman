import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Control implements KeyListener, ActionListener{
	Pacman gui;
	Timer timer; 
	int timerCounter = 0;
	boolean move = false;

	public Control (Pacman in){
		gui = in;
		timer = new Timer(30, this);
		timer.start(); // start the time
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(move == true) {
			if (e.getKeyCode() == 87) { // up
				if(gui.playerR-1>=0 && gui.map[gui.playerR-1][gui.playerC] == 0) {
					gui.total+=10;
					gui.map[gui.playerR][gui.playerC] = 7;
					gui.playerR--;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				else if(gui.playerR-1>=0 && gui.map[gui.playerR-1][gui.playerC] == 7) {
					gui.map[gui.playerR][gui.playerC] = 7;
					gui.playerR--;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				gui.pacman = new ImageIcon("pacAntUp.png");
			} 
			else if (e.getKeyCode() == 83 ) { // down
				if(gui.playerR+1<gui.BOARD_SIZE && gui.map[gui.playerR+1][gui.playerC] == 0)
				{
					gui.total+=10;
					gui.map[gui.playerR][gui.playerC] = 7;
					gui.playerR++;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				else if(gui.playerR+1<gui.BOARD_SIZE && gui.map[gui.playerR+1][gui.playerC] == 7){
					gui.map[gui.playerR][gui.playerC] = 7;
					gui.playerR++;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				gui.pacman = new ImageIcon("pacAntDown.png");
			} 
			else if (e.getKeyCode() == 68) { // right
				if(gui.playerR == 10 && gui.playerC==20) {
					gui.map[gui.playerR][gui.playerC] = 0;
					gui.playerC = 0;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				else if(gui.playerC+1<gui.BOARD_SIZE && gui.map[gui.playerR][gui.playerC+1] == 0)
				{
					gui.total+=10;
					gui.map[gui.playerR][gui.playerC] = 7;
					gui.playerC++;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				else if(gui.playerC+1<gui.BOARD_SIZE && gui.map[gui.playerR][gui.playerC+1] == 7)
				{
					gui.map[gui.playerR][gui.playerC] = 7;
					gui.playerC++;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				gui.pacman = new ImageIcon("pacAntRight.png");
			} 
			else if (e.getKeyCode() == 65) { // left
				if(gui.playerR == 10 && gui.playerC==0) {
					gui.map[gui.playerR][gui.playerC] = 0;
					gui.playerC = 20;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				else if(gui.playerC-1<gui.BOARD_SIZE && gui.map[gui.playerR][gui.playerC-1] == 0) {
					gui.total+=10;
					gui.map[gui.playerR][gui.playerC] = 7;
					gui.playerC--;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				else if(gui.playerC-1<gui.BOARD_SIZE && gui.map[gui.playerR][gui.playerC-1] == 7) {
					gui.map[gui.playerR][gui.playerC] = 7;
					gui.playerC--;
					gui.map[gui.playerR][gui.playerC] = 1;
				}
				gui.pacman = new ImageIcon("pacAntLeft.png");
			} 

			gui.mapRead();
			gui.printMap(); 
			timerCounter = 0;
			move = false;
		}
	}	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == timer ) { 
			timerCounter++;
		}
		if(timerCounter > 5) {
			move = true;
		}

	}
}