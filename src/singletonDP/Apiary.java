package singletonDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import builder.Hive;
import builder.IHiveBuilder;
import builder.HiveBuildDirector;
import builder.HiveType;
import builder.ItalianHiveBuilderImpl;
import builder.RussianHiveBuilderImpl;
import builder.BuckfastHiveBuilderImpl;
import builder.CarniolanHiveBuilderImpl;
import builder.CaucasianHiveBuilderImpl;
import builder.GermanHiveBuilderImpl;

public class Apiary {

    private static final Apiary _APIARY_INSTANCE = new Apiary();
    HashMap<HiveType, ArrayList<Hive>> hiveMap = new HashMap<HiveType, ArrayList<Hive>>();

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

        // final IRoomBuilder broodBuilder = new BroodRoomBuilderImpl();
        final HiveBuildDirector hiveBuildDirector = new HiveBuildDirector(myHiveBuilder);
        Hive newHive = hiveBuildDirector.construct();

        // check if hive type already exists
        ArrayList<Hive> myHiveList = hiveMap.get(hiveType);
        if (myHiveList == null) {
            // create array list
            myHiveList = new ArrayList<Hive>();
            hiveMap.put(hiveType, myHiveList);
        }
        myHiveList.add(newHive);

        return newHive;

    }

    public void getHives() {

        // let us get all of the hives        
        Iterator<HiveType> iterator = hiveMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("Hive: " + hiveMap.get(iterator.next()));
        }

    }

    public int getRoomCount() {
        
        int roomCount=0;
     // let us get all of the hives       
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator= myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                roomCount += myHive.getRoomCount();
            }
        }
        return roomCount;
    }

}
