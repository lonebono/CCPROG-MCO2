public class Deluxe extends Room {
    Deluxe(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double getPricePerNight() {
        return pricePerNight * 0.2;
    }
}