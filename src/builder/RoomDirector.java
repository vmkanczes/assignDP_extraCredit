package builder;

public class RoomDirector {

    private RoomBuilder roomBuilder;
    private static int roomCount = 0;
    
    public RoomDirector(RoomBuilder roomBuilder) {
        this.roomBuilder = roomBuilder;
    }
    
    public Room getRoom() {
        return this.roomBuilder.getRoom();
    }
    
    public void makeRoom() {
        
        this.roomBuilder.buildRoom();
        roomCount++;
                
        if (roomCount == 1) {
            System.out.println("First Room: " + roomCount);
            buildHive();
        }
    }
        
        public void buildHive() {
         // build a hive
            System.out.println("Making first hive: " + roomCount);
            HiveBuilder germanHive = new GermanHiveBuilder();
            HiveDirector hiveDirector = new HiveDirector(germanHive);
            hiveDirector.makeHive();

            Hive newHive = hiveDirector.getHive();
        }
}
