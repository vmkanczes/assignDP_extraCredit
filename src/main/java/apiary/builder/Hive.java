package main.java.apiary.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Hive {

    private BeeType type;

    // inner map of rooms for the hives
    HashMap<RoomType, ArrayList<Room>> roomMap = new HashMap<RoomType, ArrayList<Room>>();
    
    /* nested map of hives and their associated rooms
     Map<HiveType, Map<RoomType, ArrayList<Room>>> outerMap = 
     new HashMap<HiveType, Map<RoomType, ArrayList<Room>>>();
     */
    
    /**        
     Method: roomBuilder
     Inputs: roomtype (type of room: brood or rest), hiveType (bee species)
     Returns: Room object
     
     Description:  Builds the room for a specific hive and adds it to the hashmap.
     */
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
    
    /**
     Method: getRooms
     Inputs: 
     Returns: String that contains all room in specific hive
     
     Description: Gets all the rooms for a specific hive.
     */
    public String getRooms() {
        // let us get all of the mapped objects 
        String rooms = "";
        StringBuffer buf = new StringBuffer();
                
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        while (iterator.hasNext()) {
            buf.append(roomMap.get(iterator.next()));
            
        }
        rooms = buf.toString();
        return rooms;
    }
    
    /**
     Method: getBroodRoomCount
     Inputs: 
     Returns: int the number of brood rooms
     
     Description: Gets all of the broom rooms for the hive.
     */
    public int getBroodRoomCount() {
        // let us get all of the mapped objects 
        String rooms = "";
        StringBuffer buf = new StringBuffer();
        int broodCount = 0;

        
        // get each room type
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        while (iterator.hasNext()) {
            buf.append(roomMap.get(iterator.next()));
        }
        
        rooms = buf.toString();
        
        // split the string to only get the necessary bits
        String fixedString = fixString(rooms);
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
    
    /**
    Method: getRestRoomCount
    Inputs: 
    Returns: int the number of rest rooms
    
    Description: Gets all of the rest rooms for the hive.
    */
    public int getRestRoomCount() {
        // let us get all of the mapped objects 
        String rooms = "";
        StringBuffer buf = new StringBuffer();
        int restCount = 0;

        
        // get each room type
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        while (iterator.hasNext()) {
            buf.append(roomMap.get(iterator.next()));
        }
        
        rooms = buf.toString();
        
        // split the string to only get the necessary bits
        String fixedString = fixString(rooms);
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
    
    /**
     * Method: toString
     * Inputs:
     * Outputs: String of hive information
     * 
     * <p>Description:  Creates string containing details about the hive.
     */
    @Override public String toString() {
        
        String hiveString = "" + getType();
        return hiveString; 
    }

    /**
    Method: getRoomCount
    Inputs: 
    Returns: int the number of rooms
    
    Description: Gets all of the rooms for the hive.
    */
    public int getRoomCount() {
        int roomCount = 0;
        // let us get all of the rooms       
        Iterator<ArrayList<Room>> iterator = roomMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Room> myRooms = iterator.next();
            roomCount += myRooms.size();
        }
        return roomCount;
    }
    
}