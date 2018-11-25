package builder;


public interface IRoomBuilder {
           
    Room buildRoom();

    IRoomBuilder setType(final RoomType roomType);
    
}
