package builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Hive {

    private BeeType type;

    // inner map of rooms for the hives
    HashMap<RoomType, ArrayList<Room>> roomMap = new HashMap<RoomType, ArrayList<Room>>();
    
    // nested map of hives and their associated rooms
    // Map<HiveType, Map<RoomType, ArrayList<Room>>> outerMap = new HashMap<HiveType, Map<RoomType, ArrayList<Room>>>();
            
    public Room roomBuilder(RoomType roomType, BeeType hiveType) {
        
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
    
    public void removeBroodRoom() {
        roomMap.remove(RoomType.BROOD); 
    }
    
    public void removeRestRoom() {
        roomMap.remove(RoomType.REST); 
    }

    public BeeType getType() {
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
    
    public int getBroodRoomCount() {
        // let us get all of the mapped objects 
        String sAllRooms = "";
        int broodCount = 0;

        
        // get each room type
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        while (iterator.hasNext()) {
            sAllRooms += "" + roomMap.get(iterator.next());
        }
        
        // split the string to only get the necessary bits
        String fixedString = fixString(sAllRooms);
        String[] tokens = fixedString.split(" ");

        // loop through and get count of brood rooms only
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("BROOD")) {
                broodCount++;
            }
        }
        
        return broodCount;
    }
    
    private String fixString(String s) {
                
        String s1 = s.replace("[", "");
        String s2 = s1.replace("]", " ");
        String s3 = s2.replace(',', ' ');
        return s3;
    
}
    
    public int getRestRoomCount() {
        // let us get all of the mapped objects 
        String sAllRooms = "";
        int restCount = 0;

        
        // get each room type
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        while (iterator.hasNext()) {
            sAllRooms += "" + roomMap.get(iterator.next());
        }
        
     // split the string to only get the necessary bits
        String fixedString = fixString(sAllRooms);
        String[] tokens = fixedString.split(" ");

        // loop through and get count of brood rooms only
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("REST")) {
                restCount++;
            }
        }
        
        return restCount;
    }
    
    public void setType(BeeType hiveType) {
        this.type = hiveType;
    }
    
    @Override
    public String toString() {
        
        String hiveString = "" + getType();
        return hiveString; 
    }

    public int getRoomCount() {
        int roomCount=0;
     // let us get all of the rooms       
        Iterator<ArrayList<Room>> iterator = roomMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Room> myRooms = iterator.next();
            roomCount += myRooms.size();
        }
        return roomCount;
    }
    
}