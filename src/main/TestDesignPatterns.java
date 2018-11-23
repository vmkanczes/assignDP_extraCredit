package main;

import builder.BroodRoomBuilderImpl;
import builder.Hive;
import builder.HiveType;
import builder.IRoomBuilder;
import builder.RestRoomBuilderImpl;
import builder.RoomBuildDirector;
import builder.RoomType;
import singletonDP.Apiary;


public class TestDesignPatterns {

    public static void main(String[] args) {
        
        Hive buckfastHive1 = Apiary.getInstance().buildHive(HiveType.BUCKFAST);
        Hive buckfastHive2 = Apiary.getInstance().buildHive(HiveType.BUCKFAST);

        Apiary.getInstance().getHiveCount(HiveType.BUCKFAST);
        
        Apiary.getInstance().buildHive(HiveType.GERMAN);
        Apiary.getInstance().getHiveCount(HiveType.GERMAN);
        Apiary.getInstance().getHives();

        buckfastHive1.roomBuilder(RoomType.BROOD);
        buckfastHive1.roomBuilder(RoomType.REST);
        
        buckfastHive2.roomBuilder(RoomType.BROOD);
        buckfastHive2.roomBuilder(RoomType.REST);
                

        // Build a brood room
        /*final IRoomBuilder broodBuilder = new BroodRoomBuilderImpl();
        final RoomBuildDirector BroodBuildDirector = new RoomBuildDirector(broodBuilder);
        System.out.println(BroodBuildDirector.construct());
        
        // Build a rest room
        final IRoomBuilder restBuilder = new RestRoomBuilderImpl();
        final RoomBuildDirector RestBuildDirector = new RoomBuildDirector(restBuilder);
        System.out.println(RestBuildDirector.construct());
        */
    }
    
    

}
