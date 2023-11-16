package Project;

public class Eroe implements Umano, Personaggio {

	
	private int forza = 10;


	// richiamo metodo combatti da Eroe
	
	@Override
	public void combatti() {

		forza -= 3;

	}

	// richiamo metodo getFroza da Personaggio
	
	@Override
	public int getForza() {
		
		return forza ;
		
	}

}
