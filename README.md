# cassandrarest

Simple REST controller for accessing our Cassandra database.

## Installation

1. Run `./script/package` to compile the Clojure and Java, and will build the Docker image.
2. Run `./script/publish` to push the Docker image to Docker Hub.

## Usage

* Run `lein ringer server` to run the app locally, without Docker.
* Run `./script/run` to run the container and stay connected to the log
* Run `./script/start` to run the container in the background

## License

Copyright © 2016 joey@joeygibson.com

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
