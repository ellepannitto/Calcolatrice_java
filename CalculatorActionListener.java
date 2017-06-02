import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Gestisce la pressione dei bottoni della calcolatrice.
 * */
public class CalculatorActionListener implements ActionListener{

	private Calcolatrice c;
	private CalcolatriceGUI g;
	private char p;

	/**
	 * 
	 * @param c calcolatrice
	 * @param g GUI della calcolatrice
	 * @param pressed pulsante premuto
	 * */
	public CalculatorActionListener (Calcolatrice c, CalcolatriceGUI g, char pressed)
	{
		this.c = c;
		this.g = g;
		this.p = pressed;
	}
	
	/**
	 * Simula la pressione del tasto e mostra il risultato sulla GUI.
	 * 
	 * @param e ActionEvent ignorato (necessario per l'override)
	 * */
	public void actionPerformed(ActionEvent e) 
	{
		float res = c.generic_pressed(this.p);
		
		g.show_result(res);
	}
}
