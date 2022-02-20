//this class makes call to our ip adress in order the program to have access and brings us the right results
//concerning the top-headlines news of the country the user is 
//the first part of parenthesis relates to a part of a site's adress we used in order the program finds automatically our IP adress
//you can replace my ip adress in line 10; in the second part of parenthesis; to run your results
//my ip adress found in my pc's network status --> finding my ip adress

import services.LocationAPIService;
public class LocationAPI {
   public static LocationAPIService getLocationAPIService() {
	return new LocationAPIService("https://ip-geolocation.whoisxmlapi.com/","myIP");
   }
}
