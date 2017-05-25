package log4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SomeSecond implements Runnable{

//	private static Logger log = Logger.getLogger(SomeSecond.class);

//	private static LogClass logClass = new LogClass();
	
	private static String name = SomeSecond.class.getName();
	private  Log4jHandler log4jHnadler;
	
	public SomeSecond() {
		List<String> list = new ArrayList<String>();
		list.add("INFO");
		
		log4jHnadler = new Log4jHandler(name, "2MB", 4, list);
		System.out.println("SomeSecond started");
	}
	
	public void run() {
		while(true){
			try {
				log4jHnadler.error("ERROR logger");
				addToCart();
			} catch (IOException e) {
				e.printStackTrace();
			}
	       
		}
		
	}

 
    private void addToCart() throws IOException {

//    	logClass.getLogger(name + "_DATE", log).fatal("FATAAAL msg");
    	log4jHnadler.fatal("FATAL logger");
    }
}
