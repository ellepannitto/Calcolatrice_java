import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorActionListener implements ActionListener{

	private Calcolatrice c;
	private CalcolatriceGUI g;

	public CalculatorActionListener (Calcolatrice c, CalcolatriceGUI g)
	{
		this.c = c;
		this.g = g;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		float res = c.result_pressed();
		g.show_result(res);
	}
}
