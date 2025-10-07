# Task 0 
The project contains core functionality of a room reservation system, which allows its users making reservations for a specific room in a specific time slot. The system should be able to handle multiple rooms and multiple time slots.

1. Take a moment to familiarize yourself with the project structure and the existing tests and production code.

# Task 1

The system seems to work in most cases, which is proven by a couple of integration tests. 
However, the client reports a major issue. They say that sometimes two different customers are able to make two conflicting reservations for the same room in  overlapping time slots.
This makes our product seem unreliable to the customers.

Your task is to:
1. Write a failing integration test that proves the existence of the issue.
2. Fix the issue by modifying the production code. After that your new test and all the existing tests should pass.

# Task 2

Add a new feature to the system that allows a user to cancel an existing reservation.

Functional requirements:
1. A user should be able to cancel only those reservations that they own.
2. It should not be possible to cancel past or ongoing reservations.
3. Reservation can be canceled only if its cancellation policy allows it. For now, we will have just one cancellation policy that allows cancellation no later than 24 hours before the reservation starts (a reservation starts at 2:00pm on its start date). In the future, we will have more cancellation policies.
4. When a reservation is canceled, the room can be booked by other users or even by the same user again.
5. The system should remember canceled reservations, we don't want to lose data.

Non-functional requirements:
1. When making changes, make sure to follow the current project architecture and style.
2. New features should be covered with tests, and the existing functionality should not be changed. 

