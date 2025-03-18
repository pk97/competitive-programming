package lld.parkingLot;

class TwoWheelerSpot extends ParkingSpot {

    TwoWheelerSpot() {
        this.parkingRate = 10;
    }

    @Override
    int getParkingRate() {
        return 10;
    }
}
