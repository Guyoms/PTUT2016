package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class CreateGridWindow extends JFrame{
	private SpinnerModel modelLines = new SpinnerNumberModel(1, 1, 10, 1); //Start=arg1, Min=arg2, Max=arg3, Step=arg4
	private SpinnerModel modelCol 	= new SpinnerNumberModel(2, 2, 10, 2); //Start=arg1, Min=arg2, Max=arg3, Step=arg4
	private JSpinner JSpinnerLines = new JSpinner(modelLines);
	private JSpinner JSpinnerCol   = new JSpinner(modelCol);;
	private JTextField JTFieldInput = new JTextField();
	
	public CreateGridWindow(String titre){
		
		  setContentPane(inside());
		  Dimension dimensionMinimale = new Dimension(500,500);
	      this.setPreferredSize(dimensionMinimale);
	      
	      
	      pack();
	        
	}
		
	private JPanel inside() {
		JPanel result = new JPanel(new GridLayout(7, 1));
		JPanel buttonRow = new JPanel(new FlowLayout());
		
		JLabel JLabelLines = new JLabel("Number of Lines :");
		JLabel JLabelCol   = new JLabel("Number of Columns :");
		JLabel JLabelInput = new JLabel("(Optionnal) Content of the compartments (separated by ';') :");
		
		JButton btnOK     = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");
		
		buttonRow.add(btnOK);
		buttonRow.add(btnCancel);
		
		result.add(JLabelLines);
		result.add(this.JSpinnerLines);
		
		result.add(JLabelCol);
		result.add(this.JSpinnerCol);
		
		result.add(JLabelInput);
		result.add(this.JTFieldInput);
		
		result.add(buttonRow);
		
		return result;
	}

}
