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
	private int nbLines = 10;
	private int nbCol = 8; //MUST BE EVEN (nbRows/2 = 0)
	private int nbButtons = this.nbLines*this.nbCol;
	public  JPanel grille = new JPanel(new GridLayout(this.nbLines, this.nbCol));
	
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
		/*CreateGridWindow gridCreatorWindow = new CreateGridWindow("Creating a Grid");
        gridCreatorWindow.setLocationRelativeTo(this);
        gridCreatorWindow.setVisible(true);*/
        
		Object[] possibilities = {1,2,3,4,5,6,7,8,9,10};
		int newNbLines = (int) JOptionPane.showInputDialog(
		                    this,
		                    "Number of lines :",
		                    "Create Grid Input",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null, possibilities,
		                    2);

		if (newNbLines > 0) {
			Object[] possibilities2 = {4, 6, 8 , 10};
		    this.nbLines=newNbLines;
			int newNbCol = (int) JOptionPane.showInputDialog(
			                    this,
			                    "Number of Columns :",
			                    "Create Grid Input",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null, possibilities2,
			                    2);

			if (newNbCol > 0) {
				
			    this.nbCol=newNbCol;
			    this.nbButtons=this.nbLines*this.nbCol;
				this.grille.removeAll();
				grille.setLayout(new GridLayout(this.nbLines, this.nbCol));
				
				System.out.println("nbLines = " + this.nbLines);
				System.out.println("nbCol = " + this.nbCol);
				
				if(this.nbButtons>0){
					JButton buttonStart = new JButton("Start");
			    	JButton buttonEnd = new JButton("End");
			    	
			    	buttonStart.setEnabled(false);
			    	buttonEnd.setEnabled(false);
			    	
		    		grille.add(buttonStart);
		    	
		    		for (int i=0; i<this.nbButtons-2; i=i+2){
		    		
		    				HearSayCombo temp = new HearSayCombo(defaultText, grille);
		    				System.out.println("uesch");
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
		    		grille.validate();
		    		grille.repaint();
		    	}
			}
			
			
			
		    return;
		}

		//If you're here, the return value was null/empty.
		System.out.println("C'est cassay");

        
	}

}




