import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class AI implements ActionListener {
	Pacman gui;
	boolean redBeeFirst = true;
	boolean greenBeeFirst = true;
	boolean purpleBeeFirst = true;
	int ran;

	public AI (Pacman in){
		gui = in;
	}

	public void redBee() {
		ran = (int)(Math.random()*4+1);

		if(redBeeFirst == true) {

			gui.map[gui.redR][gui.redC] = 7;
			gui.redR++;
			gui.map[gui.redR][gui.redC] = 4;

			if(gui.redR == 12 && gui.redC == 9) {
				redBeeFirst = false;
			}
		}
		if(redBeeFirst == false) {
			if(ran == 1) {
				if(gui.redR == 10 && gui.redC==0) {// left
					gui.map[gui.redR][gui.redC] = 7;
					gui.redC = 20;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.redC-1<gui.BOARD_SIZE && gui.map[gui.redR][gui.redC-1] == 0)  {
					gui.map[gui.redR][gui.redC] = 0;
					gui.redC--;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.redC-1<gui.BOARD_SIZE && gui.map[gui.redR][gui.redC-1] == 7)  {
					gui.map[gui.redR][gui.redC] = 7;
					gui.redC--;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.map[gui.redR][gui.redC-1] != 0) {
				}
				gui.redBee = new ImageIcon("redBeeLeft.png");
			}
			if(ran == 2) {
				if(gui.redR-1>=0 && gui.map[gui.redR-1][gui.redC] == 0)  // up
				{
					gui.map[gui.redR][gui.redC] = 0;
					gui.redR--;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.redR-1>=0 && gui.map[gui.redR-1][gui.redC] == 7)  
				{
					gui.map[gui.redR][gui.redC] = 7;
					gui.redR--;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.map[gui.redR-1][gui.redC] != 0) {
				}
				gui.redBee = new ImageIcon("redBeeUp.png");
			}
			if(ran == 3) {
				if(gui.redR == 10 && gui.redC==20) { // right
					gui.map[gui.redR][gui.redC] = 7;
					gui.redC = 0;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.redC-1<gui.BOARD_SIZE && gui.map[gui.redR][gui.redC+1] == 0) {
					gui.map[gui.redR][gui.redC] = 0;
					gui.redC++;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.redC-1<gui.BOARD_SIZE && gui.map[gui.redR][gui.redC+1] == 7) {
					gui.map[gui.redR][gui.redC] = 7;
					gui.redC++;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.map[gui.redR][gui.redC+1] != 0) {
				}
				gui.redBee = new ImageIcon("redBeeRight.png");
			}
			if(ran == 4) {
				if(gui.redR+1<gui.BOARD_SIZE && gui.map[gui.redR+1][gui.redC] == 0 ) // down
				{
					gui.map[gui.redR][gui.redC] = 0;
					gui.redR++;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.redR+1<gui.BOARD_SIZE && gui.map[gui.redR+1][gui.redC] == 7 ) 
				{
					gui.map[gui.redR][gui.redC] = 7;
					gui.redR++;
					gui.map[gui.redR][gui.redC] = 4;
				}
				else if(gui.map[gui.redR+1][gui.redC] != 0) {
				}
				gui.redBee = new ImageIcon("redBeeDown.png");
			}
		}
		gui.mapRead();
		gui.printMap();
	}


	public void greenBee() {
		int ran = (int)(Math.random()*4+1);
		if(greenBeeFirst == true) {

			gui.map[gui.greenR][gui.greenC] = 7;
			gui.greenR--;
			gui.map[gui.greenR][gui.greenC] = 5;

			if(gui.greenR == 7 && gui.greenC == 10) {
				greenBeeFirst = false;
			}
		}
		if(greenBeeFirst == false) {
			if(ran == 1) {
				if(gui.greenR-1>=0 && gui.map[gui.greenR-1][gui.greenC] == 0)  // up
				{
					gui.map[gui.greenR][gui.greenC] = 0;
					gui.greenR--;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.greenR-1>=0 && gui.map[gui.greenR-1][gui.greenC] == 7)  
				{
					gui.map[gui.greenR][gui.greenC] = 7;
					gui.greenR--;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.map[gui.greenR-1][gui.greenC] != 0) {
					ran++;
				}
				gui.greenBee = new ImageIcon("greenBeeUp.png");
			}
			if(ran == 2) {
				if(gui.greenR == 10 && gui.greenC==20) { // right
					gui.map[gui.greenR][gui.greenC] = 7;
					gui.greenC = 0;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.greenC-1<gui.BOARD_SIZE && gui.map[gui.greenR][gui.greenC+1] == 0) {
					gui.map[gui.greenR][gui.greenC] = 0;
					gui.greenC++;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.greenC-1<gui.BOARD_SIZE && gui.map[gui.greenR][gui.greenC+1] == 7) {
					gui.map[gui.greenR][gui.greenC] = 7;
					gui.greenC++;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.map[gui.greenR][gui.greenC-1] != 0) {
					ran++;
				}
				gui.greenBee = new ImageIcon("greenBeeRight.png");
			}
			if(ran == 3) {
				if(gui.greenR+1<gui.BOARD_SIZE && gui.map[gui.greenR+1][gui.greenC] == 0) // down
				{
					gui.map[gui.greenR][gui.greenC] = 0;
					gui.greenR++;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.greenR+1<gui.BOARD_SIZE && gui.map[gui.greenR+1][gui.greenC] == 7) // down
				{
					gui.map[gui.greenR][gui.greenC] = 7;
					gui.greenR++;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.map[gui.greenR+1][gui.greenC] != 0) {
					ran++;
				}
				gui.greenBee = new ImageIcon("greenBeeDown.png");
			}
			if(ran == 4) {
				if(gui.greenR == 10 && gui.greenC==0) {// left
					gui.map[gui.greenR][gui.greenC] = 7;
					gui.greenC = 20;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.greenC-1<gui.BOARD_SIZE && gui.map[gui.greenR][gui.greenC-1] == 0) {
					gui.map[gui.greenR][gui.greenC] = 0;
					gui.greenC--;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				else if(gui.greenC-1<gui.BOARD_SIZE && gui.map[gui.greenR][gui.greenC-1] == 7) {
					gui.map[gui.greenR][gui.greenC] = 7;
					gui.greenC--;
					gui.map[gui.greenR][gui.greenC] = 5;
				}
				gui.greenBee = new ImageIcon("greenBeeLeft.png");
			}
		}

		gui.mapRead();
		gui.printMap(); 

	}
	public void purpleBee() {
		int ran = (int)(Math.random()*4+1);
		if(purpleBeeFirst == true) {

			gui.map[gui.purpleR][gui.purpleC] = 7;
			gui.purpleR++;
			gui.map[gui.purpleR][gui.purpleC] = 6;

			if(gui.purpleR == 12 && gui.purpleC == 11) {
				purpleBeeFirst = false;
			}
		}
		if(purpleBeeFirst == false) {
			if(ran == 1) {
				if(gui.purpleR == 10 && gui.purpleC==0) {// left
					gui.map[gui.purpleR][gui.purpleC] = 7;
					gui.purpleC = 20;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.purpleC-1<gui.BOARD_SIZE && gui.map[gui.purpleR][gui.purpleC-1] == 0) {
					gui.map[gui.purpleR][gui.purpleC] = 0;
					gui.purpleC--;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.purpleC-1<gui.BOARD_SIZE && gui.map[gui.purpleR][gui.purpleC-1] == 7) {
					gui.map[gui.purpleR][gui.purpleC] = 7;
					gui.purpleC--;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.map[gui.purpleR][gui.purpleC-1] != 0) {
					ran++;
				}
				gui.purpleBee = new ImageIcon("purpleBeeLeft.png");
			}
			if(ran == 2) {
				if(gui.purpleR+1<gui.BOARD_SIZE && gui.map[gui.purpleR+1][gui.purpleC] == 0) // down
				{
					gui.map[gui.purpleR][gui.purpleC] = 0;
					gui.purpleR++;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.purpleR+1<gui.BOARD_SIZE && gui.map[gui.purpleR+1][gui.purpleC] == 7) 
				{
					gui.map[gui.purpleR][gui.purpleC] = 7;
					gui.purpleR++;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.map[gui.purpleR+1][gui.purpleC]  != 0) {
					ran++;
				}
				gui.purpleBee = new ImageIcon("purpleBeeDown.png");
			}
			if(ran == 3) {
				if(gui.purpleR == 10 && gui.purpleC==20) { // right
					gui.map[gui.purpleR][gui.purpleC] = 7;
					gui.purpleC = 0;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.purpleC-1<gui.BOARD_SIZE && gui.map[gui.purpleR][gui.purpleC+1] == 0) {
					gui.map[gui.purpleR][gui.purpleC] = 0;
					gui.purpleC++;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.purpleC-1<gui.BOARD_SIZE && gui.map[gui.purpleR][gui.purpleC+1] == 7) {
					gui.map[gui.purpleR][gui.purpleC] = 7;
					gui.purpleC++;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.map[gui.purpleR][gui.purpleC+1] != 0) {
					ran++;
				}
				gui.purpleBee = new ImageIcon("purpleBeeRight.png");
			}
			if(ran == 4) {
				if(gui.purpleR-1>=0 && gui.map[gui.purpleR-1][gui.purpleC] == 0)  // up
				{
					gui.map[gui.purpleR][gui.purpleC] = 0;
					gui.purpleR--;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				else if(gui.purpleR-1>=0 && gui.map[gui.purpleR-1][gui.purpleC] == 7)  // up
				{
					gui.map[gui.purpleR][gui.purpleC] = 7;
					gui.purpleR--;
					gui.map[gui.purpleR][gui.purpleC] = 6;
				}
				gui.purpleBee = new ImageIcon("purpleBeeUp.png");
			}

		}
		gui.mapRead();
		gui.printMap();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
