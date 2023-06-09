## JsonMate
Store and modify json templates on the go.

The JSONMate application is a RESTful web service that enables users to modify JSON data based on predefined JSON templates. It uses a PostgreSQL database to store the JSON templates and supports CRUD (Create, Read, Update, Delete) operations on them.  

Users can modify the values of JSON nodes in a template by sending a PATCH request to the service with the updated JSON data. The service validates the updated JSON data against the JSON schema of the template and applies the changes if they are valid.  

The application uses Swagger UI to provide an interactive documentation for the REST API, making it easy for users to understand the available endpoints and their functionality.  The application is built using Java, Spring Boot, and Open Api. 

It provides a simple and efficient way to modify JSON data based on predefined templates, which can be useful in a variety of scenarios where JSON data needs to be transformed or manipulated.
