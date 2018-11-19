package hiveBuilder;

public class Hive implements HivePlan {

    private Object room;
    private Object bee;

    @Override
    public void setRoom(Object r) {
        room = r;
    }

    @Override
    public void setBee(Object b) {
            bee = b;        
    }

    public Object getRoom() {
        return room;
    }
    
    public Object getBee() {
        return bee;
    }
    


    


    
    
    
}
