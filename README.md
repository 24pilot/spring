The 'games' GamesApplication  is a runnable from the IDE SpringBoot application.

 1. The application every 5 seconds reads a JSON object with Bitcoin course data from a resource:
"https://api.coindesk.com/v1/bpi/currentprice.json?t=123454"

2. Adds a field "ID". Changes the "chartName" field by adding the "GameSys version". The GBP rate divides by 10. The modified data is recorded in the in-memory H2 database.

3. When accessing the browser "http: // localhost: 8080 /", it displays JSON with the last 10 entries from the database.

Components:

@SpringBootApplication
GamesApplication  - main runnable component

scheduller.
ScheduledTasks  - reading data and saving in DB

.connection.
HttpConnection  - Http Connection

.model.
StatisticModel  -  entity class

.service.
StatisticService  -  @Service - Business Service Facade

.repository
StatisticModelRepository  - @Repository  encapsulating storage, and search  from the database

.controller
HomeController  -  @Controller - Controller in MVC pattern, listening Http request, returning response
