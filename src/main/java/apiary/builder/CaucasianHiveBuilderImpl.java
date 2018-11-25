package main.java.apiary.builder;

public class CaucasianHiveBuilderImpl implements IHiveBuilder {

    private Hive hive;

    public CaucasianHiveBuilderImpl() {
        this.hive = new Hive();
    }

    @Override
    public Hive buildHive() {
        hive.setType(BeeType.CAUCASIAN);
        return hive;
    }

    @Override
    public IHiveBuilder setType(final BeeType hiveType) {
        hive.setType(hiveType);
        return this;
    }

   
}
