package main.java.apiary.builder;

public class CarniolanHiveBuilderImpl implements IHiveBuilder {

    private Hive hive;

    public CarniolanHiveBuilderImpl() {
        this.hive = new Hive();
    }

    @Override public Hive buildHive() {
        hive.setType(BeeType.CARNIOLAN);
        return hive;
    }

    @Override public IHiveBuilder setType(final BeeType hiveType) {
        hive.setType(hiveType);
        return this;
    }

   
}
