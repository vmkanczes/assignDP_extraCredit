package builder;

public class Hive {

    private HiveType type;
    
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