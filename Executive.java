package MCO2.src;

public class Executive extends Room {
    Executive(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double getPricePerNight() {
        return super.getPricePerNight() * 1.35; // 35% more than the base price
    }
}