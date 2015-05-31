# Animals CRUD

## Leiningen

### Running 

In a terminal, start the web server:

    lein repl
    (start-server)

In another terminal, start figwheel:

    lein clean && lein figwheel dev

Finally browse to
[http://localhost:8080/index.html](http://localhost:8080/index.html)
and have fun.


### Building production ClojureScript

    lein clean && lein cljsbuild once prod

### Package as uberjar

    lein clean
    lein cljsbuild once prod
    lein uberjar

Run with `java -jar <uberjar>.jar [<port>]`

## Boot

### Running

In a terminal:

    boot dev

Browse to http://localhost:3000

### Building production ClojureScript

TODO

### Package as uberjar

TODO

## License

Copyright Michiel Borkent

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
