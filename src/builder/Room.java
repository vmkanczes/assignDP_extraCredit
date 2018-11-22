package builder;

public class Room implements RoomPlan {

    private RoomType type;
    
    public RoomType getType() {
        return type;
    }

    public void setType(RoomType val) {
        this.type = val;
    }
    
}
