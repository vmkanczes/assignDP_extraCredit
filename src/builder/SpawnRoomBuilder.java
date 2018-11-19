package builder;

public class SpawnRoomBuilder implements RoomBuilder {

    private Room room;    
    
    public SpawnRoomBuilder() {
        this.room = new Room();
    }

    @Override
    public void buildRoom() {
        room.setType("Spawn");
    }

    @Override
    public Room getRoom() {
        return this.room;
    }




   
}
