package main.java.apiary.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import main.java.apiary.builder.Bee;
import main.java.apiary.builder.BeeBuildDirector;
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
import main.java.apiary.decorator.AverageBeeImpl;
import main.java.apiary.decorator.BuckfastQueenBee;
import main.java.apiary.decorator.BuckfastWorkerBee;
import main.java.apiary.decorator.CarniolanQueenBee;
import main.java.apiary.decorator.CarniolanWorkerBee;
import main.java.apiary.decorator.CaucasianQueenBee;
import main.java.apiary.decorator.CaucasianWorkerBee;
import main.java.apiary.decorator.GermanQueenBee;
import main.java.apiary.decorator.GermanWorkerBee;
import main.java.apiary.decorator.IBee;
import main.java.apiary.decorator.ItalianQueenBee;
import main.java.apiary.decorator.ItalianWorkerBee;
import main.java.apiary.decorator.RegularWorkerBee;
import main.java.apiary.decorator.RussianQueenBee;
import main.java.apiary.decorator.RussianWorkerBee;

public class Apiary {

    private static final Apiary _APIARY_INSTANCE = new Apiary();
    
    // store all of the hives
    private static HashMap<BeeType, ArrayList<Hive>> hiveMap 
        = new HashMap<BeeType, ArrayList<Hive>>();
    
    // store all of the bees
    private static HashMap<BeeType, ArrayList<IBee>> beeMap 
    = new HashMap<BeeType, ArrayList<IBee>>();

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
    
    /**
     * Method: addWorkerBee 
     * Inputs: BeeType (bee species) 
     * Returns: addBee returns the bee
     * that was created
     * 
     * <p>Description: Calls the method to create a new bee hive of
     * specified type.
     */
    public IBee addWorkerBee(BeeType beeType) {

        IBee newBee = null;
        
        switch (beeType) {
        case ITALIAN:
            newBee = new ItalianWorkerBee(new AverageBeeImpl(BeeType.ITALIAN));
            break;
        case CARNIOLAN:
            newBee = new CarniolanWorkerBee(new AverageBeeImpl(BeeType.CARNIOLAN));
            break;
        case BUCKFAST:
            newBee = new BuckfastWorkerBee(new AverageBeeImpl(BeeType.BUCKFAST));
        case RUSSIAN:
            newBee = new RussianWorkerBee(new AverageBeeImpl(BeeType.RUSSIAN));
            break;
        case GERMAN:
            newBee = new GermanWorkerBee(new AverageBeeImpl(BeeType.GERMAN));
            break;
        case CAUCASIAN:
            newBee = new CaucasianWorkerBee(new AverageBeeImpl(BeeType.CAUCASIAN));
            break;
        default:
            newBee = new RegularWorkerBee(new AverageBeeImpl(BeeType.REGULAR));
        }
        
        System.out.println(newBee.toString());

        // check if bee type already exists
           ArrayList<IBee> myBeeList = beeMap.get(beeType);
           if (myBeeList == null) {
               // create array list
               myBeeList = new ArrayList<IBee>();
               beeMap.put(beeType, myBeeList);
           }
           myBeeList.add(newBee);
           return newBee;
    }      
        
        /**
         * Method: addWorkerBee 
         * Inputs: BeeType (bee species) 
         * Returns: addBee returns the bee
         * that was created
         * 
         * <p>Description: Calls the method to create a new bee hive of
         * specified type.
         */
        public IBee addQueenBee(BeeType beeType) {

            IBee newBee = null;
            
            switch (beeType) {
            case ITALIAN:
                newBee = new ItalianQueenBee(new AverageBeeImpl(BeeType.ITALIAN));
                break;
            case CARNIOLAN:
                newBee = new CarniolanQueenBee(new AverageBeeImpl(BeeType.CARNIOLAN));
                break;
            case BUCKFAST:
                newBee = new BuckfastQueenBee(new AverageBeeImpl(BeeType.BUCKFAST));
                break;
            case RUSSIAN:
                newBee = new RussianQueenBee(new AverageBeeImpl(BeeType.RUSSIAN));
                break;
            case GERMAN:
                newBee = new GermanQueenBee(new AverageBeeImpl(BeeType.GERMAN));
                break;
            case CAUCASIAN:
                newBee = new CaucasianQueenBee(new AverageBeeImpl(BeeType.CAUCASIAN));
                break;
            default:
                newBee = new RegularWorkerBee(new AverageBeeImpl(BeeType.REGULAR));
        }        
           
        System.out.println(newBee.toString());

     // check if bee type already exists
        ArrayList<IBee> myBeeList = beeMap.get(beeType);
        if (myBeeList == null) {
            // create array list
            myBeeList = new ArrayList<IBee>();
            beeMap.put(beeType, myBeeList);
        }
        myBeeList.add(newBee);
        return newBee;
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
            iterator.next();
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
        StringBuffer buf = new StringBuffer();

        // let us get all of the hives
        Iterator<BeeType> iterator = hiveMap.keySet().iterator();
        while (iterator.hasNext()) {
            buf.append(hiveMap.get(iterator.next()));

        }
        
        allHives = buf.toString();

        return allHives;

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
        StringBuffer buf = new StringBuffer();

        // let us get all of the hive rooms
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator = myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                buf.append(myHive.getRooms());
            }
        }
        allRooms = buf.toString();

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
