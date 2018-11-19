package main;

import builder.GermanHiveBuilder;
import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.RestRoomBuilder;
import builder.Room;
import builder.RoomBuilder;
import builder.RoomDirector;
import builder.SpawnRoomBuilder;

public class TestDesignPatterns {

    public static void main(String[] args) {

        // build a spawning room
        RoomBuilder spawningRoom = new SpawnRoomBuilder();
        RoomDirector spawnRoomDirector = new RoomDirector(spawningRoom);
        spawnRoomDirector.makeRoom();
        
        Room newSpawnRoom = spawnRoomDirector.getRoom();
        
     // build a rest/feed room
        RoomBuilder restingRoom = new RestRoomBuilder();
        RoomDirector restRoomDirector = new RoomDirector(restingRoom);
        restRoomDirector.makeRoom();
        
        Room newRestRoom = restRoomDirector.getRoom();
        
        System.out.println("New Spawning Room: " + newSpawnRoom.getType());
        System.out.println("New Resting Room: " + newRestRoom.getType());


    }

}
