package singletonDP;

import builder.Hive;
import builder.HiveBuilder;
import builder.HiveDirector;
import builder.HiveType;

class Apiary {

    private static final Apiary _APIARY_INSTANCE = new Apiary();
    
    // keep track of the number of hives created
    private int italianHiveCount = 0;
    private int carniolanHiveCount = 0;
    private int buckfastHiveCount = 0;
    private int russianHiveCount = 0;
    private int germanHiveCount = 0;
    private int caucasianHiveCount = 0;

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
    public static void buildHive(HiveType hiveType) {
        
           // build a hive
           System.out.println("Making new hive of type: " + hiveType);
           HiveDirector hiveDirector = new HiveDirector(hiveType);
           hiveDirector.makeHive();

           Hive newHive = hiveDirector.getHive();            

       }
    }

    /**
     * Method: createHive 
     * Inputs: 
     * Returns: @return
     * 
     * Description: This will create a new hive based on specified type
     */
    public  createHive(HiveType val) {
        
    }
}
