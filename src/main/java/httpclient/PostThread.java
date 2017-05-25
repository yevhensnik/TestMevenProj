package httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;

public class PostThread extends Thread {

	private final CloseableHttpClient httpClient;
	private final HttpPost httpPost;
	private String response;

	public PostThread(CloseableHttpClient httpClient, HttpPost httpPost) {
		this.httpClient = httpClient;
		this.httpPost = httpPost;

	}

	@Override
	public void run() {
		System.out.println("THREAD IN");

		try {
			
			CloseableHttpResponse httpResponse;
			
			httpResponse = httpClient.execute(httpPost);

			System.out.println("Response Code : " + httpResponse.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			System.out.println("***\n" + result);
			response = result.toString();
			rd.close();
			httpResponse.close();

			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getResponse() {
		return response;
	}
}
