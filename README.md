# smart-sql-be

## Configuration
You must have Docker installed and a working Postgres database.
Edit /etc/sudoers file and add the locations of etc/docker_*.sh scripts
there (so that they could be run without specifying password)
```
myusername ALL=(ALL) NOPASSWD: /path/to/docker_startup.sh
myusername ALL=(ALL) NOPASSWD: /path/to/docker_sql.sh
myusername ALL=(ALL) NOPASSWD: /path/to/docker_remove.sh
```
Add application.properties to resources/ (see sample.application.properties). 

To start: 
```
./gradlew bootrun
```

## Database propagation
Changesets must be included as SQL files in src/main/resources/db/changes folder.
