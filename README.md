# Task

The project contains core functionality of a room reservation system, which allows its users making reservations for a specific room in a specific time slot. The system should be able to handle multiple rooms and multiple time slots. 
The system seems to work in most cases, which is proven by a couple of integration tests. 

However, the client reports a major issue. They say that sometimes two different customers are able to make two conflicting reservations for the same room in  overlapping time slots.
This makes our product seem unreliable to the customers.

Your task is to:
1. Take a moment to familiarize yourself with the project structure and the existing tests and production code.
2. Write a failing integration test that proves the existence of the issue.
3. Fix the issue by modifying the production code. After that your new test and all the existing tests should pass.

