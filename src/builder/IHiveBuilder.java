package builder;


public interface IHiveBuilder  {
           
    Hive buildHive();
        
    IHiveBuilder setType(final HiveType hiveType);
    
}