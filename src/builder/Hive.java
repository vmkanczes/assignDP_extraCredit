package builder;

import java.util.ArrayList;
import java.util.Arrays;

public class Hive {

    private HiveType type;
    
    public Room roomBuilder(RoomType roomType) {
        
        ArrayList <Room> rooms = new ArrayList();

        System.out.println("Building a new room of type: " + roomType);

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
        rooms.add(newRoom);

        System.out.println("My rooms: " + Arrays.toString(rooms.toArray()));
        
        return newRoom;
    }

    
    public HiveType getType() {
        return type;
    }
    


    public void setType(HiveType val) {
        this.type = val;
    }
    
    @Override
    public String toString() {
        return "Hive  = " + getType();
    }
    
}