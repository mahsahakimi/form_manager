# Form Builder API Documentation

This document describes the REST API for managing forms and their fields.

## Base URL

`http://localhost:8080/forms`

## Endpoints

| Method | Path                  | Description                                                                                         | Request Body                                                                                                                                                                                                                                                                                                                                                              |
| :----- |:----------------------| :--------------------------------------------------------------------------------------------------- |:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `GET`  | `/`             | Retrieves a list of all forms.                                                                      | None                                                                                                                                                                                                                                                                                                                                                                      |
| `POST` | `/`             | Creates a new form.                                                                                   | `Form` object (without `id`). Example:<br>`{"name": "New Form", "published": false}`                                                                                                                                                                                                                                                                                      |
| `GET`  | `/{id}`         | Retrieves a specific form by its ID.                                                                 | None                                                                                                                                                                                                                                                                                                                                                                      |
| `PUT`  | `/{id}`         | Updates an existing form by its ID.                                                                  | `Form` object (without `id`). Example:<br>`{"name": "Updated Form Name", "published": true}`                                                                                                                                                                                                                                                                              |
| `DELETE`| `/{id}`         | Deletes a form by its ID.                                                                           | None                                                                                                                                                                                                                                                                                                                                                                      |
| `GET`  | `/{id}/fields`  | Retrieves fields of a specific form by its ID.                                                       | None                                                                                                                                                                                                                                                                                                                                                                      |
| `PUT`  | `/{id}/fields`  | Updates fields of a specific form by its ID.                                                       | Array of `Field` objects (include `id` for updates, omit for new fields). Example:<br>`[`<br>`{`<br>`"id": 1,`<br>`"name": "Updated Field Name",`<br>`"label": "Updated Label",`<br>`"type": "TEXT",`<br>`"defaultValue": "New Value"`<br>`},`<br> `{`<br>`"name": "New Field",`<br>`"label": "New Label",`<br>`"type": "NUMBER",`<br>`"defaultValue": "0"`<br>`}`<br>`]` |
| `POST` | `/{id}/publish` | Toggles form's publication status.                                                                  | None                                                                                                                                                                                                                                                                                                                                                                      |
| `GET`  | `/published`    | Retrieves all published forms.                                                                      | None                                                                                                                                                                                                                                                                                                                                                                      |

# Usage

**1. Database Setup**

* Install and configure a PostgreSQL database server.
* Update the `application.properties` file (located in `src/main/resources`) with your database connection details (host, port, username, password, etc.).

**2. Run the Application**

* Ensure you have Maven installed.
* Run the application:
    * Open a terminal and navigate to your project's root directory.
    * Run `mvn spring-boot:run`.
* Alternatively, run the main class (`src/main/java/edu/sharif/web/Main.java`) directly in your IDE.
