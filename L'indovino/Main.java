/*
 * L'indovino
 * 
 * Il gioco dell'indovino è un gioco a tentativi. Viene generato un numero casuale compreso tra 1 e 100 
 * e avrai 5 tentativi per cercare di indovinarlo. Durante i 5 tentativi ti verrà indicato se il numero è maggiore 
 * o minore di quello generato dal computer. Buon divertimento! 
 * 
 */



package Lindovino;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		// Creo l'oggetto Random
		Random random = new Random();

		// Creo la variabile giocatore
		int numGiocatore;	    	
		
		// genera numero casuale tra 0 e 100
		int numGioco = random.nextInt(100);

		int tentativo = 1;

		// creo lo scanner
		Scanner in = new Scanner(System.in);
	
		// visualizzazione numero random
//		 System.out.println("randomNumber = " + numGioco);

			// Questo do-while serve per fermare il giocatore quando a trovato il numero esatto oppure dopo aver usato 5 tentativo.
			do {
				
				// visualizza il benvenuto
				benvenuto();
				
				// prendo in input il valore utente
				numGiocatore = in.nextInt();
								
				// sè il numero è uguale a quello del gioco stampa la vincita
				if (numGioco == numGiocatore)

					System.out.println("Hai vinto il numero è uguale");
				
				// sè il numero del gioco è maggiore del giocatore stampa l'errore
				else if (numGioco > numGiocatore) {
					
					System.out.println("-------------------------------------------------");
					System.out.println("Hai perso il numero è maggiore - " + "tentativo n" + tentativo);
					System.out.println("-------------------------------------------------");
					tentativo ++;

				}
				
				// sè il numero del gioco è minore del giocatore stampa l'errore
				else if (numGioco < numGiocatore) {
					
					System.out.println("-------------------------------------------------");
					System.out.println("Hai perso il numero è minore - " + "tentativo n" + tentativo);
					System.out.println("-------------------------------------------------");
					
					tentativo ++;
				}
				
				// sè il tentativo è pari a 5 allora fà visualizzare in automatico il risultato
				tentativo(tentativo, numGioco);
				
			
				// controllo sè il numero del giocatre e diverso e i tentativi
			} while(numGioco != numGiocatore && tentativo <= 5);

	}
	// benvenuto
	public static void benvenuto () {
		
		System.out.println("-------------------------------------------------");
		System.out.println("Bevenuto! L'indovino è semplice sè il numero che inserisci è uguale al gioco hai vinto!");
		System.out.println("Attenzione hai solo 5 tentativi!");
		System.out.println("-------------------------------------------------");
		
	}
	
	// tentativi
	public static void tentativo (int tentativo, int numGioco) {
		
		if (tentativo == 6) {
			System.out.println("Hai eusarito i tentativo! \n");
			System.out.println("il numero era... " + numGioco);
			
		}
		
	}
 }
