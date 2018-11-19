package builder;

public class Room implements RoomPlan {

    private String type;
    
    @Override
    public void setType(String t) {
        type = t;
    }
    
    public String getType() {
        return type;
    }
    
}
