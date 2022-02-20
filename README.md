The project concerns the development of an application for receiving news headlines from news centers of different countries. The project is divided into two parts NewsAPI & NewsAPP which are about the construction of a library and the construction of an application for downloading data.

Τhe purpose of the first part is to create methods that bring us results according to the country and the category of the user's choice but also results after searching with specific criteria such as a phrase or word in the title or body of the news; the choice of language; the selection of a specific news source or news related to a period of the user's choice.

This repository concerning the first part of the project is about the construction of a library NewsAPI

The user in order to receive the preferable results has firstly to get his apikey from https://newsapi.org/ and https://ip-geolocation.whoisxmlapi.com/. The user has to enter his https://newsapi.org/ apikey in class NewsAPI and his https://ip-geolocation.whoisxmlapi.com/ apikey in class LocationAPI as a second parameter and in class NewsAPITest in the first test for getting news related to his IP address. 

There are some tests  in class NewsAPITest  with data of our choice to receive data based on specific criterias. However, if the user wants to get specific news he can enter the data of his choice following the comments given. 
