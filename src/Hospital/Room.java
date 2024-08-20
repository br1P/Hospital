package Hospital;

public class Room {
    private int roomNumber;
    private String roomType; //single or shared maybe this can be a boolean?

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room:\n" +
                "room number:" + roomNumber +
                ", room type:'" + roomType + '\'' ;
    }
}
