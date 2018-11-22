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
        
        Room broodRoom1 = broodRoomDirector.getRoom();
        Room broodRoom2 = broodRoomDirector.getRoom();
        
     // build a rest/feed room
        RoomBuilder restRoom = new RestRoomBuilder();
        RoomDirector restRoomDirector = new RoomDirector(restRoom);
        restRoomDirector.makeRoom();
        
        Room restRoom1 = restRoomDirector.getRoom();
        Room restRoom2 = restRoomDirector.getRoom();

        
        System.out.println("New Brood Room: " + broodRoom1.getType());
        System.out.println("New Brood Room: " + broodRoom2.getType());
        System.out.println("New Rest Room: " + restRoom1.getType());
        System.out.println("New Rest Room: " + restRoom2.getType());



    }

}
