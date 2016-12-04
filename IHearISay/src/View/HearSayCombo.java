package View;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class HearSayCombo {
	private JButton IHearButton;
	private JButton ISayButton;
	private Color colorIHear = new Color(15, 255, 255); //Cyan
	private Color colorISay = new Color(255, 255, 15); //Yellow
	private Border BorderButtons = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
	
	//Should be used over default constructor, create empty buttons and add them to panelToAddButtons
	public HearSayCombo(JPanel panelToAddButtons){
		this.IHearButton = new JButton("");
		this.ISayButton = new JButton("");
		this.standardEdit(panelToAddButtons);
	}
	
	//Standard constructor, create buttons with text textButtons, and add them to panelToAddButtons
	public HearSayCombo(String textButtons, JPanel panelToAddButtons){
		this.IHearButton = new JButton(textButtons);
		this.ISayButton = new JButton(textButtons);
		this.standardEdit(panelToAddButtons);
	}
	
	//Edit the text of both buttons
	public void setText(String textButtons){
		this.IHearButton.setText(textButtons);
		this.ISayButton.setText(textButtons);
	}
	
	//Set all buttons to default settings for this app and add them to panelToAddButtons
	public void standardEdit(JPanel panelToAddButtons){
		
		this.IHearButton.setBackground(colorIHear); //Cyan
		this.ISayButton.setBackground(colorISay);	//Yellow
		
		this.IHearButton.setEnabled(false);
		
		this.IHearButton.setBorder(BorderButtons);
		this.ISayButton.setBorder(BorderButtons);
		
		panelToAddButtons.add(this.ISayButton);
		panelToAddButtons.add(this.IHearButton);
	}
	
	//Set new colors for the buttons
	public void setColors(Color colorIHear, Color colorISay){
		this.colorIHear = colorIHear;
		this.colorISay = colorISay;
	}
	
	//Set a new border for both buttons
	public void setBorder(Border newBorder){
		this.BorderButtons = newBorder;
	}
	
	public JButton getISayButton(){
		return this.ISayButton;
	}
}
