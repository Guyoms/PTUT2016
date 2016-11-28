package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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


public class mainWindow extends JFrame{

	private ArrayList<JButton> alButton = new ArrayList<JButton>();
	private JButton[][] contentGrid = new JButton[5][5];
	private int i; //Row
	private int j; //Line
	
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
    	
    	Border BorderTitledGrid = BorderFactory.createTitledBorder("Grid");
    	Border BorderLowered = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
    	
    	for (i=0; i<5; i++){
    		for (j=0; j<5; j++){
    			
    			JButton JButtonIsayTemp = new JButton("test");
    			JButton JButtonIhearTemp = new JButton("test");
    			
    			if(j/2!=0){
    				//Border of the button
        			JButtonIhearTemp.setBorder(BorderLowered);
        			JButtonIsayTemp.setBorder(BorderLowered);
        			
        			JButtonIhearTemp.setBackground(new Color(15, 255, 255)); //Cyan
        			JButtonIsayTemp.setBackground(new Color(255, 255, 15));	//Yellow
        			
        			
    				this.contentGrid[i][j] = JButtonIsayTemp;
    				if(i!=4){
        				this.contentGrid[i+1][j-1] = JButtonIhearTemp;
    				}
    				
    				alButton.add(JButtonIhearTemp);
    				alButton.add(JButtonIsayTemp);
    				
        			result.add(JButtonIhearTemp);
        			result.add(JButtonIsayTemp);
        		
    			}
    			
    			
    			
    			JButtonIsayTemp.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						i = e.getComponent().getY()/e.getComponent().getHeight(); //Update i to the selected tile
						j = e.getComponent().getX()/e.getComponent().getWidth(); //Update j to the selected tile
						
						String newContent = JOptionPane.showInputDialog("Text of this tile");
						alButton.get(i+j).setText(newContent);
						alButton.get(i+j).setText(newContent);
						
						//Clear the grid, removes every button and display the empty grid
						result.removeAll();
						result.setLayout(new GridLayout(5, 5));
						revalidate();
						repaint();
						
						
						//TODO : remplis � nouveau la grille (s'arret)
						for (i=0; i<5; i++){
				    		for (j=0; j<5; j++){

				    			System.out.println("i : " + i + " | j :" + j + " | contentGrid length : " + contentGrid.length);
				    			
				    			contentGrid[i][j]=alButton.get(i+j);
				    			result.add(contentGrid[i][j]);
				    		}
						}
						
						
					}
				});
    		}
    	}
    	
    	result.setBorder(BorderTitledGrid);
    	return result;
    }
	

}




