# lein2boot

This is a sample project that demonstrates how to achieve the same development and build process in leiningen and boot. The project supports code reloading on the server and on the client.

The project has a client side part written in ClojureScript and Reagent.
The server side part is a Ring handler served by Jetty. 

## Leiningen

### Developing

In a terminal, start the web server:

    lein repl
    (start-server)

In another terminal, start figwheel:

    lein clean && lein figwheel dev

Browse to
[http://localhost:8080/index.html](http://localhost:8080/index.html).

### Building production ClojureScript

    lein clean && lein cljsbuild once prod

### Package as uberjar

    lein clean
    lein cljsbuild once prod
    lein uberjar

or just

    lein build

Run with `java -jar target/animals-1.0.0-standalone.jar [<port>]`

## Boot

### Developing

In a terminal:

    boot dev

Browse to
[http://localhost:3000/index.html](http://localhost:3000/index.html).

### Building production ClojureScript

    boot build-cljs

### Package as uberjar

    boot build

Run with `java -jar target/animals-1.0.0.jar [<port>]`

## License

Copyright Michiel Borkent

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
