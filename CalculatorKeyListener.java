import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
	
	public void keyTyped(KeyEvent e) 
	{
		System.out.println(e);
		System.out.println(e.getKeyChar());
		
		this.p=e.getKeyChar();
		System.out.println(p);
		
		float res = c.generic_pressed(this.p);
		
		System.out.println(this.p);
		
		g.show_result(res);
	}
	
	
}
