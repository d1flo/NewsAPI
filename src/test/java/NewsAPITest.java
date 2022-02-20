//this class is made for testing our methods that are mentioned in class NewsAPIService and LocationAPIService

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exception.NewsAPIException;
import model.newsinfo;
import model.thenewsdb.Location;
import model.thenewsdb.LocationResult;
import services.LocationAPIService;
import services.NewsAPIService;

public class NewsAPITest {

	@Before
	public void setUp() throws Exception {
	}
	
//This test finds automatically top-headlines news from the user's country according to IP address 
//if you want to test it please replace my apikey in line 31 with your apikey . 
//You can find your apikey in https://ip-geolocation.whoisxmlapi.com/api/documentation/making-requests
	 @Test
	public void testSearch0API() throws NewsAPIException {
		 final LocationAPIService newsSearchService1= LocationAPI.getLocationAPIService();
		 //type your apiKey
		 final LocationResult results2 = newsSearchService1.searchUserLocation("apikey");
		 String country = Location.getCountry();
		 System.out.println("Your country is: " + country);
	     final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
		 final List<newsinfo> results= newsSearchService.getPopularNewsForCountry(country);
		 Assert.assertFalse(results.isEmpty());
		 results.forEach(System.out::println);
		} 
	 
//This test finds the results for Greece
//if you want to test another country please replace "gr" with one of the options according to the documentation
//the documentation is accessible in https://newsapi.org/docs/endpoints/top-headlines
//Possible other options are: ae,ar,at,au,be,bg,br,ca,ch,cn,co,cu,cz,de,eg,fr,gb,hk,hu,id,ie,il,in
//it,jp,kr,lt,lv,ma,mx,my,ng,nl,no,nz,ph,pl,pt,ro,rs,ru,sa,se,sg,si,sk,th,th,tw,ua,us,ve,za
//Note: you can't mix the country parameter with the sources parameter according to the documentation
  @Test
    public void testSearchAPI() throws NewsAPIException {
		final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
		final List<newsinfo> results= newsSearchService.getPopularNewsForCountry("gr");
		Assert.assertFalse(results.isEmpty());
	    results.forEach(System.out::println);

	} 
	
//This test finds the results for Greece and the category business
//if you want to test another country please replace "gr" with one of the options according to the previous test
//if you want to test another category please replace "business" with one of the options according to the documentation
//the documentation is accessible in https://newsapi.org/docs/endpoints/top-headlines
//Possible options are: entertainment,general,health,science,sports,technology
//Note: you can't mix the category parameter with the sources parameter according to the documentation
	 @Test
	public void testSearch1API() throws NewsAPIException {
		final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
		final List<newsinfo> results= newsSearchService.getPopularNewsForCategory ("gr", "business");
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	} 
	
//This test finds the results for the news in which the word "Apple" is contained
	@Test
	public void testSearch2API() throws NewsAPIException {
		final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
		final List<newsinfo> results= newsSearchService.searchAQueryForNews ("Apple");
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	} 
	
//This test finds the results for the news in which the word "Apple" is contained; in our preferable language en 
//if you want to test another language please replace "en" with one of the options according to the documentation
//the documentation is accessible in https://newsapi.org/docs/endpoints/everything
//Possible options are: ar,de,en,es,fr,he,it,nl,no,pt,ru,se,ud,zh
	@Test
	public void testSearch3API() throws NewsAPIException {
		final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
		final List<newsinfo> results= newsSearchService.searchLanguageForNews ("Apple", "en");
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	} 
	
//This test finds the results for the news in which the word "apple" is contained; in english language 
	// and we choose the news to come from the source bbc-news
//if you want to test another language please replace "en" with one of the options according to the previous test
	@Test
	public void testSearch4API() throws NewsAPIException {
		final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
		final List<newsinfo> results= newsSearchService.searchSourceForNews ("Apple", "en", "bbc-news");
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	} 
	
//This test finds the results for the news in which the word "apple" is contained, in english language;
	//the source we want the news to come from is bbc-news and we set the time of publication
	//specifically we choose the news that have been posted between 14-19/2/2022
//you can change the content of parentheses accordingly to your choices
	@Test
	public void testSearch5API() throws NewsAPIException {
		final NewsAPIService newsSearchService= NewsAPI.getNewsAPIService();
		final List<newsinfo> results= newsSearchService.searchDateofPublicationForNews ("Apple", "en", "bbc-news", "2022-02-14", "2022-02-19");
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);
	} 

 
	
}
