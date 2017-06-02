import java.util.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Crea un bottone del display.
 * */
public class CalculatorButton extends JButton{

	
	/**
	 * Inizializza un oggetto di classe CalculatorButton, gli associa un ActionListener e un KeyListener.
	 * 
	 * @param s testo del bottone
	 * @param c calcolatrice di appartenenza
	 * @param g GUI di appartenenza
	 * */
	
	public CalculatorButton (String s, Calcolatrice c, CalcolatriceGUI g)
	{
		super(s);
		
		addActionListener (new CalculatorActionListener(c, g, s.charAt(0)));
		addKeyListener (new PropagateKeyListener (c, g));
	}
}
