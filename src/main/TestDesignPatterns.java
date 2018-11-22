package main;

import builder.BroodRoomBuilderImpl;
import builder.HiveType;
import builder.IRoomBuilder;
import builder.RestRoomBuilderImpl;
import builder.RoomBuildDirector;
import singletonDP.Apiary;


public class TestDesignPatterns {

    public static void main(String[] args) {
        
        Apiary.getInstance().buildHive(HiveType.BUCKFAST);
        Apiary.getInstance().getHiveCount(HiveType.BUCKFAST);
        Apiary.getInstance().getHives();
        
        Apiary.getInstance().buildHive(HiveType.GERMAN);
        Apiary.getInstance().getHiveCount(HiveType.GERMAN);
        Apiary.getInstance().getHives();

                
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
