package com.ala.recruitment.reservations;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Component
class RoomReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public RoomReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    @Transactional
    public void makeReservation(MakeReservationCommand command) throws RoomNotAvailableException {
        Room room = roomRepository.getReferenceById(command.roomId);
        Boolean collisionsExist = reservationRepository.collisionsExist(command.fromInclusive, command.untilExclusive, command.roomId);
        if (collisionsExist) {
            throw new RoomNotAvailableException();
        }
        reservationRepository.save(new Reservation(
                UUID.randomUUID(),
                room,
                command
        ));
    }

    public boolean isReserved(ReservationQuery reservationQuery) {
        return reservationRepository.isReserved(reservationQuery.roomId, reservationQuery.at, reservationQuery.customerId);
    }

    public Integer reservationsCount(Collection<UUID> userIds) {
        return reservationRepository.countByCustomerIdIn(userIds);
    }

    public Integer reservationsCount(UUID userId) {
        return reservationsCount(Set.of(userId));
    }
}

class RoomNotAvailableException extends RuntimeException {
}

class MakeReservationCommand {
    UUID roomId;
    UUID customerId;
    LocalDate fromInclusive;
    LocalDate untilExclusive;

    public MakeReservationCommand(UUID roomId, UUID customerId, LocalDate fromInclusive, LocalDate untilExclusive) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.fromInclusive = fromInclusive;
        this.untilExclusive = untilExclusive;
    }
}

class ReservationQuery {
    UUID roomId;
    UUID customerId;
    LocalDate at;

    public ReservationQuery(UUID roomId, UUID customerId, LocalDate at) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.at = at;
    }
}
