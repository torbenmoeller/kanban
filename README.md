# Kanban Service

The Kanban Service provides a RESTful API for a user to store tasks and their states.

# API documentation

## Users
* GET /users - Reads data of the current logged-in user
* POST /users - Registers a new user

## Transfers
* GET /tasks - Reads data of all tasks
* GET /tasks/{uuid} - Reads data of one task
* POST /tasks - Creates a new task
* PUT /tasks/{uuid} - Updates an existing task

## Security
The POST method for '/users' is publicly available. It allows users to register.
All other methods are only callable, if the user is logged in via HTTP basic.

# Quickstart
The main method of KanbanApplication starts the application.
It binds to port 8080. On start an H2 database is created in the data folder.

# Acceptance tests
A Postman collection and an environment for localhost can be imported from acceptance_test folder.
