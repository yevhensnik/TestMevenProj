 package httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HTTPRequestHelper {
	
	
	private static PoolingHttpClientConnectionManager cm;
	private static CloseableHttpClient httpClient;

	public HTTPRequestHelper() {
		init();
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	/**
	 * initialization PoolingHttpClientConnectionManager;
	 * setMaxTotal(10); Set the maximum number of total open connections.
	 * setDefaultMaxPerRoute(10); Set the maximum number of concurrent connections per route, which is 2 by default.
	 * 
	 * initialization httpClient, set pool settings in httpClient.
	 */
	private void init(){
		cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(10);
		cm.setDefaultMaxPerRoute(10);
		
		httpClient = HttpClients.custom()
		        .setConnectionManager(cm)
		        .build();
	}
	
	public String get(String url) throws ClientProtocolException, IOException{
		
		HttpGet httpget = new HttpGet(url);
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
		
		String result = response.toString();
		return result;
		
	}
	
	public String post(List<NameValuePair> urlParameters, String url) throws IOException {

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));
		
		CloseableHttpResponse httpResponse;
		
		httpResponse = httpClient.execute(httpPost);

		System.out.println("Response Code : " + httpResponse.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		String response = result.toString();
		rd.close();
		httpResponse.close();

		return response;
	}

}
