package hiveBuilder;

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
    public void buildBee(Object b) {
        hive.setBee(b);
    }

    @Override
    public Hive getHive() {
        return this.hive;
    }

}
