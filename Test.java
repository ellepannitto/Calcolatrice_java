import java.io.*;
import java.util.*;

public class Test
{
	
	public static void main(String[] args)
	{
		Calcolatrice calc = new Calcolatrice();
		
		Scanner input = new Scanner(System.in);
		
		while (true)
		{
			float res = 0;
			String s = input.next();
			
			for (int i=0; i<s.length(); i++)
			{
				char c= s.charAt(i);
				switch(c)
				{
					case '+':
							res = calc.plus_pressed(); 
							break;
					case '-':
							res = calc.minus_pressed();
							break;
					case '*':
							res = calc.times_pressed();
							break;
					case '/':
							res = calc.quot_pressed();
							break;
					case '=':
							res = calc.result_pressed();
							break;
					case '.':
							res = calc.dot_pressed();
							break;
					default:
							int n = c-48;
							res = calc.digit_pressed(n);
				}
				System.out.println("input: "+c);
				System.out.println("output: "+res);
				
			}
			calc.reset();
		}
		
		//~ c.digit_pressed(5);
		//~ c.plus_pressed();
		
		//~ c.digit_pressed(4);
		//~ c.times_pressed();
		
		//~ c.digit_pressed(2);
		//~ c.minus_pressed();
		
		//~ c.digit_pressed(8);
		//~ c.quot_pressed();
		
		//~ c.digit_pressed(2);
		//~ c.quot_pressed();
		
		//~ c.digit_pressed(2);
		//~ c.plus_pressed();
		
		//~ c.digit_pressed(2);
		//~ c.times_pressed();
		
		//~ c.digit_pressed(5);
		
		//~ System.out.println(c.result_pressed());
	}
}
