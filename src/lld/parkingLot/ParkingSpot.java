package lld.parkingLot;


abstract class ParkingSpot {
    int id;
    protected int parkingRate;
    boolean reserved;
    int getParkingRate() {
     return parkingRate;
    }
}


class ThreeWheelerSpot extends ParkingSpot {

    @Override
    int getParkingRate() {
        return 20;
    }
}