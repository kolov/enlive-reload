# enlive-reload

Auto reload for enlive templates. Enlive offers support for autoreload, but is is not usable on a Mac, see [more](http://kolov-it.com/automatic-reloading-enlive-templates/)

## Usage

Add this to your dependencies:

    [com.akolov.enlive-reload "0.1.0"]
    
Add the handler wrapper that checks for changed template files next to wrap-reload:

    (ring.middleware.reload/wrap-reload)
    (wrap-enlive-reload)
This will track all namespaces containing enlive templates. Optionally, specify namespaces to watch:

    (wrap-enlive-reload 'myproject.templates)

## License


Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


