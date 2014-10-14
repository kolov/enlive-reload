# enlive-reload

Auto reload for enlive templates. Enlive offers support for autoreload, but is is not usable on a Mac, see [more](http://kolov-it.com/automatic-reloading-enlive-templates/)

## Usage

A ring handler wrapper that check for changed template files, add it nex to wrap-reload

    (ring.middleware.reload/wrap-reload)
    (com.akolov.enlive_reload/wrap-enlive-reload)
This will track all namespaces containing enlive templates. Optionally, specify namespaces to watch:

    (com.akolov.enlive_reload/wrap-enlive-reload 'myproject.templates)

## License


Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


