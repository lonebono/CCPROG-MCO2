package MCO2.src;

public class Standard extends Room {
	private String roomType = “STANDARD”;

    Standard(int roomNumber) {
        super(roomNumber);
    }

	public String getRoomType() {
		return roomType;
	}
}
