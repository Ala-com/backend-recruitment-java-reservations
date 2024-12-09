package com.ala.recruitment.reservations;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
class Room {
    @Id
    private UUID id;

    protected Room() {}

    public Room(UUID id) {
        this.id = id;
    }
}
