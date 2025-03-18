package lld.parkingLot;


import java.time.Instant;
import java.util.Date;

class Ticket {
    ParkingSpot parkingSpot;
    int ticketId;
    Date date;
    Instant entryTime;

    void cost() {
        parkingSpot.parkingRate =23;
    }
}
