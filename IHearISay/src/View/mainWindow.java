package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


public class mainWindow extends JFrame{

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
        			result.add(JButtonIhearTemp);
        			result.add(JButtonIsayTemp);
    			}
    			
    			
    			
    			JButtonIsayTemp.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						i = e.getComponent().getY()/e.getComponent().getHeight(); //Update i to the selected tile
						j = e.getComponent().getX()/e.getComponent().getWidth(); //Update j to the selected tile
						
						String newContent = JOptionPane.showInputDialog("Text of this tile");
						JButtonIsayTemp.setText(newContent);
						
						
						//TODO : fait en sorte que modifier la case "I say" modifie également la case "I hear" aossciée
						/*
						if(i<4){
							JButton JButtonIhearTemp = new JButton(newContent);
							contentGrid[i+1][j-1] = JButtonIhearTemp;
							JButtonIhearTemp.setBackground(new Color(15, 255, 255)); //Cyan
							JButtonIhearTemp.setBorder(BorderLowered);
							//result.add(JButtonIhearTemp);
							
						}
						*/
						
					}
				});
    		}
    	}
    	
    	result.setBorder(BorderTitledGrid);
    	return result;
    }
	

}




