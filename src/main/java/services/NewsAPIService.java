//in this class we are going to create our methods that will be used of our library 

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
import model.thenewsdb.NewsResult;

//we create two variables about API_URL and API_KEY
public class NewsAPIService {
    private final String API_URL;
    private final String API_KEY;
	
//we add the constructor. Each user who is to join our library has to give values for these two variables    
    public NewsAPIService(String aPI_URL, String aPI_KEY) {
		API_URL = aPI_URL;
		API_KEY = aPI_KEY;
	} 
    
//the methods mentioned in this class will return results as a list. These methods were constructed according to the 
//the requirements of the project
    
//the following method brings us results for the top-headlines news of the user's country of choice
     
    //this is the endpoint we run in postman program for country Greece 
    //https://newsapi.org/v2/top-headlines?country=gr&apikey= (here enter your apikey)
 	
 	public List<newsinfo> getPopularNewsForCountry(String parameter) throws NewsAPIException {
 		NewsResult result = getAPIData("top-headlines", parameter,null,null,null,null, API_URL, API_KEY);
 		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
 		for (Article theResult : result.getArticles()) {
 			NewsInfoList.add(new newsinfo(theResult));
 		}
 		return NewsInfoList;
 	}

 		
//the following method brings us results for the top-headlines news of the user's category of choice 
 	
 	//these are the endpoints we run in postman program for the categories business and entertainment
 	//https://newsapi.org/v2/top-headlines?country=gr&category=business&apikey= (here enter your apikey)
 	//https://newsapi.org/v2/top-headlines?country=gr&category=entertainment&apikey= (here enter your apikey)
 	
 	public List<newsinfo> getPopularNewsForCategory(String parameter, String parameter2) throws NewsAPIException {
 		NewsResult result = getAPIData("top-headlines", parameter, parameter2,null, null,null, API_URL, API_KEY);
 		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
 		for (Article theResult : result.getArticles()) {
 			NewsInfoList.add(new newsinfo(theResult));
 		}
 		return NewsInfoList;
 	}
 	
	
//the following methods are searching for queries 
 	
// in the context of the project; the program is asked to bring us top-headlines news after a search with a selected query 
//that is the word which will be in the title or body of the news. We run the endpoint with the word Apple in postman program.
 	//https://newsapi.org/v2/everything?q=Apple&apikey= (here enter your apikey)
 	
 	public List<newsinfo> searchAQueryForNews(String parameter) throws NewsAPIException {
 		NewsResult result = getAPIData("everything", parameter,null,null,null,null, API_URL, API_KEY);
 		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
 		for (Article theResult : result.getArticles()) {
 			NewsInfoList.add(new newsinfo(theResult));
 		}
 		
 		return NewsInfoList;
 		
 	}
//here the program is asked to bring us top-headlines news after a search where we have set the parameters; query and language 
 	//We run the endpoint with the word Apple and english language in postman program
 	//https://newsapi.org/v2/everything?q=Apple&language=en&apikey= (here enter your apikey)
 	
 	public List<newsinfo> searchLanguageForNews(String parameter, String parameter2) throws NewsAPIException {
 		NewsResult result = getAPIData("everything", parameter,parameter2, null,null,null, API_URL, API_KEY);
 		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
 		for (Article theResult : result.getArticles()) {
 			NewsInfoList.add(new newsinfo(theResult));
 		}
 		
 		return NewsInfoList;
 		
 	}
//here the program is asked to bring us top-headlines news after a search where we have set the parameters; query, language and a news' source  
 	//We run the endpoint with the word Apple, english language and the source bbc-news in postman program
 	//https://newsapi.org/v2/everything?q=Apple&language=en&sources=bbc-news&apikey= (here enter your apikey)
 	
 	 	public List<newsinfo> searchSourceForNews(String parameter, String parameter2, String parameter3) throws NewsAPIException {
 	 		NewsResult result = getAPIData("everything", parameter,parameter2, parameter3,null,null, API_URL, API_KEY);
 	 		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
 	 		for (Article theResult : result.getArticles()) {
 	 			NewsInfoList.add(new newsinfo(theResult));
 	 		}
 	 		
 	 		return NewsInfoList;
 	 		
 	 	}
//here the program is asked to bring us top-headlines news after a search where we have set the parameters; 
 	//query, language, a news' source and time of publication	
 	//We run the endpoint with the word Apple, english language, the source bbc-news in postman program for news which were posted in space 25-31/01/2022
 	//https://newsapi.org/v2/everything?q=Apple&language=en&sources=bbc-news&from=2022-02-14&to=2022-02-19&apikey= (here enter your apikey)
 	
 	public List<newsinfo> searchDateofPublicationForNews(String parameter, String parameter2,String parameter3, String parameter4, String parameter5) throws NewsAPIException {
 		NewsResult result = getAPIData("everything", parameter,parameter2,parameter3,parameter4,parameter5, API_URL, API_KEY);
 		List<newsinfo> NewsInfoList = new ArrayList<>(result.getArticles().size());
 		for (Article theResult : result.getArticles()) {
 			NewsInfoList.add(new newsinfo(theResult));
 		}
 		
 		return NewsInfoList;
 		
 	}
 	
 	
 	//in this step we build our uri and put the segments. We use the apiFunction to not constantly repeat the words of top-headlines and everything
	//Finally I add a parameter, which Postman needs and is my apikey.
 	//get APIData
    private NewsResult getAPIData(String apiFunction, String parameter, String parameter2, String parameter3, String parameter4, String parameter5, String API_URL, String API_KEY) throws NewsAPIException {
    	
    	try {
			final URIBuilder uriBuilder= new URIBuilder(API_URL).setPathSegments("v2", apiFunction).addParameter("apikey", API_KEY);
	//In if we deal with the parameters; what we want to ask for
			if (parameter != null && !parameter.isEmpty()) {
				switch (apiFunction) {
				case "top-headlines":
					if (parameter!=null) {
				        uriBuilder.addParameter("country", parameter);
					}
					if (parameter2!=null) {
						uriBuilder.addParameter("category", parameter2);
					}
				  
				  //uriBuilder.addParameter("sources=bbc-news", parameter5);
				  break; 
				 case "everything": 
					if(parameter!=null) {
						uriBuilder.addParameter("q", parameter);
					}
					if(parameter!=null) {
						uriBuilder.addParameter("language", parameter2);
					}
					if(parameter!=null) {
						uriBuilder.addParameter("sources", parameter3);
					}
					if(parameter!=null) {
						uriBuilder.addParameter("from", parameter4);
					}
					if(parameter!=null) {
						uriBuilder.addParameter("to", parameter5);
					}
				   break;
				
		}
			}
			
			final URI uri=uriBuilder.build(); 
   //Then I create an httpClient object and as in Postman we press send, here we write the execute and get the answers	
   //If the status is not ok we tell to program to make an error response object. 
   //If it is ok the program bring us the result (NewsResult).		
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

				return mapper.readValue(entity.getContent(), NewsResult.class);
			} catch (IOException e) {
				throw new NewsAPIException("Error requesting data from the NewsAPI.", e);
			}
			
		} catch (URISyntaxException e) {
			throw new NewsAPIException("Unable to create request URI.", e);
			
		}
    	
    	
    	
    	
    }
}