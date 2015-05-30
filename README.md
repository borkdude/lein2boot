# Animals CRUD

## Running the project

In a terminal, start the web server:

    lein repl
    (start-server)

In another terminal, start figwheel:

    lein clean && lein figwheel dev

Finally browse to
[http://localhost:8080/index.html](http://localhost:8080/index.html)
and have fun.

## Building for production

    lein clean && lein cljsbuild once prod

## License

Copyright Michiel Borkent

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
