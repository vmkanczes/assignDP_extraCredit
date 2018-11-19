package builder;

public class GermanHiveBuilder implements HiveBuilder {

    private Hive hive;
    
    public GermanHiveBuilder() {
        this.hive = new Hive();
    }
    
    @Override
    public void buildRoom(Object r) {
        hive.setRoom(r);
    }

    @Override
    public void buildHive(Object r) {
        hive.setType("German");        
    }
    
    @Override
    public Hive getHive() {
        return this.hive;
    }


}
