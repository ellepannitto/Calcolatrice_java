import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcolatriceGUI {

	private JTextField display;

	public CalcolatriceGUI () {
		Calcolatrice calc = new Calcolatrice();

		JFrame interfaccia = new JFrame("Simple Calculator");
		
		interfaccia.setSize(300, 400);
		interfaccia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton digits[] = new JButton[10];
		for (int i=0; i<10; i++)
		{
			digits[i]=new JButton(Integer.toString(i));
		}
		
		JButton result = new JButton("=");
		result.addActionListener(new CalculatorActionListener(calc, this));
		
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton times = new JButton("*");
		JButton quot = new JButton("/");
		JButton dot = new JButton(".");
		
		display = new JTextField(25);
		
		JPanel panel = new JPanel();
		
		panel.add(display);
		panel.add(result);
		panel.add(plus);
		panel.add(minus);
		panel.add(times);
		panel.add(quot);
		panel.add(dot);
		
		for (int i=0; i<digits.length; i++)
		{
			panel.add(digits[i]);
		}
		
		interfaccia.add(panel);
		
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
