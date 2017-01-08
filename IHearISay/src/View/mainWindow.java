package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;


public class mainWindow extends JFrame{

	private ArrayList<JButton> alButton = new ArrayList<JButton>();
	private String defaultText = "";
	private int nbLines = 5;
	private int nbCol = 6; //MUST BE EVEN (nbRows/2 = 0)
	private int nbButtons = this.nbLines*this.nbCol;
	
	public mainWindow(String titre) {
        super(titre);
        
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Quit ?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
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
    	JPanel grille = new JPanel(new GridLayout(this.nbLines, this.nbCol));
    	JPanel boutons = new JPanel(new GridLayout(5,1));
    	JPanel result = new JPanel(new BorderLayout());
    	
    	
// Creation de la grille 
    	Border BorderTitledGrid = BorderFactory.createTitledBorder("Grid");
    	Border BorderTitledGrid2 = BorderFactory.createTitledBorder("Your choice");
    	
    	JButton buttonStart = new JButton("Start");
    	JButton buttonEnd = new JButton("End");
    	
    	buttonStart.setEnabled(false);
    	buttonEnd.setEnabled(false);
    	
    	if(this.nbButtons>0){
    		grille.add(buttonStart);
    	
    		for (int i=0; i<this.nbButtons-2; i=i+2){
    		
    				HearSayCombo temp = new HearSayCombo(defaultText, grille);
    				temp.getISayButton().addActionListener(new ActionListener() {
					
    					@Override
    					public void actionPerformed(ActionEvent e) {
    						String newText = JOptionPane.showInputDialog("Enter the new text :");
    						temp.setText(newText);
    						//TODO : ajouter dans la List
						
    					}
    				});
				
    		
    		}
    		grille.add(buttonEnd);
    	}
    	grille.setBorder(BorderTitledGrid);
//fin de creation de la grille 

    	//Dimension d = new Dimension(15, 110);
    	// Creation des boutons de fonctionnalites
    	JButton butCreer = new JButton("Create");
    	JButton butImport = new JButton("Import");
    	JButton butExport = new JButton("Export");
    	JButton butImprimer = new JButton("Imprimer");
    	JScrollPane list = new JScrollPane();
 
    	/*
    	butCreer.setPreferredSize(d);
    	butImport.setPreferredSize(d);
    	butExport.setPreferredSize(d);
    	butImprimer.setPreferredSize(d);
    	*/
    	list.setPreferredSize(new Dimension(170,120));
    	
    	
    	//Ajout des Listener
    	butCreer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnCreate();
				
			}
		});
    	
    	butImport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Not implemented yet...");
				
			}
		});
    	butExport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Not implemented yet...");
				
			}
		});
    	
    	boutons.add(butCreer);
    	boutons.add(butImport);
    	boutons.add(butExport);
    	boutons.add(butImprimer);
    	boutons.add(list);
    	
    	boutons.setBorder(BorderTitledGrid2);


    	result.add(grille, BorderLayout.CENTER);
    	result.add(boutons, BorderLayout.EAST);
    	
    	return result;
    }
	
	public void actionBtnCreate(){
		CreateGridWindow gridCreatorWindow = new CreateGridWindow("Creating a Grid");
        gridCreatorWindow.setLocationRelativeTo(this);
        gridCreatorWindow.setVisible(true);
        
	}

}




