# enlive-reload



Auto reload for enlive templates.

## Usage

In your ring handler, next to 

    (ring.middleware.reload/wrap-reload)
add

    (com.akolov.enlive_reload/wrap-enlive-reload)
This will track all namespaces containing enlive templates. 
Optionally, specify namespaces to watch:
    (com.akolov.enlive_reload/wrap-enlive-reload 'myproject.templates)

## License


Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


