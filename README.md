## Service orders API - Spring Boot.

API for managing service orders, customers and technicians.

### Technology stack:

* Maven;
* Tomcat embedded;
* Spring Boot;
* Spring Web;
* Spring Data JPA;
* Hibernate (as JPA implementation);
* PostegreSQL


### API endpoint:

Client and technician model:


`
{
    "id":
    "cpf": 
    "name": 
    "phone": 
}
`

Service order model:


`{
        "id": ,
        "startDate": Date,
        "finishDate": Date,
        "priority": code,
        "observation":,
        "status": code,
        "technician": id,
        "client": id
    }`



Go to `https://api-orderservices.herokuapp.com` and test.

* POST request to `/orders/`, `/clients/`, `/technicians/`  with a "object" object as JSON creates a new "object";
* GET request to `/orders/`, `/clients/`, `/technicians/`  returns a list of "objects";
* GET request to `/orders/1`, `/clients/1`, `/technicians/1`  returns the "object" with ID 1;
* PUT request to `/orders/1`, `/clients/1`, `/technicians/1` with a "object" object as JSON updates the "object" with ID 1;
* DELETE request to `/clients/1`, `/technicians/1` deletes the "object" with ID 1;

