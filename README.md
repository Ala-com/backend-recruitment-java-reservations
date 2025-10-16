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

Add a new feature that allows users to extend the end date of their existing reservation.

Functional requirements:
1. A user should be able to extend only those reservations that they own.
2. It should not be possible to extend past or ongoing reservations.
3. Extension can only move the end date forward (new end date must be after current end date).
4. The room must be available for the extended period. The system should check if the room is free during the extension window, but the current reservation itself should not be considered a collision.
5. If the room is not available for the entire extension period, the operation should fail and the original reservation should remain unchanged.

Non-functional requirements:
1. When making changes, make sure to follow the current project architecture and style.
2. New features should be covered with tests, and the existing functionality should not be changed.

Hints:
- Think carefully about how collision detection works and how to handle checking availability against the reservation's own time slot.
- The operation should be atomic - either the reservation is extended successfully or it remains unchanged.
