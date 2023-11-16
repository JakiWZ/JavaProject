package Project;

public class Vampiro implements Mostro, Personaggio {

	// froza del mostro
	
	private int forza = 15;

	// richiamo metodo getFroza da Personaggio
	
	@Override
	public int getForza() {
		
		return forza ;
		
	}

	// richiamo metodo azzanna da Mostro
	
	@Override
	public void azzanna() {

		forza -= 2;

	}
	


}
