import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PropagateKeyListener implements KeyListener{

	private Calcolatrice c;
	private CalcolatriceGUI g;
	private char p;

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
	
	public void keyTyped(KeyEvent e) 
	{
		Component source=(Component)e.getSource();
		source.getParent().dispatchEvent(e);
		
	}
	
	
}
