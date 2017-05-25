package httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class GetThread extends Thread {

    private final CloseableHttpClient httpClient;
    private final HttpGet httpget;

    private String result;
    
    public GetThread(CloseableHttpClient httpClient, HttpGet httpget) {
        this.httpClient = httpClient;
        this.httpget = httpget;
    }

    @Override
    public void run() {
    	System.out.println("THREAD IN");
		
		try {
			CloseableHttpResponse httpResponse;
			
			httpResponse = httpClient.execute(httpget);
			
			System.out.println("GET Response Status:: "
					+ httpResponse.getStatusLine().getStatusCode());

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			httpResponse.close();
			
			
			result = response.toString();
			//System.out.println("THREAD OUT");
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public String getResult() {
		return result;
	}
 

}

