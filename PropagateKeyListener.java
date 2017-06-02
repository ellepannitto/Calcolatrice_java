import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Gestisce la pressione dei tasti della tastiera.
 * */
public class PropagateKeyListener implements KeyListener{

	private Calcolatrice c;
	private CalcolatriceGUI g;
	private char p;

	/**
	 * Inizializza il gestore.
	 * 
	 * @param c calcolatrice
	 * @param g GUI
	 * */
	public PropagateKeyListener (Calcolatrice c, CalcolatriceGUI g)
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
	 * Gestisce invio del codice relativo alla pressione di un tasto al keyListener.
	 * */
	public void keyTyped(KeyEvent e) 
	{
		Component source=(Component)e.getSource();
		source.getParent().dispatchEvent(e);
		
	}
}
