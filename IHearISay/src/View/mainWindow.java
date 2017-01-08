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
    	
    	
    	
    	fillGrid();
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
       
		Object[] options = {"Lines and Columns",
        					"Enter the text directly"};
		
		int optionSelected = JOptionPane.showOptionDialog(this,
														  "Choose a creation mode :",
														  "Creation mode",
														  JOptionPane.YES_NO_OPTION,
														  JOptionPane.QUESTION_MESSAGE,
														  null,     //do not use a custom Icon
														  options,  //the titles of buttons
														  options[0]); //default button title
		
		if(optionSelected==0){ //If Lines and Columns
			Object[] possibilities = {1,2,3,4,5,6,7,8,9,10}; //Number of lines you can select, capped at 10 voluntarily
			int newNbLines = (int) JOptionPane.showInputDialog(this,
		                    							   	   "Number of lines :",
		                    							   	   "Create Grid Input",
		                    							   	   JOptionPane.PLAIN_MESSAGE,
		                    							   	   null, possibilities,
		                    							   	   1);

			if (newNbLines > 0) { //If valid amount of line
				Object[] possibilities2 = {4, 6, 8 , 10}; //Number of columns you can select, capped at 10 voluntarily, must be even(nbCol/2 = 0)
				this.nbLines=newNbLines;
				int newNbCol = (int) JOptionPane.showInputDialog(this,
			                    							     "Number of Columns :",
			                    							     "Create Grid Input",
			                    							     JOptionPane.PLAIN_MESSAGE,
			                    							     null, possibilities2,
			                    							     4);

				if (newNbCol > 0) { //if valid amount of columns
				
			    	this.nbCol=newNbCol;
			    	this.nbButtons=this.nbLines*this.nbCol;
					this.grille.removeAll();
					grille.setLayout(new GridLayout(this.nbLines, this.nbCol));
				
					fillGrid();
				
				}

				return;
			}
		}
		else{ //If Enter the text directly
			String userText = (String) JOptionPane.showInputDialog(this,
				     "Enter the texts separated by a ';' :",
				     "Enter your text",
				     JOptionPane.PLAIN_MESSAGE,
				     null,
				     null,
				     0);
			int nbWord = userText.length() - userText.replace(";", "").length(); //
			
			int temp=(nbWord*2)+2;
			
			if(temp<=6){
				this.nbLines=1;
				this.nbCol=temp;
			}
			else{
				this.nbLines=(temp/6)+1;
				this.nbCol=6;
			}
			
			this.nbButtons = nbWord*2;
			System.out.println("______________");
			System.out.println("temp :" + temp);
			System.out.println("nbWord :" + nbWord);
			System.out.println("nbLines :" + nbLines);
			System.out.println("nbCol :" + nbCol);
			//TODO : les syso affichent les bons chiffres, mais l'affichage est kassay
			grille.setLayout(new GridLayout(nbLines, nbCol));
			fillGrid();
			
		}
	}
	
	public void fillGrid(){
		grille.removeAll();
		if(this.nbButtons>0){
			JButton buttonStart = new JButton("Start");
	    	JButton buttonEnd = new JButton("End");
	    	
	    	buttonStart.setEnabled(false);
	    	buttonEnd.setEnabled(false);
	    	
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
    		grille.validate();
			grille.repaint();
    	}
	}

}




