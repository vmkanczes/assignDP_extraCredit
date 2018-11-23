package builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hive {

    private HiveType type;

    private ArrayList <Room> roomList;
    private Map<RoomType, ArrayList<Room>> roomMap = new HashMap<RoomType, ArrayList<Room>>(10,0.75F);

    //Map<HiveType, Entry<RoomType, Integer>> hiveMap = new HashMap<HiveType, Entry<RoomType, Integer>>();
    
    public Room roomBuilder(RoomType roomType, HiveType hiveType) {
        
        //System.out.println("Building a new room of type: " + roomType + " for hive: " + hiveType);

        IRoomBuilder myRoomBuilder = null;
        switch (roomType) {
        case REST:
            myRoomBuilder = new BroodRoomBuilderImpl();
            break;
        case BROOD:
            myRoomBuilder = new RestRoomBuilderImpl();
            break;
        default:
            System.out.println("Room type does not exist.");
            return null;
        }

        final RoomBuildDirector roomBuildDirector = new RoomBuildDirector(myRoomBuilder);
        Room newRoom = roomBuildDirector.construct();
        
     // check if room type already exists
        Iterator<RoomType> iterator = roomMap.keySet().iterator();
        if (!iterator.hasNext()) {
                // create array list
                ArrayList <Room> roomList = new ArrayList<Room>();
                roomList.add(newRoom); 
        }
        
        roomMap.put(roomType, roomList);
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
    

    public void setType(HiveType hiveType) {
        this.type = hiveType;
    }
    
    @Override
    public String toString() {
        
        return "Hive: " + getType(); 
    }
    
}