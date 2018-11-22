package builder;

public class BroodRoomBuilder implements RoomBuilder {

    private Room room;

    public BroodRoomBuilder() {
        this.room = new Room();
    }

    @Override
    public Room getRoom() {
        return this.room;
    }

    @Override
    public void buildRoom() {
        room.setType(RoomType.BROOD);
    }




   
}
