package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class mainWindow extends JFrame{

	private JTextArea[][] contentGrid = new JTextArea[5][5];
	
	public mainWindow(String titre) {
        super(titre);
        
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Quitter ?", "Confirmer", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});	
	    
        setContentPane(inside());
    	Dimension dimensionMinimale = new Dimension(320,250);
    	this.setMinimumSize(dimensionMinimale);
        pack();
        
    }
	
	private JPanel inside() {
    	JPanel result = new JPanel(new GridLayout(5, 5));
    	
    	JTextArea temp;
    	//BorderLayout testBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
    	
    	for (int i=0; i<5; i++){
    		for (int j=0; j<5; j++){
    			
    			temp = new JTextArea("coucou");
    			this.contentGrid[i][j] = temp;
    			temp.setEditable(false);
    			result.add(temp);
    		}
    	}
    	
    	return result;
    }
}
