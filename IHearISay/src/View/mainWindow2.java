package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.GridBagLayout;


public class mainWindow2 extends JFrame{

	private ArrayList<JButton> alButton = new ArrayList<JButton>();
	private String defaultText = "test";
	private int nbLines = 5;
	private int nbRows = 7; // Must be an uneven number (number/2=1) !!!! or Interface goes weird
	
	public mainWindow2(String titre) {
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
    	JPanel grille = new JPanel(new GridLayout(this.nbLines, this.nbRows));
    	JPanel boutons = new JPanel(new GridLayout(3,1));
    	JPanel result = new JPanel(new BorderLayout());
    	
    	
// Création de la grille 
    	Border BorderTitledGrid = BorderFactory.createTitledBorder("Grid");
    	
    	JButton buttonStart = new JButton("Start");
    	JButton buttonEnd = new JButton("End");
    	
    	buttonStart.setEnabled(false);
    	buttonEnd.setEnabled(false);
    	
    	grille.add(buttonStart);
    	
    	for (int i=0; i<this.nbRows; i++){
    		for (int j=1; j<this.nbLines; j = j+2){
    			
    			HearSayCombo temp = new HearSayCombo(defaultText, grille);
    			
    			temp.getISayButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String newText = JOptionPane.showInputDialog("Enter the new text :");
						temp.setText(newText);
						
					}
				});
				
    		}
    	}
    	
    	grille.add(buttonEnd);
    	grille.setBorder(BorderTitledGrid);
//fin de création de la grille 

// Création des boutons de fonctionnalités
    	boutons.add(new JButton("Créer"));
    	boutons.add(new JButton("Importer"));
    	boutons.add(new JButton("Exporter"));
    		
    	
    	
    	
    	
    	
    	
    	result.add(grille, BorderLayout.WEST);
    	result.add(boutons, BorderLayout.EAST);
    	
    	return result;
    }
	

}




