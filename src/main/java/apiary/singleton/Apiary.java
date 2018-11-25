package singletonDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import builder.Hive;
import builder.IHiveBuilder;
import builder.HiveBuildDirector;
import builder.BeeType;
import builder.ItalianHiveBuilderImpl;
import builder.RussianHiveBuilderImpl;
import builder.BuckfastHiveBuilderImpl;
import builder.CarniolanHiveBuilderImpl;
import builder.CaucasianHiveBuilderImpl;
import builder.GermanHiveBuilderImpl;

public class Apiary {

    private static final Apiary _APIARY_INSTANCE = new Apiary();
    private static HashMap<BeeType, ArrayList<Hive>> hiveMap = new HashMap<BeeType, ArrayList<Hive>>();

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
    
    public void removeHives(BeeType beeType) {
        //System.out.println("Current map is: "+ hiveMap);
        //System.out.println("Removing bee hives for: " + beeType);
        hiveMap.remove(beeType);              
    }

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
    public String getHives() {

        String sAllHives = "";
        
        // let us get all of the hives        
        Iterator<BeeType> iterator = hiveMap.keySet().iterator();
        while (iterator.hasNext()) {
            sAllHives += "\n" + hiveMap.get(iterator.next());
        }
        return sAllHives;
        
    }
    
public void removeBroodRoom(BeeType beeType) {
        
     // let us get all of the hives       
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator= myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                if (myHive.getType() == beeType) {
                    myHive.removeBroodRoom();
                }
            }
        }
    }

public void removeRestRoom(BeeType beeType) {
    
    // let us get all of the hives       
       Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
       while (iterator.hasNext()) {
           ArrayList<Hive> myHives = iterator.next();
           Iterator<Hive> myHivesIterator= myHives.iterator();

           while (myHivesIterator.hasNext()) {
               Hive myHive = myHivesIterator.next();
               if (myHive.getType() == beeType) {
                   myHive.removeBroodRoom();
               }
           }
       }
   }
    
    public String getHiveRooms() {
     
        String sAllRooms = "";
     // let us get all of the hives       
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator= myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                sAllRooms += myHive.getRooms();
            }
        }
        return sAllRooms;
    }
    
    public int getRoomCount() {
        
        int totalRoomCount = 0;
     // let us get all of the hives       
        Iterator<ArrayList<Hive>> iterator = hiveMap.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<Hive> myHives = iterator.next();
            Iterator<Hive> myHivesIterator= myHives.iterator();

            while (myHivesIterator.hasNext()) {
                Hive myHive = myHivesIterator.next();
                totalRoomCount += myHive.getRoomCount();
            }
        }
        return totalRoomCount;
    }
    
    public String toString() {
        
        String sAllHives = getHives();
        

        String myApiary = "Apiary Hives: " + getHiveCount() +  
                            "\n" + sAllHives + 
                            "\n\nApiary Rooms: " + getRoomCount() + 
                            "\nHive map: " + hiveMap.toString() +
                            "\nRooms: " + getHiveRooms(); 
        return myApiary; 
    }

}
