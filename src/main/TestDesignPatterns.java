package main;

import builder.Hive;
import builder.HiveType;
import builder.RoomType;
import singletonDP.Apiary;


public class TestDesignPatterns {

    public static void main(String[] args) {
        
        Hive hive1 = createHive(HiveType.BUCKFAST);
        Hive hive2 = createHive(HiveType.BUCKFAST);
        Hive hive3 = createHive(HiveType.GERMAN);
        Hive hive4 = createHive(HiveType.GERMAN);
        Hive hive5 = createHive(HiveType.RUSSIAN);
        Hive hive6 = createHive(HiveType.CARNIOLAN);
        Hive hive7 = createHive(HiveType.CAUCASIAN);
        Hive hive8 = createHive(HiveType.ITALIAN);
        
        addBroodRoom(hive1);
        addRestRoom(hive1);
        addBroodRoom(hive1);
        addRestRoom(hive1);
        addBroodRoom(hive2);
        addRestRoom(hive2);
        addBroodRoom(hive2);
        addRestRoom(hive3);
        addBroodRoom(hive3);
        addRestRoom(hive3);  
        addRestRoom(hive4);        
        addRestRoom(hive5);        
        addRestRoom(hive6); 
        addBroodRoom(hive7);        
        addBroodRoom(hive8);    
        addRestRoom(hive8);        

        System.out.println(Apiary.getInstance().toString());

    }

    private static void addBroodRoom(Hive hive) {
        hive.roomBuilder(RoomType.BROOD, hive.getType());        
    }
    
    private static void addRestRoom(Hive hive) {
        hive.roomBuilder(RoomType.REST, hive.getType());        
    }

    private static Hive createHive(HiveType hiveType) {
        // add hives to the apiary
        Hive myHive = Apiary.getInstance().buildHive(hiveType);
        return myHive;       
    }  

}
