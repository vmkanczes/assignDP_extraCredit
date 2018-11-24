package builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hive {

    private HiveType type;

    // inner map of rooms for the hives
    HashMap<RoomType, ArrayList<Room>> roomMap = new HashMap<RoomType, ArrayList<Room>>();
    
    // nested map of hives and their associated rooms
    Map<HiveType, Map<RoomType, ArrayList<Room>>> outerMap = new HashMap<HiveType, Map<RoomType, ArrayList<Room>>>();
            
    public Room roomBuilder(RoomType roomType, HiveType hiveType) {
        
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
        System.out.println("\n\nRoom HashMap.");        
 
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("Room: " + roomMap.get(iterator.next()));
        }
    }
    
    /**
     * Method: getHives
     * Inputs: none
     * Outputs: none
     * 
     * Description: prints out each hive and its associated rooms.
     */
    public void getHives() {

        // get all hives and their associated rooms
        for (Entry<HiveType, Map<RoomType, ArrayList<Room>>> vals : outerMap.entrySet()) {
            System.out.println("\n\nOutermap key: " + vals.getKey());
            Map<RoomType, ArrayList<Room>> nested_vals = vals.getValue();
            System.out.println("Map fetched as object: " + nested_vals.toString());
            /*
             for (Entry<RoomType, ArrayList<Room>> nested_entries : nested_vals.entrySet()) {
               System.out.println("\n" + "Nested key is: " +
                       nested_entries.getKey());
               System.out.println("Set as object: " +
                       nested_entries.getValue().toString());
               for (Room values : nested_entries.getValue()) {
                   System.out.println("Nested values are: " + values);
               }
            } 
            */                                             
        }
    }
    

    public void setType(HiveType hiveType) {
        this.type = hiveType;
    }
    
    @Override
    public String toString() {
        
        return "Hive: " + getType(); 
    }

    public int getRoomCount() {
        int roomCount=0;
     // let us get all of the hives       
        Iterator<ArrayList<Room>> iterator = roomMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Room> myRooms = iterator.next();
            roomCount += myRooms.size();
        }
        return roomCount;
    }
    
}