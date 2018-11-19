package builder;

public class HiveDirector {

    private HiveBuilder hiveBuilder;
    private RoomBuilder roomBuilder;
    
    public HiveDirector(HiveBuilder hiveBuilder) {
        this.hiveBuilder = hiveBuilder;
    }
    
    public Hive getHive() {
        return this.hiveBuilder.getHive();
    }
    
    public void makeHive() {
        this.hiveBuilder.buildRoom(roomBuilder);
            }
}
