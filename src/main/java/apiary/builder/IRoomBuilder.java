package main.java.apiary.builder;


public interface IRoomBuilder {
           
    Room buildRoom();

    IRoomBuilder setType(final RoomType roomType);
    
}
