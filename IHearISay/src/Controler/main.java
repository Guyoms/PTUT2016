package Controler;

import javax.swing.JFrame;

import View.mainWindow;

public class main {

	public static void main(String[] args) {
		JFrame myMainWindow = new mainWindow("I hear I say !");
		myMainWindow.setLocationRelativeTo(null);
		myMainWindow.setVisible(true);
	}

}
