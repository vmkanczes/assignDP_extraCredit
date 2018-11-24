package builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Hive {

    private HiveType type;

    // inner map of rooms for the hives
    HashMap<RoomType, ArrayList<Room>> roomMap = new HashMap<RoomType, ArrayList<Room>>();
    
    // nested map of hives and their associated rooms
    // Map<HiveType, Map<RoomType, ArrayList<Room>>> outerMap = new HashMap<HiveType, Map<RoomType, ArrayList<Room>>>();
            
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
        
        //outerMap.put(hiveType, roomMap);

        return newRoom;
        
    }

    public HiveType getType() {
        return type;
    }
    
    public String getRooms() {
        // let us get all of the mapped objects 
        String sAllRooms = "";
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        while (iterator.hasNext()) {
            sAllRooms += "" + roomMap.get(iterator.next());
        }
        return sAllRooms;
    }
    
    public void setType(HiveType hiveType) {
        this.type = hiveType;
    }
    
    @Override
    public String toString() {
        
        String hiveString = " " + getType();
        return hiveString; 
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