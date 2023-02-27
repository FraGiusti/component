# Product
##### Summary:
The /product/create endpoint allows users to create a new product by sending a POST request. If the request is successful, the server will respond with a 201 status code, indicating that the product has been created.

The /product/update endpoint allows users to update an existing product by sending a PUT request with the id of the product in the query parameters. If the product exists, the server will respond with a 200 status code, indicating that the product has been updated. If the product does not exist, the server will respond with a 404 status code.

The /product/getByFilter endpoint allows users to retrieve all products or filter products by their id by sending a GET request with the id query parameter. If the request is successful, the server will respond with a 200 status code, indicating that the product or products have been retrieved.

Overall, the aim of this application is to provide functionality for managing products, including creating, updating, and retrieving products.

## Version: 1.0.0

### /product/create

#### POST
##### Summary:

Create a new product

##### Responses

| Code | Description |
| ---- | ----------- |
| 201 | Created |

### /product/update

#### PUT
##### Summary:

Update a product by ID

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | query | ID of the product to update | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 404 | Not found |

### /product/getByFilter

#### GET
##### Summary:

List all products or filter by ID

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | query | ID of the product to filter by | No | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
