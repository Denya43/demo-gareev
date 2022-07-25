@ REM Runs locally a new container.

docker run -p 8080:8080 --name gar -it gar:1-SNAPSHOT

docker container rm gar