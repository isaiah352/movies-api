movies-api

This project serves to provide a REST API for managing movies within a H2 in
memory database. Movies can be created, updated, deleted, and fetched

Swagger has been configured for this project for ease of use with the available
endpoints. Swagger provides a robust UI for working with endpoints. To use swagger, 
go to your browser while the application is running locally, and
enter the URL localhost:8080/swagger-ui.html

Swagger input example:

{
  "genre": "Drama/Action",
  "name": "Braveheart",
  "rating": "R",
  "year": "1995"
}

The H2 console has been enabled for this project for accessing and modifying data during runtime.
To access the H2 web console while the application is running locally, open your browser and 
go to localhost:8080/h2-console
