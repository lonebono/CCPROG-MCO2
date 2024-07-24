package MCO2.src;

public class Deluxe extends Room {
    Deluxe(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double getPricePerNight() {
        return super.getPricePerNight() * 1.20; // 20% more than the base price
    }
}