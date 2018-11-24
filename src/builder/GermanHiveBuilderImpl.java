package builder;

public class GermanHiveBuilderImpl implements IHiveBuilder {

    private Hive hive;

    public GermanHiveBuilderImpl() {
        this.hive = new Hive();
    }

    @Override
    public Hive buildHive() {
        hive.setType(BeeType.GERMAN);
        return hive;
    }

    @Override
    public IHiveBuilder setType(final BeeType hiveType) {
        hive.setType(hiveType);
        return this;
    }

   
}
