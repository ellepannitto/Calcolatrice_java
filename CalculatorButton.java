import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorButton extends JButton{

	

	public CalculatorButton (String s, Calcolatrice c, CalcolatriceGUI g, JPanel pan)
	{
		super(s);
		
		addActionListener (new CalculatorActionListener(c, g, s.charAt(0)));
		addKeyListener (new PropagateKeyListener (c, g));
	}
	
	
}
