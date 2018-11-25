package main.java.apiary.builder;

public class HiveBuildDirector {
    private IHiveBuilder builder;

    public HiveBuildDirector(final IHiveBuilder builder) {
        this.builder = builder;
    }

    public Hive construct() {
        return builder.buildHive();        
    }
}