package main;

import builder.BroodRoomBuilderImpl;
import builder.GermanHiveBuilder;
import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.IRoomBuilder;
import builder.RestRoomBuilderImpl;
import builder.RoomBuildDirector;

public class TestDesignPatterns {

    public static void main(String[] args) {

        HiveBuilder germanHive = new GermanHiveBuilder();
        HiveDirector hiveDirector = new HiveDirector(germanHive);
        hiveDirector.makeHive();

        Hive newHive = hiveDirector.getHive();
        System.out.println(newHive.getType());
       
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
