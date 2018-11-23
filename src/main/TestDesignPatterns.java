package main;

import builder.Hive;
import builder.HiveType;
import builder.RoomType;
import singletonDP.Apiary;


public class TestDesignPatterns {

    public static void main(String[] args) {
        
        // add hives to the apiary
        Hive buckfastHive1 = Apiary.getInstance().buildHive(HiveType.BUCKFAST);
        Hive germanHive1 = Apiary.getInstance().buildHive(HiveType.GERMAN);
        Hive germanHive2 = Apiary.getInstance().buildHive(HiveType.GERMAN);

        
        // get total count of hives
        Apiary.getInstance().getTotalHiveCount();
        
        // get total hives per type
        Apiary.getInstance().getHiveCount(HiveType.BUCKFAST);
        Apiary.getInstance().getHiveCount(HiveType.GERMAN);

        // add rooms to a specific hive
        buckfastHive1.roomBuilder(RoomType.BROOD, buckfastHive1.getType());
        buckfastHive1.roomBuilder(RoomType.REST, buckfastHive1.getType());
        buckfastHive1.roomBuilder(RoomType.BROOD, buckfastHive1.getType());
        buckfastHive1.roomBuilder(RoomType.REST, buckfastHive1.getType());

        
        germanHive1.roomBuilder(RoomType.REST, germanHive1.getType());
        germanHive1.roomBuilder(RoomType.REST, germanHive1.getType());
        germanHive1.roomBuilder(RoomType.REST, germanHive1.getType());
        germanHive1.roomBuilder(RoomType.BROOD, germanHive1.getType());
        germanHive1.roomBuilder(RoomType.BROOD, germanHive1.getType());

        
        germanHive2.roomBuilder(RoomType.BROOD, germanHive2.getType());
        germanHive2.roomBuilder(RoomType.REST, germanHive2.getType());
        germanHive2.roomBuilder(RoomType.BROOD, germanHive2.getType());

        // get rooms for a specific hive
        germanHive1.getRooms();
        
        System.out.println(buckfastHive1.toString());
        System.out.println(germanHive1.toString());
        System.out.println(germanHive2.toString());

        
        // get room count for each hive
        System.out.println("Room Totals: " + buckfastHive1.getRoomTotals());
        
    }  

}
