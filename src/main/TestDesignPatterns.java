package main;

import builder.Hive;
import builder.BeeType;
import builder.RoomType;
import singletonDP.Apiary;


public class TestDesignPatterns {

    public static void main(String[] args) {
        
        Hive hive1 = createHive(BeeType.BUCKFAST);
        Hive hive2 = createHive(BeeType.BUCKFAST);
        Hive hive3 = createHive(BeeType.GERMAN);
        Hive hive4 = createHive(BeeType.GERMAN);
        Hive hive5 = createHive(BeeType.RUSSIAN);
        Hive hive6 = createHive(BeeType.CARNIOLAN);
        Hive hive7 = createHive(BeeType.CAUCASIAN);
        Hive hive8 = createHive(BeeType.ITALIAN);
        
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

    private static Hive createHive(BeeType hiveType) {
        // add hives to the apiary
        Hive myHive = Apiary.getInstance().buildHive(hiveType);
        return myHive;       
    }  

}
