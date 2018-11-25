package main.java.apiary.builder;

public class BroodRoomBuilderImpl implements IRoomBuilder {

    private Room room;

    public BroodRoomBuilderImpl() {
        this.room = new Room();
    }

    @Override public Room buildRoom() {
        room.setType(RoomType.BROOD);
        return room;
    }

    @Override public IRoomBuilder setType(final RoomType roomType) {
        room.setType(roomType);
        return this;
    }

   
}
