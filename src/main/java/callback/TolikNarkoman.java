package callback;

public class TolikNarkoman implements Runnable {

	private Tolik tolik ;
	
	public TolikNarkoman(Tolik tolik) {
		this.tolik = tolik;
	}
	
	public void run() {
		// шось тут собі робить, парить
		
		// бля дощ почався
		this.tolik.onPadeRain("На районі заворушка");
		
	}
}
