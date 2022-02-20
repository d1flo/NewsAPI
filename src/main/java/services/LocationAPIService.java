//this class is similar to the NewsAPIService and was created to let us do the test for the ip adress

package services;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.NewsAPIException;
import model.newsinfo;
import model.thenewsdb.Article;
import model.thenewsdb.ErrorResponse;
import model.thenewsdb.Location;
import model.thenewsdb.LocationResult;
//import newsapi.LocationAPI;
import model.thenewsdb.NewsResult;

public class LocationAPIService{
	private final String API_URL;
	private final String myIP;
	
	public LocationAPIService(String aPI_URL, String adress) {
		API_URL = aPI_URL;
		myIP = adress;
	
}

	public LocationResult searchUserLocation(String parameter) throws NewsAPIException {
		LocationResult result = getAPIData("v1",parameter, API_URL, myIP); 
		return result;
	} 


private LocationResult getAPIData(String apiFunction, String parameter, String API_URL, String myIP) throws NewsAPIException {
	
	try {
	final URIBuilder uriBuilder= new URIBuilder(API_URL).setPathSegments("api", apiFunction).addParameter("ipAddress", myIP);
	if (parameter!=null && !parameter.isEmpty()) {
		   switch (apiFunction) {
		  case "v1" :
			  if(parameter!=null){
			  uriBuilder.addParameter("apiKey", parameter);	
			  }
		  break;
		  
		   }
		   
	}
	final URI uri = uriBuilder.build();
	
	final HttpGet getRequest = new HttpGet(uri);
	final CloseableHttpClient httpclient = HttpClients.createDefault();
	try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
		final HttpEntity entity = response.getEntity();
		final ObjectMapper mapper = new ObjectMapper();

		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
		ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
		if (errorResponse.getStatus() != null)
				throw new NewsAPIException("Error occurred on API call: " + errorResponse.getStatus());
		}

		return mapper.readValue(entity.getContent(), LocationResult.class);
	} catch (IOException e) {
		throw new NewsAPIException("Error requesting data from the NewsAPI.", e);
	}
	
} catch (URISyntaxException e) {
	throw new NewsAPIException("Unable to create request URI.", e);
	
}
}

}