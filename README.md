# smart-sql-be

## Configuration
You must have Docker installed and a working Postgres database.
### Run Docker without sudo

```
sudo usermod -aG docker ${USER}
```

### Run Docker without sudo (alternative #1)
Edit /etc/sudoers file and allow user to run all commands without sudo
```
myusername ALL=(ALL) NOPASSWD: ALL
```
Add application.properties to resources/ (see sample.application.properties). 

## Start application
```
./gradlew bootrun
```

## Database propagation
Changesets must be included as SQL files in src/main/resources/db/changes folder.
