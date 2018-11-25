package main;

import beeAttributeDecorator.AverageBeeImpl;
import beeAttributeDecorator.BuckfastWorkerBee;
import beeAttributeDecorator.CarniolanWorkerBee;
import beeAttributeDecorator.CaucasianWorkerBee;
import beeAttributeDecorator.GermanWorkerBee;
import beeAttributeDecorator.IBee;
import beeAttributeDecorator.ItalianWorkerBee;
import beeAttributeDecorator.RussianWorkerBee;
import beeMediator.Drone;
import beeMediator.Honey;
import beeMediator.NatureMediatorImpl;
import beeMediator.Queen;
import beeMediator.Worker;
import builder.BeeType;
import builder.Hive;
import builder.RoomType;
import singletonDP.Apiary;

public class TestDesignPatterns {

    /**
     * Method: main 
     * Inputs: 
     * Returns:
     * 
     * <p>Description: This will run each of the different design patterns and
     * demonstrate that each of them work and work together.
     */
    public static void main(String[] args) {

        // Builder Pattern: to create hives in apiary
        System.out.println("\nSingeton Apiary: Hive Rooms");
        System.out.println("\nBuilder Pattern: Hives");

        Hive hive1 = createHive(BeeType.BUCKFAST);
        Hive hive2 = createHive(BeeType.GERMAN);

        // Builder Pattern: create rooms for hives
        System.out.println("\nBuilder Pattern: Hive Rooms");
        addBroodRoom(hive1);
        addRestRoom(hive2);

        // build and then remove a hive
        Hive hive3 = createHive(BeeType.RUSSIAN);
        removeHive(hive3);

        // Singleton Pattern: apiary to get information on the hives and the hive rooms
        System.out.println(Apiary.getInstance().toString());

        // Decorator Pattern: to create some worker bees of each type
        System.out.println("\nDecorator Pattern");
        System.out.println("\nBees: Species and Attributes!");
        IBee regularBee = new AverageBeeImpl();
        System.out.println(regularBee.toString());

        IBee germanWorkerBee = new GermanWorkerBee(new AverageBeeImpl());
        System.out.println(germanWorkerBee.toString());

        IBee italianWorkerBee = new ItalianWorkerBee(new AverageBeeImpl());
        System.out.println(italianWorkerBee.toString());

        IBee buckfastWorkerBee = new BuckfastWorkerBee(new AverageBeeImpl());
        System.out.println(buckfastWorkerBee.toString());

        IBee carniolanWorkerBee = new CarniolanWorkerBee(new AverageBeeImpl());
        System.out.println(carniolanWorkerBee.toString());

        IBee russianWorkerBee = new RussianWorkerBee(new AverageBeeImpl());
        System.out.println(russianWorkerBee.toString());

        IBee caucasianWorkerBee = new CaucasianWorkerBee(new AverageBeeImpl());
        System.out.println(caucasianWorkerBee.toString());

        // Mediator Pattern: Fertilize eggs
        System.out.println("\nMediator Pattern");
        NatureMediatorImpl nature = new NatureMediatorImpl();

        // Decorator Pattern and Mediator:
        // bee attributes used to determine how many eggs they lay
        Queen queenBee = new Queen(nature);
        queenBee.layEggs(BeeType.GERMAN, germanWorkerBee.getReproduction() * 50);
        queenBee.layEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 60);
        
        Worker workerBee = new Worker(nature);
        workerBee.layEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 10);

        // create the honey bee and have do an action
        Honey honeyBee = new Honey(nature);
        honeyBee.fertilizeEggs(BeeType.GERMAN, germanWorkerBee.getReproduction() * 30, 1);
        honeyBee.fertilizeEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 35, 1);
        
        Drone drone = new Drone(nature);
        drone.fertilizeEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 40, 2);

        nature.getEggStatus();

    }

    /**
     * Method: addBroodRoom 
     * Inputs: hive 
     * Returns:
     * 
     * <p>Description: Adds a brood room for that specific hive.
     */
    private static void addBroodRoom(Hive hive) {
        hive.roomBuilder(RoomType.BROOD, hive.getType());
    }

    /**
     * Method: addRestRoom 
     * Inputs: hive 
     * Returns:
     * 
     * <p>Description: Adds a rest room for that specific hive.
     */
    private static void addRestRoom(Hive hive) {
        hive.roomBuilder(RoomType.REST, hive.getType());
    }

    /**
     * Method: createHive 
     * Inputs: hiveType 
     * Returns: returns the Hive created
     * 
     * <p>Description: Makes the call to create the specific type of hive in the
     * apiary.
     */
    private static Hive createHive(BeeType hiveType) {
        // add hives to the apiary
        Hive myHive = Apiary.getInstance().buildHive(hiveType);
        return myHive;
    }

    /**
     * Method: removeHive 
     * Inputs: Hive hive - the hive to be removed Returns:
     * Returns: void
     * 
     * <p>Description: Removes the hive from the apiary.
     */
    private static void removeHive(Hive hive) {
        // remove hives from the apiary
        Apiary.getInstance().removeHives(hive);
    }

}
