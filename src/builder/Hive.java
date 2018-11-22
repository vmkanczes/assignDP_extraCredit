package builder;

public class Hive implements HivePlan {

    private Object room;
    private HiveType type;
    
    @Override
    public void setRoom(Object r) {
        room = r;
    }

    public Object getRoom() {
        return room;
    }

    public void setType(HiveType val) {
        this.type = val;
    }
    
    public HiveType getType() {
        return type;
    }
    
}
