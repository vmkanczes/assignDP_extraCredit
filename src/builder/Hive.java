package builder;

public class Hive implements HivePlan {

    private Object room;
    private String type;

    @Override
    public void setRoom(Object r) {
        room = r;
    }

    public Object getRoom() {
        return room;
    }

    
    @Override
    public void setType(String t) {
        type = t;
    }
    
    public String getType() {
        return type;
    }
    
}
