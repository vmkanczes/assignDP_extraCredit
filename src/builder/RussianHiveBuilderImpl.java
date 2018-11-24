package builder;

public class RussianHiveBuilderImpl implements IHiveBuilder {

    private Hive hive;

    public RussianHiveBuilderImpl() {
        this.hive = new Hive();
    }

    @Override
    public Hive buildHive() {
        hive.setType(BeeType.RUSSIAN);
        return hive;
    }

    @Override
    public IHiveBuilder setType(final BeeType hiveType) {
        hive.setType(hiveType);
        return this;
    }

   
}
