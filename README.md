# int4-cpi-challenge
int4 CPI Programming Challenge


# The Challenge

Develop a Groovy script to generate the OData filter criteria from the HTTP query parameters.
Some of the key aspects of the script should be as follows:

- Extract HTTP query parameter from header CamelHTTPQuery, build the OData filter criteria and store it in property filterCrit. Below are some examples:-
  
| Input  HTTP Query Parameters | Output – OData filter criteria |
| ------ | ------ |
| ShipCountry=Sweden | ShipCountry eq ‘Sweden’|
| ShipCity=Stuttgart&ShipCountry=Germany |  ShipCity eq ‘Stuttgart’ and ShipCountry eq ‘Germany’ 

- Handle dynamically the different fields available in the Orders entity set
- Handle different field types, e.g. numbers, String.
- Each parameter can contain only single values, and the parameters cannot be repeated.
- Only equality operator for the OData filter criteria is required.
