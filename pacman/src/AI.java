import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class AI implements ActionListener {
	Pacman gui;

	public AI (Pacman in){
		gui = in;
	}
	
	public void redBee() {
		if(gui.redR-1>=0 && gui.map[gui.redR-1][gui.playerC] == 0) // up
		{
			gui.map[gui.redR][gui.playerC] = 0;
			gui.redR--;
			gui.map[gui.redR][gui.playerC] = 1;
		}
		if(gui.redR == 10 && gui.redC == 9) {
			gui.map[gui.redR][gui.redC] = 0;
			gui.redC++;
			gui.map[gui.redC][gui.redC] = 4;
		}
		gui.mapRead();
		gui.printMap();
	}
	
	public void greenBee() {
		if(gui.greenR == 10 && gui.greenC == 10) {
			gui.map[gui.greenR][gui.greenC] = 0;
			gui.greenR--;
			gui.map[gui.greenR][gui.greenC] = 5;
		}
		gui.mapRead();
		gui.printMap(); 

	}
	public void purpleBee() {
		if(gui.purpleR == 10 && gui.purpleC == 11) {
			gui.map[gui.purpleR][gui.purpleC] = 0;
			gui.purpleC--;
			gui.map[gui.purpleR][gui.purpleC] = 4;
		}
		gui.mapRead();
		gui.printMap();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
