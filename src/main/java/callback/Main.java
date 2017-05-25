package callback;

public class Main {

	static Tolik tolik = new TolikAlcoholik();
	
	public static void main(String[] args) {
		TolikNarkoman nark = new TolikNarkoman(tolik);
		
		nark.run();
	}
}
