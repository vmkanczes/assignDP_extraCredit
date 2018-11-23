package builder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hive {

    private HiveType type;
    private static int hiveId = 1;
    private int roomCount = 0;
    private int broodCount = 0;
    private static int totalBroodCount = 0;
    private int restCount = 0;
    private static int totalRestCount = 0;
    
    private static int totalRoomCount = 0;

    private static Map<HiveType, RoomType> hashMap = new HashMap<HiveType, RoomType>(10,0.75F);
    HashMap<Integer,HashMap<HiveType,RoomType>> hiveMap = new HashMap<>();
    Set<Map.Entry<HiveType, RoomType>> entries = hashMap.entrySet();
    //Map<HiveType, Entry<RoomType, Integer>> hiveMap = new HashMap<HiveType, Entry<RoomType, Integer>>();
    
    public Room roomBuilder(RoomType roomType, HiveType hiveType) {
        
        //System.out.println("Building a new room of type: " + roomType + " for hive: " + hiveType);

        IRoomBuilder myRoomBuilder = null;
        switch (roomType) {
        case REST:
            myRoomBuilder = new BroodRoomBuilderImpl();
            restCount++;
            totalRestCount++;
            break;
        case BROOD:
            myRoomBuilder = new RestRoomBuilderImpl();
            broodCount++;
            totalBroodCount++;
            break;
        default:
            System.out.println("Room type does not exist.");
            return null;
        }

        final RoomBuildDirector roomBuildDirector = new RoomBuildDirector(myRoomBuilder);
        Room newRoom = roomBuildDirector.construct();
        hashMap.put(hiveType, roomType);
        //hiveMap.put(hiveType, new SimpleEntry(roomType, roomCount));
        roomCount++;
        totalRoomCount++;
        
        return newRoom;
        
    }

    public HiveType getType() {
        return type;
    }
    
    public void getRooms() {
        // let us get all of the mapped objects
        //Set<Map.Entry<HiveType, RoomType>> entries = hashMap.entrySet();
        
        for (Map.Entry<HiveType, RoomType> hiveType : entries) {
            System.out.println("Key: " + hiveType.getKey());
            System.out.println("Value: " + hiveType.getValue());
        }
        
        Iterator<HiveType> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            RoomType room = hashMap.get(iterator.next());
            System.out.println("Room: " + room);
        }
    }
    
    public int getTotalRoomCount() {
        return totalRoomCount;
    }
    
    public int getRoomCount() {
        return roomCount;
    }

    public void setType(HiveType hiveType) {
        this.type = hiveType;
    }
    
    @Override
    public String toString() {
        
        return getType() +  
                " hiveId:" + " " + getHiveId() + " = " +
                "Room count: " + roomCount + " =" +
                " Brood: " + broodCount + 
                " Rest: " + restCount;
    }
    
 public String getRoomTotals() {
        
        return "\n"+
                "Total Room Count: " + totalRoomCount + "\n" +
                "Total Brood Count: " + totalBroodCount + "\n" +
                "Total Rest Count: " + totalRestCount;
    }

/**
 * @return the hiveId
 */
public static int getHiveId() {
    return hiveId;
}

/**
 * @param hiveId the hiveId to set
 */
public static void setHiveId(int hiveId) {
    Hive.hiveId = hiveId;
}

    
    
}