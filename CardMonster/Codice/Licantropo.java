package Project;

public class Licantropo implements Umano,Mostro,Personaggio {


	// variabili che mi servono nel programma 

	private boolean isUomo = false;
	private int forzaUmano = 10;
	private int forzaMostro = 15;


	// richiamo metodo getFroza da Personaggio

	@Override
	public int getForza() {

		return (forzaUmano + forzaMostro) / 2;

	}

	// richiamo metodo combatti da Eroe

	@Override
	public void combatti() {

		if (isUomo) {
			forzaUmano -= 2;
		} else {
			forzaMostro -= 3;
		}

	}

	// richiamo metodo azzanna da Mostro

	@Override
	public void azzanna() {

		if (!isUomo) {
			forzaUmano -= 3;
		} else {
			forzaMostro -= 2;
		}

	}

	// controllare se sei uomo o mostro
	public void setisUomo(boolean isUomo) {

		this.isUomo = isUomo;

		if (isUomo) {
			forzaUmano = 10;
		} else {
			forzaMostro = 15;
		}

	}
}
