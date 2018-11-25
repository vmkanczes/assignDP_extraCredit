package main.java.apiary.builder;

public class BuckfastHiveBuilderImpl implements IHiveBuilder {

    private Hive hive;

    public BuckfastHiveBuilderImpl() {
        this.hive = new Hive();
    }

    @Override
    public Hive buildHive() {
        hive.setType(BeeType.BUCKFAST);
        return hive;
    }

    @Override
    public IHiveBuilder setType(final BeeType hiveType) {
        hive.setType(hiveType);
        return this;
    }

   
}
