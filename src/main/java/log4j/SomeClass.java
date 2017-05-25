package log4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SomeClass implements Runnable{

	private String name = SomeClass.class.getName();
	private  Log4jHandler log4jHnadler;
	
	
	public SomeClass() {
		List<String> list = new ArrayList<String>();
		list.add("INFO");
		
		log4jHnadler = new Log4jHandler(name, "1MB", 5,list);
	}

	public void run() {
		while(true){
			try {
				log4jHnadler.info("INFO logger");
				addToCart();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

 
    private void addToCart() throws IOException {
    	log4jHnadler.error("ERROR logger");
    }


}
