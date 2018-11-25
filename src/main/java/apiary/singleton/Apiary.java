package main.java.apiary.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import main.java.apiary.builder.BeeType;
import main.java.apiary.builder.BuckfastHiveBuilderImpl;
import main.java.apiary.builder.CarniolanHiveBuilderImpl;
import main.java.apiary.builder.CaucasianHiveBuilderImpl;
import main.java.apiary.builder.GermanHiveBuilderImpl;
import main.java.apiary.builder.Hive;
import main.java.apiary.builder.HiveBuildDirector;
import main.java.apiary.builder.IHiveBuilder;
import main.java.apiary.builder.ItalianHiveBuilderImpl;
import main.java.apiary.builder.RussianHiveBuilderImpl;

public class Apiary {

    private static final Apiary _APIARY_INSTANCE = new Apiary();
    private static HashMap<BeeType, ArrayList<Hive>> hiveMap 
        = new HashMap<BeeType, ArrayList<Hive>>();

    // private constructor since there is only ever ONE apiary
    private Apiary() {
    }

    /**
     * Method: getInstance: 
     * Inputs: 
     * Returns: returns the only instance of the apiary object
     * 
     * <p>Description: this will return the single instance of the apiary which is used
     * by for all hive creation.
     */
    public static Apiary getInstance() {
        return _APIARY_INSTANCE;
    }

    /**
     * Method: buildHive 
     * Inputs: BeeType (bee species) 
     * Returns: Hive return the hive
     * that was created
     * 
     * <p>Description: Calls the createHive method to create a new bee hive of
     * specified type.
     */
    public Hive buildHive(BeeType beeType) {

        IHiveBuilder myHiveBuilder = null;
        switch (beeType) {
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
                break;
        }

        // final IRoomBuilder broodBuilder = new BroodRoomBuilderImpl();
        final HiveBuildDirector hiveBuildDirector = new HiveBuildDirector(myHiveBuilder);
        Hive newHive = hiveBuildDirector.construct();

        // check if hive type already exists
        ArrayList<Hive> myHiveList = hiveMap.get(beeType);
        if (myHiveList == null) {
            // create array list
            myHiveList = new ArrayList<Hive>();
            hiveMap.put(beeType, myHiveList);
        }
        myHiveList.add(newHive);
        return newHive;
    }

    public void removeHives(Hive hive) {

        hiveMap.remove(hive.getType());
    }

    /**
     * Method: getHiveCount 
     * Inputs: 
     * Returns: int that contains total number of hives.
     * 
     * <p>Description: Lists out each hive by species.
     */
    public int getHiveCount() {

        int hiveCount = 0;

        // let us get all of the hives
        Iterator<BeeType> iterator = hiveMap.keySet().iterator();
        while (iterator.hasNext()) {
            hiveMap.get(iterator.next());
            hiveCount++;
        }
        return hiveCount;

    }

    /**
     * Method: getHives 
     * Inputs: 
     * Returns: String that contains all of the hive names
     * 
     * <p>Description: Lists out each hive by species.
     */
    public String getHives() {

        String allHives = "";

        // let us get all of the hives
        Iterator<BeeType> iterator = hiveMap.keySet().iterator();
        while (iterator.hasNext()) {
            allHives += "\n" + hiveMap.get(iterator.next());
        }
        return allHives;

    }

    /**
     * Method: removeBroodRoom 
     * Inputs: BeeType - bee species 
     * Returns:
     * 
     * <p>Description: Removes the brood room for this hive.
     */
    public void removeBroodRoom(BeeType beeType) {

        // let us get all of the hives
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator = myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                if (myHive.getType() == beeType) {
                    myHive.removeBroodRoom();
                }
            }
        }
    }

    /**
     * Method: removeRestRoom 
     * Inputs: BeeType - bee species 
     * Returns:
     * 
     * <p>Description: Removes the room for this hive.
     */
    public void removeRestRoom(BeeType beeType) {

        // let us get all of the hives
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator = myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                if (myHive.getType() == beeType) {
                    myHive.removeBroodRoom();
                }
            }
        }
    }

    /**
     * Method: getRooms 
     * Inputs: 
     * Returns: String that contains all room in specific
     * hive
     * 
     * <p>Description: Gets all the rooms for a specific hive.
     */
    public String getHiveRooms() {

        String allRooms = "";
        // let us get all of the hives
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator = myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                allRooms += myHive.getRooms();
            }
        }
        return allRooms;
    }
    
    /**
     * Method: getRoomCount 
     * Inputs: 
     * Returns: int that contains total number of rooms.
     * 
     * <p>Description: Give total number of rooms in the apiary
     */
    public int getRoomCount() {

        int totalRoomCount = 0;
        // let us get all of the hives
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator = myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                totalRoomCount += myHive.getRoomCount();
            }
        }
        return totalRoomCount;
    }

    /**
     * Method: toString 
     * Inputs: 
     * Outputs: String of apiary information
     * 
     * <p>Description: Creates string containing details about the apiary.
     */
    public String toString() {

        String allHives = getHives();

        String myApiary = "Apiary Hives: "
                + getHiveCount() + "\n" 
                + allHives + "\n\nApiary Rooms: "
                + getRoomCount()
                + "\nHive map: " + hiveMap.toString() 
                + "\nRooms: " + getHiveRooms();
        return myApiary;
    }

}
