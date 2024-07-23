public class Executive extends Room {
    Executive(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double getPricePerNight() {
        return pricePerNight * 0.35;
    }
}