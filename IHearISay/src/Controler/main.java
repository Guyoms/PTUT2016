package Controler;

import java.awt.Color;

import javax.swing.JFrame;
import View.mainWindow;



/**
 * This method launches the application
 *
 */
public class main {

	public static void main(String[] args) {
		JFrame myMainWindow = new mainWindow("I hear I say !");
		myMainWindow.setLocationRelativeTo(null);
		myMainWindow.setVisible(true);
	}

}
