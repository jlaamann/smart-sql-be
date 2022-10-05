# smart-sql-be

## Configuration
You must have Docker installed and a working Postgres database.

Rename sample.application.properties to application.properties and add Postgres db name, username and password.

Give executable rights to etc/*.sh files.

### Run Docker without sudo

```
sudo usermod -aG docker ${USER}
```

Add application.properties to resources/ (see sample.application.properties). 

## Start application
```
./gradlew bootrun
```

## Database propagation
Changesets must be included as SQL files in src/main/resources/db/changes folder.
