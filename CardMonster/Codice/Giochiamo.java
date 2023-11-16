package Project;


public class Giochiamo {

	public static void main(String[] args) {
		

	Eroe eroe = new Eroe(); 
	Vampiro vampiro = new Vampiro();
	Licantropo licantropo = new Licantropo();
	
	
	eroe.combatti();
	eroe.combatti();
	eroe.combatti();
	
	vampiro.azzanna();
	
	licantropo.setisUomo(false);
	licantropo.combatti();
	licantropo.combatti();
	
	System.out.println("Ecco la forza dell'eroe: " + eroe.getForza() );
	System.out.println("Ecco la forza dell'eroe: " + vampiro.getForza() );
	System.out.println("Ecco la forza dell'eroe: " + licantropo.getForza() );
	
	}

}
