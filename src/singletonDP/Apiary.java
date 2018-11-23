package singletonDP;

import java.util.ArrayList;
import java.util.Arrays;


import builder.Hive;
import builder.IHiveBuilder;
import builder.IRoomBuilder;
import builder.HiveBuildDirector;
import builder.HiveType;
import builder.ItalianHiveBuilderImpl;
import builder.RoomBuildDirector;
import builder.RussianHiveBuilderImpl;
import builder.BroodRoomBuilderImpl;
import builder.BuckfastHiveBuilderImpl;
import builder.CarniolanHiveBuilderImpl;
import builder.CaucasianHiveBuilderImpl;
import builder.GermanHiveBuilderImpl;

public class Apiary {

    private static final Apiary _APIARY_INSTANCE = new Apiary();
    ArrayList <Hive> hives = new ArrayList();

    // private constructor since there is only ever ONE apiary
    private Apiary() {
    }

    /**
     * getInstance: Inputs: Returns: returns the only instance of the apiary object
     * 
     * Description: this will return the single instance of the apiary which is used
     * by for all hive creation
     */
    public static Apiary getInstance() {
        return _APIARY_INSTANCE;
    }

    /**
     * Method: buildHive
     * 
     * @return the hive that was created
     * 
     *         Description: Calls the createHive method to create a new bee hive of
     *         specified type
     */
    public Hive buildHive(HiveType hiveType) {

        System.out.println("Apriary Singleton is building a new hive of type: " + hiveType);

        IHiveBuilder myHiveBuilder = null;
        switch (hiveType) {
        case ITALIAN:
             myHiveBuilder = new ItalianHiveBuilderImpl();

            break;
        case CARNIOLAN:
            myHiveBuilder = new CarniolanHiveBuilderImpl();
            break;
        case BUCKFAST:
            myHiveBuilder = new BuckfastHiveBuilderImpl();
            break;
        case RUSSIAN:
            myHiveBuilder = new RussianHiveBuilderImpl();
            break;
        case GERMAN:
            myHiveBuilder = new GermanHiveBuilderImpl();
            break;
        case CAUCASIAN:
             myHiveBuilder = new CaucasianHiveBuilderImpl();
            break;
        default:
            System.out.println("No such hive...");
        }
        
        //final IRoomBuilder broodBuilder = new BroodRoomBuilderImpl();
        final HiveBuildDirector hiveBuildDirector = new HiveBuildDirector(myHiveBuilder);        
        Hive newHive = hiveBuildDirector.construct();
        hives.add(newHive);        
        return newHive;

    }

    public void getHives() {
        // let us print all the elements available in list
        for (Hive hive : hives) {
            System.out.println("getHives = " + hive.toString());
        }
    }

    public void getHiveCount(HiveType hiveType) {
        // let us print all the elements available in list
        int count = 0;

        for (Hive hive : hives) {
            if (hive.getType() == hiveType) {
                count++;
            }  
            System.out.println("Hive type: " + hiveType.name() + ":  " + count);

        }

    }

}
