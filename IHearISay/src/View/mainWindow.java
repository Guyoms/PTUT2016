package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import Model.GenerateGridBehavior;
import Model.GenerateGridBehavior10Columns;
import Model.GenerateGridBehavior2Columns;
import Model.GenerateGridBehavior4Columns;
import Model.GenerateGridBehavior6Columns;
import Model.GenerateGridBehavior8Columns;


public class mainWindow extends JFrame{

	private int 				 nbLines   	= 5;
	private int 				 nbCol 	  	= 6; 						//MUST BE EVEN (nbRows/2 = 0)
	private int 				 nbButtons 	= this.nbLines*this.nbCol;
	private ArrayList<String>    alWord 		= new ArrayList<String>	();
	private String 				 defaultText = ""; 						//Default text on all the buttons
	public  JPanel 				 grid 		= new JPanel(new GridLayout(this.nbLines, this.nbCol));
	
	private GenerateGridBehavior generateGridBehavior;
	
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

    	JPanel boutons = new JPanel(new GridLayout(6,1));
    	JPanel result = new JPanel(new BorderLayout());
    	
    	
// Creation de la grille 
    	Border BorderTitledGrid = BorderFactory.createTitledBorder("Grid");
    	Border BorderTitledGrid2 = BorderFactory.createTitledBorder("Your choice");
    	
    	
    	this.alWord = new ArrayList<String>(); //Reset the ArrayList to have empty buttons
    	fillGrid(alWord);
    	grid.setBorder(BorderTitledGrid);
    	//TODO : Try to adjust the size of the grid when modyfiying it's content in order to have good looking buttons 
//fin de creation de la grille 

    	//Dimension d = new Dimension(15, 110);
    	// Creation des boutons de fonctionnalites
    	JButton butCreer    = new JButton("Create");
    	JButton butShuffle  = new JButton("Shuffle");
    	JButton butImport   = new JButton("Import");
    	JButton butExport   = new JButton("Export");
    	JButton butImprimer = new JButton("Imprimer");
    	JScrollPane list    = new JScrollPane();
 
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
    	
    	butShuffle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*Fill the ArrayList with empty Strings to match the number of pair in the grid
				 * Used to shuffle properly
				*/
				while(alWord.size()*2+2<nbButtons){
					alWord.add("");
				}
				
				shuffleWords();
				fillGrid(alWord);
				
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
    	boutons.add(butShuffle);
    	boutons.add(butImport);
    	boutons.add(butExport);
    	boutons.add(butImprimer);
    	boutons.add(list);
    	
    	boutons.setBorder(BorderTitledGrid2);


    	result.add(grid, BorderLayout.CENTER);
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
				this.nbLines = newNbLines;
				int newNbCol = (int) JOptionPane.showInputDialog(this,
			                    							     "Number of Columns :",
			                    							     "Create Grid Input",
			                    							     JOptionPane.PLAIN_MESSAGE,
			                    							     null, possibilities2,
			                    							     4);

				if (newNbCol > 0) { //if valid amount of columns
				
			    	this.nbCol=newNbCol;
			    	this.nbButtons=this.nbLines*this.nbCol;
					this.grid.removeAll();
					grid.setLayout(new GridLayout(this.nbLines, this.nbCol));
				
					this.alWord = new ArrayList<String>(); //Reset the ArrayList to have empty buttons
					fillGrid(this.alWord);
				
				}

