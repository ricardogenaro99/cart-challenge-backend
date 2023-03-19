# Cart Challenge - Backend

Development of a shopping cart for the software engineer test for XcaleConsulting.

## Challenge Description

This project is an e-commerce frontend made with React that connects to a Spring Boot API. The goal of the project is to create an online shopping platform that allows users to search, select, and purchase products.

This challenge was developed under a hexagonal architecture and without a database with a duration of 10 minutes after its last update for each Cart created by the user. The hexagonal architecture provides a clear separation of the business and infrastructure layers, allowing for greater flexibility and ease of maintenance over time.

The project uses a service layer that implements the business use cases and communicates with the input and output adapter layers, which are responsible for handling HTTP requests and persistence operations in memory, respectively. Ingress adapters define HTTP requests into objects that the use cases can process, while egress adapters are responsible for storing the data in memory.
