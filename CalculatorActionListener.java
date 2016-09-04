import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorActionListener implements ActionListener{

	private Calcolatrice c;
	private CalcolatriceGUI g;
	private char p;

	public CalculatorActionListener (Calcolatrice c, CalcolatriceGUI g, char pressed)
	{
		this.c = c;
		this.g = g;
		this.p = pressed;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		float res = c.generic_pressed(this.p);
		
		System.out.println(this.p);
		
		g.show_result(res);
	}
}
