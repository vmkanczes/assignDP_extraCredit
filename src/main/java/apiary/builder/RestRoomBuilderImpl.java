package main.java.apiary.builder;

public class RestRoomBuilderImpl implements IRoomBuilder {

    private Room room;

    public RestRoomBuilderImpl() {
        this.room = new Room();
    }

    @Override
    public Room buildRoom() {
        room.setType(RoomType.REST);
        return room;
    }

    @Override
    public IRoomBuilder setType(final RoomType roomType) {
        room.setType(roomType);
        return this;
    }

   
}