				return;
			}
		}
		else if(optionSelected==1){ //If Enter the text directly
			String userText = (String) JOptionPane.showInputDialog(this,
				     "Enter the texts separated by a ';'.\n"
				     + "In order to keep a clean display,\nit is recommanded to use a minimum of 7 words :\n"
				     + "\n",
				     "Enter your text",
				     JOptionPane.PLAIN_MESSAGE,
				     null,
				     null,
				     0);
			
			//int nbWord = userText.length() - userText.replace(";", "").length(); //number of word to put in the grid (= number of ';' in user's input)
			
			
			//The following lines will splits the user input and add each word(separated by ';') to the ArrayList<String> alWord
			String[] tempTabString = userText.split(";");
			int nbWord = tempTabString.length;
			this.alWord = new ArrayList<String>();
			for(String s : tempTabString){
				this.alWord.add(s);
			}
			this.shuffleWords();
			
			
			this.nbButtons=(nbWord*2)+2; //number of squares required in the grid
			
			Object[] possibilities = {2,4,6,8,10}; //Number of lines you can select, capped at 10 voluntarily
			int newNbCol = (int) JOptionPane.showInputDialog(this,
			                    							 "You have entered " + nbWord +" words. How many columns do you want in the final grid ? :",
			                    							 "Create Grid Input",
			                    							 JOptionPane.PLAIN_MESSAGE,
			                    							 null, possibilities,
			                    							 1);
			
			System.out.println("-----------BEFORE------------");
			System.out.println("nbButtons : "+ this.nbButtons);
			System.out.println("nbLines : "+ this.nbLines);
			System.out.println("nbCol : "+ this.nbCol);
			
			
			if(newNbCol == 2){this.generateGridBehavior = new GenerateGridBehavior2Columns();}				
			if(newNbCol == 4){this.generateGridBehavior = new GenerateGridBehavior4Columns();}
			if(newNbCol == 6){this.generateGridBehavior = new GenerateGridBehavior6Columns();}
			if(newNbCol == 8){this.generateGridBehavior = new GenerateGridBehavior8Columns();}
			if(newNbCol == 10){this.generateGridBehavior = new GenerateGridBehavior10Columns();}
				
			this.generateGrid();
			
			System.out.println("-----------AFTER------------");
			generateGridBehavior.toPrint();
			System.out.println("nbButtons : "+ this.nbButtons);
			System.out.println("nbLines : "+ this.nbLines);
			System.out.println("nbCol : "+ this.nbCol);

		}
	}
	
	//Fill the panel 'grid' with buttons using this.nbButtons
	public void fillGrid(ArrayList<String> alWord){
		grid.removeAll();
		if(this.nbButtons>0){
			JButton buttonStart = new JButton("Start");
	    	JButton buttonEnd = new JButton("End");
	    	
	    	buttonStart.setEnabled(false);
	    	buttonEnd.setEnabled(false);
	    	
    		grid.add(buttonStart);
    	
    		String buttonText = this.defaultText;//variable containing next pair of button's content
    		
    		for (int i=0; i<this.nbButtons-2; i=i+2){
    		
    				if(i/2<this.alWord.size() && this.alWord.size()!=0){buttonText = this.alWord.get(i/2);}
    				else{buttonText = this.defaultText;}
    				
    			
    				HearSayCombo temp = new HearSayCombo(buttonText, grid);
    				temp.getISayButton().addActionListener(new ActionListener() {
					
    					@Override
    					public void actionPerformed(ActionEvent e) { //Allows user to modify ISayButton's content by clicking on them
    						String newText = JOptionPane.showInputDialog("Enter the new text :");
    						if(newText!=null){ //if user correctly entered a new String
    							temp.setText(newText);
    							alWord.add(newText);
    						}
    						
						
    					}
    				});
				
    		
    		}
    		grid.add(buttonEnd);
    		grid.validate();
			grid.repaint();
    	}
	}
	
	/*
	 * The following method will update the grid with the selected GenerateGridBehavior.
	 * The result will wary depending on the number of words entered by the user and the behavior selected.
	 * Note that those behaviors follow a Strategy pattern.
	 * 
	 * /!\ In order to use those classes, if is extremely important to use the generateNbButtons(nbButtons) first, then use the other methods
	 */
	
	public void generateGrid(){
		this.nbButtons = this.generateGridBehavior.generateNbButtons(this.nbButtons);
		this.nbLines = this.generateGridBehavior.generateNbLines(this.nbButtons);
		this.nbCol = this.generateGridBehavior.generateNbColumns();
		grid.setLayout(new GridLayout(this.nbLines, this.nbCol));
		fillGrid(alWord);
	}
	
	
	
	//Shuffle the words in the ArrayList this.alWord
	public void shuffleWords(){
		Collections.shuffle(alWord);
	}
}




