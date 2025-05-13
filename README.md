# URL Shortener

This is a simple Url Shortener API that I made using Java with Spring to practice Clean Architecture.

To test it, just clone the repo and start the application.
It will run in localhost:8080/api/v1

This API contains 3 methods:  
**POST /shorten** with a url string in the body payload, it returns a shortened a url with 7 digits  
**GET /{alias}** checks if the alias exists and returns a redirect header to the original long Url  
**GET /stats/{alias}** returns alias stats like access count, original url and creation date  

## Requirements:  
You must have a postgresql database running with the name "urlshortener" in the 5432 port  
You can check the application.properties file if you need to change database name, url, port, username or password.  
