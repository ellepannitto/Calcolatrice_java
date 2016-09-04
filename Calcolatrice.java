

public class Calcolatrice
{
	private float part_res = 0;
	private float prod = 1;
	
	private float curr = 0;
	
	private float pot = 1;
	
	private enum Flag {
		MUL,
		DIV,
		NIL
	};
	
	private Flag op = Flag.NIL;
	
	private void riduci ()
	{
		pot = 1;
		
		switch(op)
		{
			case MUL: 	prod *=curr;
						break;
			case DIV:	prod/=curr;
						break;
			default:	prod*=curr;
			//~ default:	prod=1;
		}
	}
	
	
	public float generic_pressed (char c)
	{
		float res;
		
		switch(c)
		{
			case '+':
					res = this.plus_pressed(); 
					break;
			case '-':
					res = this.minus_pressed();
					break;
			case '*':
					res = this.times_pressed();
					break;
			case '/':
					res = this.quot_pressed();
					break;
			case '=': case '\n':
					res = this.result_pressed();
					break;
			case '.':
					res = this.dot_pressed();
					break;
			default:
					int n = c-48;
					res = this.digit_pressed(n);
		}

		return res;
	}
	
	
	/**
	 * Gestisce la pressione di una cifra sulla tastiera numerica.
	 * @param n cifra premuta
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float digit_pressed(int n)
	{
		if (pot!=1)
		{
			curr = curr + n*pot;
			pot /=10;
		}
		else
		{
			curr = 10*curr + n;
		}
		return curr;
	}

	public float number_pressed(float n)
	{
		prod=part_res;
		curr=1;
		part_res=n;
		return part_res;
	}
	
	
	
	/**
	 * Gestisce la pressione del puntino divisore per la porzione decimale di un numero.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float dot_pressed()
	{
		pot = 0.1f;
		return curr;
	}

	/**
	 * Gestisce la pressione del più.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float plus_pressed()
	{
		riduci();
		part_res+= prod;
		
		System.out.println("Prod:"+prod+", Curr:"+curr);
		
		prod = 1;
		curr = 0;
		op = Flag.NIL;
		
		
		return part_res;
	}


	/**
	 * Gestisce la pressione del meno.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float minus_pressed()
	{
		riduci();
		part_res+= prod;
		prod = -1;
		curr = 0;
		op = Flag.NIL;
		
		return part_res;
	
	}

	/**
	 * Gestisce la pressione del diviso.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float quot_pressed()
	{
		riduci();
		curr = 0;
		op = Flag.DIV;
		
		return curr;
	
	}

	/**
	 * Gestisce la pressione del per.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float times_pressed()
	{
		riduci();
		curr = 0;
		op = Flag.MUL;
		
		return curr;
	
	}

	/**
	 * Gestisce la pressione del percento.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float perc_pressed()
	{
		riduci();
		
		return part_res;
	
	}

	/**
	 * Gestisce la pressione dell'uguale.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float result_pressed()
	{
		riduci();
		part_res +=prod;
		
		
		System.out.println("Prod:"+prod+", Curr:"+curr);
		
		float res = part_res;
		
		curr = part_res;
		part_res = 0;
		prod = 1;
		op = Flag.NIL;
		
		return res;
	}
	
	public void reset()
	{
		part_res = 0;
		prod = 1;
		curr = 0;
		op = Flag.NIL;
	}
	
}
