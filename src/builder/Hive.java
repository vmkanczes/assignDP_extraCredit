package builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Hive {

    private HiveType type;

    private ArrayList <Room> roomList;
    // inner map of rooms for the hives
    HashMap<RoomType, ArrayList<Room>> roomMap = new HashMap<RoomType, ArrayList<Room>>();
    
    // nested map of hives and their associated rooms
    Map<HiveType, Map<RoomType, ArrayList<Room>>> outerMap = new HashMap<HiveType, Map<RoomType, ArrayList<Room>>>();
            
    public Room roomBuilder(RoomType roomType, HiveType hiveType) {
        
        //System.out.println("Building a new room of type: " + roomType + " for hive: " + hiveType);

        IRoomBuilder myRoomBuilder = null;
        switch (roomType) {
        case REST:
            myRoomBuilder = new RestRoomBuilderImpl();
            break;
        case BROOD:
            myRoomBuilder = new BroodRoomBuilderImpl();
            break;
        default:
            System.out.println("Room type does not exist.");
            return null;
        }

        final RoomBuildDirector roomBuildDirector = new RoomBuildDirector(myRoomBuilder);
        Room newRoom = roomBuildDirector.construct();
        
     // check if room` type already exists
        ArrayList<Room> myRoomList = roomMap.get(roomType);
        if (myRoomList == null) {
            // create array list
            myRoomList = new ArrayList<Room>();
            roomMap.put(roomType, myRoomList);
        }
        myRoomList.add(newRoom);
        
        outerMap.put(hiveType, roomMap);

        return newRoom;
        
    }

    public HiveType getType() {
        return type;
    }
    
    public void getRooms() {
        // let us get all of the mapped objects
        Set<Map.Entry<RoomType, ArrayList<Room>>> entries = roomMap.entrySet();
        
        for (Map.Entry<RoomType, ArrayList<Room>> roomType : entries) {
            System.out.println("Key: " + roomType.getKey());
            System.out.println("Value: " + roomType.getValue());
        }
        
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("Room: " + roomMap.get(iterator.next()));
        }
    }
    
    public void getHives() {
        for (Entry<HiveType, Map<RoomType, ArrayList<Room>>> vals : outerMap.entrySet()) {
            System.out.println("\n\nOutermap key: " + vals.getKey());
            Map<RoomType, ArrayList<Room>> nested_vals = vals.getValue();
            System.out.println("Map fetched as object: " + nested_vals.toString());
            for (Entry<RoomType, ArrayList<Room>> nested_entries : nested_vals.entrySet()) {
               System.out.println("\n" + "Nested key is: " +
                       nested_entries.getKey());
               System.out.println("Set as object: " +
                       nested_entries.getValue().toString());
               for (Room values : nested_entries.getValue()) {
                   System.out.println("Nested values are: " + values);
               }
            }
               
                       
                       
        }
    }
    

    public void setType(HiveType hiveType) {
        this.type = hiveType;
    }
    
    @Override
    public String toString() {
        
        return "Hive: " + getType(); 
    }
    
}