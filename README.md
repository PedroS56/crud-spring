# Crud with Spring Boot#
This is a basic Restful CRUD API for manage user information using Spring Boot, Mysql in Azure and JPA.

## Requirements

*   Java 21
*   Maven 3.x.x
*   Mysql 8.x.x


## API Endpoints 

The definitions for **Tusuario** Entity:
|**Verb**| **Path**                | **Body**  | **Response**  | 
|:--------|:-------------------------:|:-------------:|:-----------------:|
| `GET`   | /api/v1/tusuarios            | *no requierd* |`jso={<List<Tusuario>}`|
| `GET`   | /api/v1/tusuarios/{nombre}   | *no requierd* |`json={<List<Tusuario>}`|
| `GET`   | /api/v1/tusuario/{id}        | *no requierd* |`json={Tusuario}`|
| `POST`  | /api/v1/tusuarios            | `json = {Tusuario}` |`HttpStatus.CREATED`|
| `PUT`   | /api/v1/tusuario/edit/{id}   | Updated `json = {Tusuario}`|`HttpStatus.OK`|
| `DELETE`| /api/v1/tusuario/delete/{id} | *no requierd* |`HttpStatus.NO_CONTENT`|



The definitions for **Trole** Entity:
|**Verb**| **Path**                | **Body**  | **Response**  | 
|:--------|:-------------------------:|:-------------:|:-----------------:|
| `GET`   | /api/v1/troles            | *no requierd* |`jso={<List<Trole>}`|
| `GET`   | /api/v1/troles/{nombre}   | *no requierd* |`json={<List<Trole>}`|
| `GET`   | /api/v1/trole/{id}        | *no requierd* |`json={Trole}`|
| `POST`  | /api/v1/troles            | `json = {Trole}` |`HttpStatus.CREATED`|
| `PUT`   | /api/v1/trole/edit/{id}   | Updated `json = {Trole}`|`HttpStatus.OK`|
| `DELETE`| /api/v1/trole/delete/{id} | *no requierd* |`HttpStatus.NO_CONTENT`|


**The resource is available [where](https://crud-spring.azurewebsites.net/api/v1/tusuarios).**



## Author
*   [@PedroSB56](https://github.com/PedroS56)

