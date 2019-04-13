# smart-sql-be

## Configuration
You must have Docker installed and a working Postgres database.
Edit /etc/sudoers file and allow user to run all commands without sudo
```
myusername ALL=(ALL) NOPASSWD: ALL
```
Add application.properties to resources/ (see sample.application.properties). 

To start: 
```
./gradlew bootrun
```

## Database propagation
Changesets must be included as SQL files in src/main/resources/db/changes folder.
