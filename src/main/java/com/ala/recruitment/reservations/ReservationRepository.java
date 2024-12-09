package com.ala.recruitment.reservations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

import static com.ala.recruitment.reservations.Reservation.COLLISIONS_EXIST_QUERY;
import static com.ala.recruitment.reservations.Reservation.IS_RESERVED_QUERY;

interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    @Query(name = COLLISIONS_EXIST_QUERY)
    Boolean collisionsExist(LocalDate start, LocalDate end, UUID roomId);

    Integer countByCustomerIdIn(Collection<UUID> roomId);

    @Query(name = IS_RESERVED_QUERY)
    Boolean isReserved(UUID roomId, LocalDate at, UUID customerId);
}
