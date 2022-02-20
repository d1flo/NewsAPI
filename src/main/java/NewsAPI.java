//in main we created a new class called NewsAPI to use NewsAPIService and bring results
//This class is used to initialize NewsAPIService
//in parenthesis you can find the first part of our uri without any parameter;the same uri we used to proceed the test in
//postman program and in the second part of parenthesis you will find my apikey in postman program 
//here you can enter also yours apikey to run your results

import services.NewsAPIService;

public class NewsAPI {
     public static NewsAPIService getNewsAPIService() {
    	 return new NewsAPIService ("https://newsapi.org/v2/", "apikey"); 
     }
}
