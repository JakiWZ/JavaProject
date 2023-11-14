package QuintaLezione4;

import java.util.Random;
import java.util.Scanner;

public class BalckJack {

	public static void main(String[] args) {

		int carteBOT[] = new int[2];
		int sommaArrayBOT = 0;
		int manoInzialeBOT = 0;


		Scanner input = new Scanner(System.in);
		Random random = new Random();

		// --------------- BOT ------------------------

		// inseriscio un numero random da 0 a 10 per il bot
		
		carteBOT[0] = random.nextInt(10) + 1;  
		carteBOT[1] = random.nextInt(10) + 1; 

		manoInzialeBOT = carteBOT[0] + carteBOT[1]; 
		
		System.out.println("----------Turno BOT---------------\n");
		System.out.println("Ecco le carte del bot: [[" + manoInzialeBOT + "]] \n");
		System.out.println("----------------------------------");
		
		// --------------- FINE BOT -------------------

		// --------------- PLAYER ---------------------

		String sceltaPlayer = "";
		int cartePlayer[] = new int[40];
		int sommaArrayPlayer = 0, manoInizialePlayer = 0;
		int nuovaMano = random.nextInt(10) + 1;

		// genero dentro l'array del player carte da 0 a 1
		
		cartePlayer[0] = random.nextInt(10) + 1;  
		cartePlayer[1] = random.nextInt(10) + 1; 
		
		manoInizialePlayer = cartePlayer[0] + cartePlayer[1];
		
		System.out.println("----------Prima Mano---------------\n");
		System.out.println("Ecco la tua mano iniziale: [[" + cartePlayer[0] + "]] e [[" + cartePlayer[1] + "]]"+ " Per un totale di: [[" + manoInizialePlayer + "]]\n");
		System.out.println("-------------------------------------\n");

		
		do{ 
			System.out.println("----------Turno Player---------------\n");
			
			System.out.println("Vuoi altre carte? [y [per continuare] / n [per finire]");
			sceltaPlayer = input.nextLine();
			
			if(sceltaPlayer.equalsIgnoreCase("y")) {
			sommaArrayPlayer = nuovaMano += manoInizialePlayer;
			
			System.out.println("Per ora in mano hai un totale di: [[" + sommaArrayPlayer + "]]\n");
			
			System.out.println("-------------------------------------\n");
			}
		
		
		} while(sceltaPlayer.equalsIgnoreCase("y") && sommaArrayPlayer <= 21);

		if(sommaArrayPlayer > 21 || manoInizialePlayer > 21) {
			System.out.println("Hai perso");
		} else if(sommaArrayPlayer > manoInzialeBOT || manoInizialePlayer > sommaArrayBOT) {
			System.out.println("Hai vinto!");
		} else if(sommaArrayPlayer < manoInzialeBOT || manoInizialePlayer < sommaArrayBOT) {
			System.out.println("Hai perso!");
		}


	}

}
