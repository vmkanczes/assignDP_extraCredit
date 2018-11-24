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
        Apiary.getInstance().getHives();
        System.out.println("Room Count: " + Apiary.getInstance().getRoomCount());

        
        // get hive objects
        //System.out.println(buckfastHive1.toString());
        //System.out.println(germanHive1.toString());
        //System.out.println(germanHive2.toString());
        
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
        
        Apiary.getInstance().getHiveRooms();

        System.out.println("Room Count: " + Apiary.getInstance().getRoomCount());


    }  

}
