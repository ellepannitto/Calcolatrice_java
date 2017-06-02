/**
 * Gestisce il motore di calcolo della calcolatrice.
 * */
public class Calcolatrice
{
	private float part_res = 0;
	private float prod = 1;
	
	private float curr = 0;
	
	private float pot = 1;
	
	private boolean last_key_pressed_was_result = false;
	
	private char last_op = '#';
	
	private enum Flag {
		MUL,
		DIV,
		NIL
	};
	
	private Flag op = Flag.NIL;
	
	/**
	 * Esegue l'ultima operazione in sospeso.
	 * */
	private void do_pending_operation()
	{
		
		switch (this.last_op)
		{
			case '+':
					this.plus_pressed(); 
					break;
			case '-':
					this.minus_pressed();
					break;
			case '*':
					this.times_pressed();
					break;
			case '/':
					this.quot_pressed();
					break;
			default:
					break;
		}
		
		this.last_op = '#';
	}
	
	/**
	 * Esegue l'ultima moltiplicazione o divisione per fare in modo che venga rispettata la precedenza degli operatori.
	 * */
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
		}
	}
	
	/**
	 * Gestisce la pressione del tasto C (canc), cancellando tutte le operazioni svolte.
	 * 
	 * @return 0
	 * */
	public float canc_pressed ()
	{
		this.reset ();
		
		return 0;
	}

	/**
	 * Gestisce la pressione del tasto X (ce), cancellando solo l'ultimo numero immesso.
	 * 
	 * @return 0
	 * */
	public float ce_pressed ()
	{
		this.curr = 0;
		
		return 0;
	}
	
	/**
	 * Gestisce la pressione di un qualsiasi tasto del tastierino
	 * 
	 * @param c char identificativo del tasto premuto
	 * 
	 * @return valore da visualizzare sul display
	 * */
	public float generic_pressed (char c)
	{
		float res = this.curr;
		boolean prev_last_key_pressed_was_result = this.last_key_pressed_was_result;
		
		if ( '0'<=c && c<='9' )
		{
			int n = c-48;
			if ( this.last_key_pressed_was_result )
			{
				this.reset ();
			}
			
			this.do_pending_operation();
			
			res = this.digit_pressed(n);
			this.last_key_pressed_was_result = false;
		}
		else
		{
			this.last_key_pressed_was_result = false;
		
			switch(c)
			{
				case '+': case '-':	case '*': case '/':
						this.last_op = c;
						break;
				case '=': case '\n':
						res = this.result_pressed();
						this.last_key_pressed_was_result = true;
						this.last_op = '#';
						break;
				case '.':
						this.do_pending_operation();
						if ( prev_last_key_pressed_was_result )
						{
							this.reset ();
						}
						res = this.dot_pressed();
						break;
				case 'C':
						res = this.canc_pressed();
						break;	
				case 'X':
						res = this.ce_pressed();
						break;	
				default:
					this.last_key_pressed_was_result = prev_last_key_pressed_was_result;
			}
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
	
	
	/**
	 * Gestisce la pressione del puntino divisore per la porzione decimale di un numero.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float dot_pressed()
	{
		if ( pot == 1 )
		{
			pot = 0.1f;
		}
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
		float ret = curr;
		
		riduci();
		curr = 0;
		op = Flag.DIV;
		
		return ret;
	
	}

	/**
	 * Gestisce la pressione del per.
	 * 
	 * @return il numero da visualizzare
	 * 
	 * */
	public float times_pressed()
	{
		float ret = curr;
		
		riduci();
		curr = 0;
		op = Flag.MUL;
		
		return ret;
	
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
			
		float res = part_res;
		
		curr = part_res;
		part_res = 0;
		prod = 1;
		op = Flag.NIL;
		
		return res;
	}
	
	/**
	 * Resetta la calcolatrice
	 * */
	public void reset()
	{
		part_res = 0;
		prod = 1;
		curr = 0;
		op = Flag.NIL;
		last_op = '#';
	}
	
}
