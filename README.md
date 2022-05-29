

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
