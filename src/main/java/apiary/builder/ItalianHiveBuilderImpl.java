package builder;

public class ItalianHiveBuilderImpl implements IHiveBuilder {

    private Hive hive;

    public ItalianHiveBuilderImpl() {
        this.hive = new Hive();
    }

    @Override
    public Hive buildHive() {
        hive.setType(BeeType.ITALIAN);
        return hive;
    }

    @Override
    public IHiveBuilder setType(final BeeType hiveType) {
        hive.setType(hiveType);
        return this;
    }

   
}
