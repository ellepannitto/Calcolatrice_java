import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Gestisce la pressione dei tasti della tastiera.
 * */
public class CalculatorKeyListener implements KeyListener{

	private Calcolatrice c;
	private CalcolatriceGUI g;
	private char p;

	public CalculatorKeyListener (Calcolatrice c, CalcolatriceGUI g)
	{
		this.c = c;
		this.g = g;
	}
	
	public void keyReleased(KeyEvent e) 
	{
		;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		;
	}
	
	/**
	 * Simula la pressione del tasto e mostra il risultato sulla GUI.
	 * 
	 * @param e KeyEvent
	 * 
	 * */
	public void keyTyped(KeyEvent e) 
	{	
		this.p=e.getKeyChar();
		
		float res = c.generic_pressed(this.p);
		g.show_result(res);
	}
}
