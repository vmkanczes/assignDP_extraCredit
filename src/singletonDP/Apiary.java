package singletonDP;

import java.util.ArrayList;

import builder.BroodRoomBuilder;
import builder.BuckfastHiveBuilder;
import builder.CarniolanHiveBuilder;
import builder.CaucasianHiveBuilder;
import builder.GermanHiveBuilder;
import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.HiveType;
import builder.ItalianHiveBuilder;
import builder.Room;
import builder.RussianHiveBuilder;

class Apiary {

    private static final Apiary _APIARY_INSTANCE = new Apiary();
    ArrayList <Hive> hives = new ArrayList();

    // private constructor since there is only ever ONE apiary
    private Apiary() {
    }

    /**
     * getInstance: Inputs: Returns: returns the only instance of the apiary
     * object
     * 
     * Description: this will return the single instance of the apiary which
     * is used by for all hive creation
     */
    public static Apiary getInstance() {
        return _APIARY_INSTANCE;
    }

    /**
     * Method: buildHive
     * 
     * @return the hive that was created
     * 
     * Description: Calls the createHive method to create a new bee hive of specified type
     */
    public void buildHive(HiveType hiveType) {
        
        System.out.println("Building a new hive of type: " + hiveType);

        HiveBuilder myHiveBuilder = null;
        switch (hiveType)
        {
          case ITALIAN:
              myHiveBuilder = new ItalianHiveBuilder();
              
              break;
          case CARNIOLAN:
              myHiveBuilder = new CarniolanHiveBuilder();
              break;
          case BUCKFAST:
              myHiveBuilder = new BuckfastHiveBuilder();
              break;
          case RUSSIAN: 
              myHiveBuilder = new RussianHiveBuilder();
              break;
          case GERMAN:
              myHiveBuilder = new GermanHiveBuilder();
              break;
          case CAUCASIAN:
              myHiveBuilder = new CaucasianHiveBuilder();
              break;
          default: 
              System.out.println("No such hive...");
        }
           // build a hive
           HiveDirector hiveDirector = new HiveDirector(myHiveBuilder);
           hiveDirector.makeHive();
           Hive newHive = hiveDirector.getHive(); 
           hives.add(newHive);
       }

    
}
