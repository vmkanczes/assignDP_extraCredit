package hiveBuilder;

public class HiveDirector {

    private HiveBuilder hiveBuilder;
    
    public HiveDirector(HiveBuilder hiveBuilder) {
        this.hiveBuilder = hiveBuilder;
    }
    
    public Hive getHive() {
        return this.hiveBuilder.getHive();
    }
    
    public void makeHive() {
        
        // TODO need to create room builder and bee builder
        //this.hiveBuilder.buildBee(beeBuilder);
        //this.hiveBuilder.buildRoom(roomBuilder);
    }
}
