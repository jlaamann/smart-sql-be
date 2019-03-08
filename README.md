# smart-sql-be

## Configuration
You must have Docker installed and a working Postgres database.
Add application.properties to resources/ (see sample.application.properties). 

To start: 
```
./gradlew bootrun
```

## Database propagation
Changesets must be included as SQL files in src/main/resources/db/changes folder.
