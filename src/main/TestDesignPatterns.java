package main;

import builder.BroodRoomBuilderImpl;
import builder.IRoomBuilder;
import builder.RestRoomBuilderImpl;
import builder.RoomBuildDirector;

public class TestDesignPatterns {

    public static void main(String[] args) {

        // build hive
        /*RoomBuilder broodRoom = new BroodRoomBuilder();
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
*/
        // Build a brood room
        final IRoomBuilder broodBuilder = new BroodRoomBuilderImpl();
        final RoomBuildDirector BroodBuildDirector = new RoomBuildDirector(broodBuilder);
        System.out.println(BroodBuildDirector.construct());
        
        // Build a rest room
        final IRoomBuilder restBuilder = new RestRoomBuilderImpl();
        final RoomBuildDirector RestBuildDirector = new RoomBuildDirector(restBuilder);
        System.out.println(RestBuildDirector.construct());
    }

}
