package httpclient;

import java.io.IOException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;

public class HTTPRequestHandler {

	private static HTTPRequestHelper httpRequestHelper = new HTTPRequestHelper();

		
	public HTTPRequestHandler() {

	}
	
	public String executeGet(String url) throws ClientProtocolException, IOException{
		//httpRequestHelper = new HTTPRequestHelper();
		return httpRequestHelper.get(url);
	}
	
	public String executePost(List<NameValuePair> urlParameters, String url) throws IOException{
		//httpRequestHelper = new HTTPRequestHelper();
		return httpRequestHelper.post(urlParameters, url);
	}

}
