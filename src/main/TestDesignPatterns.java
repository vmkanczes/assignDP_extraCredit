package main;

import builder.BroodRoomBuilder;
import builder.RestRoomBuilder;
import builder.Room;
import builder.RoomBuilder;
import builder.RoomDirector;

public class TestDesignPatterns {

    public static void main(String[] args) {

        // build a spawning room
        RoomBuilder broodRoom = new BroodRoomBuilder();
        RoomDirector broodRoomDirector = new RoomDirector(broodRoom);
        broodRoomDirector.makeRoom();
        
        Room newBroodRoom = broodRoomDirector.getRoom();
        
     // build a rest/feed room
        RoomBuilder restRoom = new RestRoomBuilder();
        RoomDirector restRoomDirector = new RoomDirector(restRoom);
        restRoomDirector.makeRoom();
        
        Room newRestRoom = restRoomDirector.getRoom();
        
        System.out.println("New Brood Room: " + newBroodRoom.getType());
        System.out.println("New Rest Room: " + newRestRoom.getType());


    }

}
