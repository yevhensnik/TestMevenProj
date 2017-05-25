package httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;

public class ForTestMain implements Runnable{

	List<NameValuePair> urlParameters;
	public ForTestMain() {
		urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("method", "links.getStats"));
		urlParameters.add(new BasicNameValuePair("format", "json"));
		urlParameters.add(new BasicNameValuePair("urls", "http://www.pravda.com.ua/"));
	}
	

	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = null;
		for (int i = 0; i < 5; i++) {
			thread = new Thread(new ForTestMain());
			thread.start();
		}
		thread.join();
	}
	
	
	/**
	 * TODO test taskssssss
	 */
//TODO test222222
	public void run() {
		
		

		for (int i = 0; i < 5; i++) {
			try {
				HTTPRequestHandler handler = new HTTPRequestHandler();
				handler.executeGet("http://jsonlint.com/");
				handler.executePost(urlParameters, "http://api.facebook.com/restserver.php?");
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	

}
