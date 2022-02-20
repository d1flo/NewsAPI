//This is the class where you can find what our project asks for.
//To be specific, each question of our project about the top-headlines should has the information of the title, 
//description, post date and url location of the top-headline which has been posted as it relates to a specific country of the user's choice

package model;

import model.thenewsdb.Article;

//in order to maintain this data we create variables to keep the state of the objects
public class newsinfo {
     private String title;
     private String description;
     private String post_date;
     private String url_location;

//next we define the constructor
     public newsinfo(String title, String description, String post_date, String url_location) {
		super();
		this.title = title;
		this.description = description;
		this.post_date = post_date;
		this.url_location = url_location;
	}
//we use the public class newsinfo(Article theResult) in order the program  brings us the results of each article displayed on the console
//concerning about the 4 variables we created 
	public newsinfo(Article theResult) {
		this.title = theResult.getTitle();
   	    this.description = theResult.getDescription();
   	    this.post_date = theResult.getPublishedAt();
   	    this.url_location = theResult.getUrl();
	}
//in this step we create getters and setters
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPublishedAt() {
		return post_date;
	}

	public String getUrl() {
		return url_location;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPost_date(String PublishedAt) {
		this.post_date = PublishedAt;
	}

	public void setUrl_location(String Url) {
		this.url_location = Url;
	}
//to print the different messages we make override 	 
	@Override
	public String toString() {
		 return "NewsInfo{" +
	                "title='" + title + "'\n" +
	                ", description='" + description + "'\n" +
	                ", post_date='" + post_date + "'\n" +
	                ", url_location='" + url_location + "'\n" +
	                '}';
	}
     
     
	 
	 
}
