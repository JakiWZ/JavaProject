package InterfacciaATM;

import java.util.Random;
import java.util.Scanner;

/* Interfaccia ATM
 *
 *	Proggetto creazione di un interfaccia ATM
 *
 *	Visualizzazione stato saldoBancario
 *	Ritirare
 *	versamento
 *	Trasferimento
 *	Esci 	
 * 	
 */


public class Main {

	public static void main (String[] args) {
		
		// VARIABILI
		
		//Intestatario
		String intestatario = "";
		int userID = 0;
		int userIDrandom = 0;
		int userPIN = 0;
		int userPINrandom = 0;

		// Swtich 
		int scelta = 0;

		// Conto corrente
		int saldoBancario = 0;

		// Versamento
		int versamento = 0;
		int sceltaVersamento = 0;
		boolean checkVersamento = false;

		// Ritiro
		int ritiro = 0;
		int sceltaRitiro = 0;
		boolean checkRitiro = false;

		// Trasferimento
		String destinatario = "";
		int trasferimento = 0;
		int sceltaTrasferimento = 0;
		boolean checkTrasferimento = false;

		// Cronologia
		int cronologia = 0;
		boolean checkCronologia = false;

		// Esci
		int sceltaUscita = 0;
		boolean finish = false;
		
		boolean switch_esterno = true;
		
		// crea un'istanza della classe Random
		Random random = new Random();
		
		// genera un intero casuale compreso tra 1000 e 99999 (inclusi)
		userIDrandom = random.nextInt(90000) + 1000;
		
		// genera un intero casuale compreso tra 1000 e 99999 (inclusi)
		userPINrandom = random.nextInt(90000) + 1000;
		
		
		Scanner in = new Scanner (System.in); // creazione dello scanner
		

		// Schermata di benvneuto
		System.out.println("--------WELCOME--------");	
		
		// chiedo all'intestario il suo nome o codice
		System.out.println("Chi è l'Intestatario?");		
		intestatario = in.nextLine();						
		
		
		System.out.println("Ecco il tuo codice identificativo appena generato: [" + userIDrandom + "]");
		userID = in.nextInt();
		System.out.println("Ecco il tuo codice pin appena generato: [" + userPINrandom + "]");
		userPIN = in.nextInt();
	
		
		// viene prima convertito il valore intero in una stringa utilizzando il metodo String.valueOf(), e poi viene utilizzato il metodo length() per controllare la lunghezza della stringa.
		
		if (userID == userIDrandom && userPIN == userPINrandom) {
			
		 System.out.println("Ciao, " + intestatario + ". Dettagli di autenticazione corretti. Funzionalità ATM sbloccate.");
		
		// ciclo do-while per far ripetere l'interfaccia ATM

		do	{			

			// visualizzazione menu
			String richiesta = richiestaScelta (intestatario);

			// prendo in input la scelta
			scelta = in.nextInt();

			// swtich iniziale dopo che la persona sceglie cosa fare
			switch (scelta) {
			
			case 1:

				// visualizza il benvenuto per il versamento
				benvenutoversamento();


				// visualizza il menu per il versamento
				richiestaVersamento();
				
				// prendo in input la scelta
				sceltaVersamento = in.nextInt();

				// swtich per la scelta dal menu versamento
				switch (sceltaVersamento) { 

				case 1:
					
					/*
					 * In questo if all'inizio chiedo all'intestatario quanto vuole depositare
					 * nel 1 controllo if sè il versamento equivale a 0 esce il primo errore
					 * nel 2 controllo else if sè il versamento è maggiore di 10.000 esce il secondo errore
					 * nel 3 controllo else in caso la cifra sarà esatta il versamento verrà aggiunto nel conto bancario [saldobancario]
					 */

					System.out.println("Quanto vuoi depositare? " + intestatario);
					versamento = in.nextInt();

					if (versamento <= 0) {
						System.out.println("Impossibile depositare la cifra desiderata");
						System.out.println("--------------------------");
					} else if (versamento > 10000) {
						System.out.println("Impossibile depositare una cifra superiore a 10000€");
						System.out.println("--------------------------");
					} else {
						saldoBancario += versamento;
						System.out.println("versamento effettuato con successo");
						System.out.println("--------------------------");
					}

					break;

				case 2:
					
					// uscita dal menu versamento e ritorno al menu normale

					checkVersamento = true;
					System.out.println("--------------------------");
					break;

				}


				break;

			case 2:

				// visualizza il benvenuto ritiro
				benvenutoRitiro ();
				
				// visualizza il menu per il ritiro
				richiestaRitiro ();
				
				// prendo in input la scelta
				sceltaRitiro = in.nextInt();

				// swtich per la scelta dal menu ritiro
				switch (sceltaRitiro) {

				case 1:
					
					/*
					 * In questo if all'inizio chiedo all'intestatario quanto vuole depositare
					 * nel 1 controllo if sè il ritiro è minore o uguale a 20 oppure il saldo bancario è 0 esce il primo errore
					 * nel 2 controllo else if sè il ritiro è maggiore del saldo dentro il saldoBancario esce il secondo errore
					 * nel 3 controllo in caso la cifra da ritirare sarà esatta il ritiro verrà effettuato dal conto bancario [saldobancario]
					 */

					System.out.println("Quanto vuoi ritirare? " + intestatario);
					ritiro = in.nextInt();

					if (ritiro <= 20 || saldoBancario <= 0) {
						System.out.println("Impossibile prelevare la cifra desiderata");
						System.out.println("--------------------------");
					} else if (ritiro > saldoBancario) {
						System.out.println("Impossibile prelevare una cifra superiore al saldo disponibile");
						System.out.println("--------------------------");
					} else {
						saldoBancario -= ritiro;
						System.out.println("Ritiro effettuato con successo");
						System.out.println("--------------------------");
					}

					break;

				case 2:	

					// uscita dal menu versamento e ritorno al menu normale
					
					checkRitiro = true;
					System.out.println("--------------------------");
					break;	

				}


				break;

			case 3:

				// visualizza il benvenuto trasferimento
				benvenutoTrasferimento();

				// inserimento del nome a cui vogliamo trasferire il denaro
				System.out.print("Inserisci il nome del destinatario " + intestatario);
				
				// prendo in input il destinatario
				destinatario = in.next();

				// inserisco l'importo che desidero trasferire
				System.out.print("Inserisci l'importo che desideri trasferire \n");
				
				// prendo in input l'importo
				trasferimento = in.nextInt();

				// visualizzo il menu per il trasferimento
				richiestaTrasferimento();
				
				// prendo in input la scelta del trasferimenti
				sceltaTrasferimento = in.nextInt();

				// swtich per la scelta dal menu trasferimento
				switch (sceltaTrasferimento) {
				case 1:

					/*
					 * In questo if all'inizio chiedo all'intestatario quanto vuole depositare
					 * nel 1 controllo if sè l'importo del trasferimento e maggiore o uguale a 500 viene mostrato il primo errore 
					 * nel 2 controllo else if sè non abbiamo fondi dentro la nostra banca visualizzera il secondo errore
					 * nel 3 controllo else in caso la cifra sarà esatta il trasferimento verra fatto con successo e verrà visualizzato l'importo e il nome del destinatario [saldobancario]
					 */
					
					if (trasferimento <= 500) {
						System.out.println("impossibile trasferire il denaro perchè la soglia minima e di 500€");
						System.out.println("--------------------------");
					}
					else if (saldoBancario - trasferimento <= 0) {
						System.out.println("Il tuo conto bancario è vuoto");
					}
					else {
						saldoBancario -= trasferimento;
						System.out.println("L'importo di " + trasferimento + "€ è stato trasferito con successo a " + destinatario);
						System.out.println("--------------------------");
					}

					break;

				case 2:

					// uscita dal menu trasferimento e ritorno al menu normale
					
					checkTrasferimento = true;
					System.out.println("--------------------------");
					break;

				}

				break;

			case 4:

				// visualizza il benvenuto per la cronologia
				benvenutoCronologia();

				// visualizza il menu per la cronologia
				richiestaCronologia();
				
				// prendo in input la scelta
				cronologia = in.nextInt();

				// swtich per la scelta dal menu cronologia
				switch (cronologia) {

				case 1:

					/*
					 * Primo case dove la persona può controllare il suo conto bancario
					 * nel 1 controllo in caso non c'è denaro dentro il conto bancario verrà mostrato l'errore 
					 * nel 2 controllo else viene visualizzato il saldo
					 */
					
					if (saldoBancario <= 0) {
						System.out.println("Il tuo conto bancario è vuoto");
						System.out.println("--------------------------");
					}
					else {
						System.out.println("L'importo attuale dentro la tua banca è: " + saldoBancario); 
						System.out.println("--------------------------");
					}

					break;

				case 2:
					
					/*
					 * Secondo case dove la persona può controllare il suo denaro trasferito 
					 * nel 1 controllo sè non c'è un destinatario oppure il denaro trasferito equaivale a 0
					 * verrà visualizzato il primo errore 
					 * nel 2 controllo else viene visualizzato il trasferimento con l'importo e nome del destinatario
					 */

					if (destinatario == null || trasferimento <= 0) {
						System.out.println("Non è stato trasferito nulla");
						System.out.println("--------------------------");
					}
					else {
						System.out.println("Hai recentemente trasferito " + trasferimento + "€ a: " + destinatario);
						System.out.println("--------------------------"); }

				case 3:
					
					// uscita dal menu versamento e ritorno al menu normale

					checkCronologia = true;
					System.out.println("--------------------------");
					break;

				}

				break;

			case 5:

				
				// visualizza il benvenuto per l'uscita
				benvenutoEsci();
				
				// visualizza il menu per l'uscita
				richiestaUscita();
				
				// prendo in input la scelta
				sceltaUscita = in.nextInt();

				// swtich per la scelta dal menu esci
				switch (sceltaUscita) {
				case 1:
					
					// esco dal programma

					System.out.println("Arrivederci! " + intestatario);
					System.out.println("------------BYE------------");

					finish = true;
					break;

				case 2:

					// uscita dal menu uscita ritorno al menu normale
					
					checkCronologia = true;
					System.out.println("--------------------------");
				

				}

				break;

			default:

				// in caso la scelta non è valida
				System.out.println("Scelta non valida!");
				break;

			}

		} while(!finish);
		
		} else {
			
			// I dettagli di autenticazione non sono corretti, quindi visualizza un messaggio di errore
            System.out.println("Dettagli di autenticazione non corretti. Riprova.");
		}
	}

