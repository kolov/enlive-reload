# enlive-reload

Auto reload for enlive templates. Enlive offers support for autoreload, but is is not usable on a Mac, see [more](http://kolov-it.com/automatic-reloading-enlive-templates/)

## Usage

Add this to your dependencies:

    [com.akolov.enlive-reload "0.2.1"]
    
Add the handler wrapper that checks for changed template files next to wrap-reload:

    (ring.middleware.reload/wrap-reload)
    (wrap-enlive-reload/wrap-enlive-reload)
This will track all namespaces containing enlive templates. Optionally, specify namespaces to watch:

    (wrap-enlive-reload 'myproject.templates)
    
So far, this will ensure that on the next request the enlive template will be relaoded. You may prefer to go one step furhter en let the browser reload when a change is detected using [mirador](https://github.com/kolov/mirador)

## License


Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


