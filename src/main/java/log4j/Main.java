package log4j;

import java.io.IOException;

public class Main {

	private static SomeClass logic;
	private static SomeSecond logic2;
	

	public static void main(String[] args) throws IOException, InterruptedException {
			
		for (int i = 0; i < 1; i++) {
			logic = new SomeClass();
			logic2  = new SomeSecond();
			
			Thread logicTr = new Thread(logic); 
			logicTr.start();
			
			Thread logic2Tr = new Thread(logic2); 
			logic2Tr.start();	
			
//			Thread.sleep(100);
		}
	}

}
