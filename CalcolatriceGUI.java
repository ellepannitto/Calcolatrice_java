import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CalcolatriceGUI {

	private JTextField display;

	public CalcolatriceGUI () {
		Calcolatrice calc = new Calcolatrice();

		JFrame interfaccia = new JFrame("Simple Calculator");
		JPanel panel = new JPanel();
		
		GridLayout layout = new GridLayout(2,1);
		interfaccia.setLayout(layout);
		
		
		JPanel keyboard = new JPanel();
		GridLayout layout_keyboard = new GridLayout(5,4);
		keyboard.setLayout(layout_keyboard);
				
				
		interfaccia.setSize(300, 400);
		interfaccia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CalculatorButton digits[] = new CalculatorButton[10];
		for (int i=0; i<10; i++)
		{
			String x = Integer.toString(i);
			digits[i]=new CalculatorButton(x, calc, this, panel);
		}
		
		CalculatorButton result = new CalculatorButton("=", calc, this, panel);
		
		CalculatorButton plus = new CalculatorButton("+", calc, this, panel);

		CalculatorButton minus = new CalculatorButton("-", calc, this, panel);

		CalculatorButton times = new CalculatorButton("*", calc, this, panel);
		
		CalculatorButton quot = new CalculatorButton("/", calc, this, panel);
		
		CalculatorButton dot = new CalculatorButton(".", calc, this, panel);
				
		display = new JTextField(25);
	
		keyboard.setFocusable(true);
		keyboard.addKeyListener(new CalculatorKeyListener(calc, this));
		
		panel.add(display);
		
		keyboard.add(result);
		keyboard.add(plus);
		keyboard.add(minus);
		keyboard.add(times);
		keyboard.add(quot);
		keyboard.add(dot);
		
		for (int i=0; i<digits.length; i++)
		{
			keyboard.add(digits[i]);
		}
		
		interfaccia.add(panel);
		interfaccia.add(keyboard);
		
		interfaccia.setVisible(true);
		
	}

	public static void main (String[] args)
	{
		CalcolatriceGUI cg = new CalcolatriceGUI();
	}

	public void show_result (float x)
	{
		String res = Float.toString(x);
		this.display.setText(res);
	}
}
