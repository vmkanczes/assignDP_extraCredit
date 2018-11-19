package singletonDP;

import hiveBuilder.Hive;

class Apiary {

    private static final Apiary _APIARY_INSTANCE = new Apiary();
    private int hiveIndex = 0;
    // created hive array to create different hive types for the apiary
    private static String[] hiveArray = {"Italian", "Carniolan", "Buckfast", "Russian", "German", "Caucasion"};

    // private constructor
    private Apiary() {
    }

    /**
     * getInstance: Inputs: Returns: returns the only instance of the apiary
     * object
     * 
     * Description: this will return the single instance of the apiary which
     * is used by all routes
     */
    public static Apiary getInstance() {
        return _APIARY_INSTANCE;
    }

    /**
     * Method: Calls the nextHive method to get the next hive in the beehive array
     * so we are rotating through different hives to create
     * 
     * @return the next color to be used for drawing the route's path
     */
    public static Object getHive() {
        return getInstance().nextHive();
    }

    /**
     * Method: nextColor Inputs: Returns: @return
     * 
     * Description: This will choose the next color so route paths will not be using
     * repeating colors to better display routes
     */
    private Object nextHive() {
        // increment so I get the next color
        hiveIndex++;
        // make sure I only get a different hive
        return hiveArray[hiveIndex % hiveArray.length];
    }
}
