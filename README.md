
# Booking system



## Installation

Install project with mvn

```bash
mvn clean install
java -jar target/work-0.0.1-SNAPSHOT.jar
```
    
## API Reference

http://localhost:8080/swagger-ui/index.html


## DataBase
http://localhost:8080/console

| Key | value  |
| :-----: | :-: |
| JDBC URL: | jdbc:h2:file:./database22 |
|User Name: | admin |
|Password: | admin |

## Usage/Examples

Create booking 
```curl
curl --location --request POST 'http://localhost:8080/api/booking/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "ownerId": 1,
    "tenantId": 2,
    "objectRentId": 2,
    "start": "27/06/2022",
    "end": "26/08/2022"
}'

```

Obtain all booking
```curl
curl --location --request GET 'http://localhost:8080/api/booking/all' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 2,
    "title": "lol",
    "body": "lol"
}'

```

Obtain all Rent Objects
```curl
curl --location --request GET 'http://localhost:8080/api/objectRent/obtainAll'

```

Obtain all booking by Rent object, for 4 not exist for 1 exist
```curl
curl --location --request GET 'http://localhost:8080/api/booking//all/rent/4'

```

Obtain all booking by Renter name, for Robert exist for Roberto not exist
```curl
curl --location --request GET 'http://localhost:8080/api/booking/all/renter?name=Robert'

```


