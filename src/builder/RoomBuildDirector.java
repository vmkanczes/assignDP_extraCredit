package builder;

public class RoomBuildDirector {
    private IRoomBuilder builder;

    public RoomBuildDirector(final IRoomBuilder builder) {
        this.builder = builder;
    }

    public Room construct() {
        return builder.setType(RoomType.BROOD).buildRoom();        
    }
}
