package builder;

public class RoomDirector {

    private RoomBuilder roomBuilder;
    
    public RoomDirector(RoomBuilder roomBuilder) {
        this.roomBuilder = roomBuilder;
    }
    
    public Room getRoom() {
        return this.roomBuilder.getRoom();
    }
    
    public void makeRoom() {
        
        this.roomBuilder.buildRoom();
    }
}
