# Calcolatrice_java

* Per eseguire:
	
	javac *.java
	java CalcolatriceGUI
	
* La calcolatrice rispetta la precedenza degli operatori, ma non visualizza il risultato intermedio delle operazioni per permettere di sovrascrivere l'ultimo operatore selezionato. Ad esempio, se si inserisce la sequenza "6+3*5 =" la calcolatrice visualizza 6, poi 3, poi 5 e infine il risultato (21). In questo modo le operazioni vengono eseguite nell'ordine corretto. Se si inserisce la sequenza "6+3+8=" non viene visualizzato il risultato intermedio, 9, dopo il secondo più. 
Questo comportamento non è conforme con quello delle normali calcolatrici (come http://www.calcolatriceonline.it/), tuttavia permette di sovrascrivere l'ultimo operatore. Se per esempio si inserisce la sequenza "6+3+" e poi ci si accorge di voler correggere l'ultimo "più" con un "per", si può semplicemente digitare "*" e continuare la sequenza, ottenendo il risultato con l'ordine corretto di precedenza. Es. nel caso di "6+3+*5=" si ottiene 21 come risultato, mentre in una calcolatrice come quella nel link si otterrebbe 45.

* Il tasto X corrisponde al tasto CE delle calcolatrici standard, cancella l'ultimo numero inserito. Per esempio la sequenza "8+35X" corrisponde alla sequenza "8+".

* La stringa non viene memorizzata e poi parsata ma vegono usate solo due variabili per mantenere i risultati parziali dei calcoli e dei flag per sapere quale operazione va eseguita. Questo per mimare il funzionamento di una calcolatrice "tradizionale".
