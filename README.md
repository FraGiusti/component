# Product
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