	// Menu iniziale ATM
	
	public static String richiestaScelta (String intestatario) {


		
		System.out.println("---------MENU----------");
		System.out.println(intestatario + " Che operazione desideri fare?");
		System.out.println("1) Versamento");
		System.out.println("2) Ritiro");
		System.out.println("3) Trasferimento");
		System.out.println("4) Cronologia");
		System.out.println("5) Esci");
		return intestatario;

	}

	// Tutti i benvenuto 
	
	public static void benvenutoversamento () {

		System.out.println("--------------------------");
		System.out.println("Hai scelto [versamento]");
		System.out.println("--------------------------");

	}
	public static void benvenutoRitiro () {

		System.out.println("--------------------------");
		System.out.println("Hai scelto [Ritiro]");
		System.out.println("--------------------------");

	}
	public static void benvenutoTrasferimento () {

		System.out.println("--------------------------");
		System.out.println("Hai scelto [Trasferimento]");
		System.out.println("--------------------------");

	}
	
	public static void benvenutoCronologia() {

		System.out.println("--------------------------");
		System.out.println("Hai scelto [Cronologia]");
		System.out.println("--------------------------");

	}

	public static void benvenutoEsci() {

		System.out.println("--------------------------");
		System.out.println("Hai scelto [Esci]");
		System.out.println("--------------------------");

	}

	// Tutti i menu
	
	public static void richiestaVersamento () {

		System.out.println("Scegli cosa eseguire");
		System.out.println("1) Versamento");
		System.out.println("2) Ritorna al menu");


	}

	public static void richiestaRitiro () {

		System.out.println("Scegli cosa eseguire");
		System.out.println("1) Ritiro");
		System.out.println("2) Ritorna al menu");


	}

	public static void richiestaTrasferimento () {

		System.out.println("Scegli cosa eseguire");
		System.out.println("1) Trasferimento");
		System.out.println("2) Ritorna al menu");

	}

	public static void richiestaCronologia () {

		System.out.println("Scegli cosa visualizzare");
		System.out.println("1) Conto Corrente");
		System.out.println("2) Trasferimento");
		System.out.println("3) Ritorna al menu");

	}

	public static void richiestaUscita () {

		System.out.println("Scegli cosa eseguire");
		System.out.println("1) Uscita");
		System.out.println("2) Ritorna al menu");

	}

}
