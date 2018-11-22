package singletonDP;

import java.util.ArrayList;
import java.util.Arrays;

import builder.BuckfastHiveBuilder;
import builder.CarniolanHiveBuilder;
import builder.CaucasianHiveBuilder;
import builder.GermanHiveBuilder;
import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.HiveType;
import builder.ItalianHiveBuilder;
import builder.RussianHiveBuilder;

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
    public void buildHive(HiveType hiveType) {

        System.out.println("Building a new hive of type: " + hiveType);

        HiveBuilder myHiveBuilder = null;
        switch (hiveType) {
        case ITALIAN:
            myHiveBuilder = new ItalianHiveBuilder();

            break;
        case CARNIOLAN:
            myHiveBuilder = new CarniolanHiveBuilder();
            break;
        case BUCKFAST:
            myHiveBuilder = new BuckfastHiveBuilder();
            System.out.println("Building BUCKFAST");
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
        String x = Arrays.toString(hives.toArray());
        System.out.println("My hives: " + x);

    }

    public void getHives() {
        // let us print all the elements available in list
        for (Hive hive : hives) {
            System.out.println("Hive = " + hive.toString());
        }
    }

    public void getHiveCount(HiveType hiveType) {
        // let us print all the elements available in list
        int count = 0;

        for (Hive hive : hives) {
              HiveType x = hive.getType();
            if (hive.getType() == hiveType) {
                count++;
            }  
        }
        System.out.println("Hive type: " + hiveType.name() + ":  " + count);

    }

}
