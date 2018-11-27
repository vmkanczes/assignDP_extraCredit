package main.java.apiary;

import main.java.apiary.builder.BeeType;
import main.java.apiary.builder.BuckfastHiveBuilderImpl;
import main.java.apiary.builder.CarniolanHiveBuilderImpl;
import main.java.apiary.builder.CaucasianHiveBuilderImpl;
import main.java.apiary.builder.GermanHiveBuilderImpl;
import main.java.apiary.builder.Hive;
import main.java.apiary.builder.IBeeBuilder;
import main.java.apiary.builder.IHiveBuilder;
import main.java.apiary.builder.ItalianHiveBuilderImpl;
import main.java.apiary.builder.Room;
import main.java.apiary.builder.RoomType;
import main.java.apiary.builder.RussianHiveBuilderImpl;
import main.java.apiary.decorator.AverageBeeImpl;
import main.java.apiary.decorator.RegularWorkerBee;
import main.java.apiary.decorator.BeeRole;
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
import main.java.apiary.decorator.RussianQueenBee;
import main.java.apiary.decorator.RussianWorkerBee;
import main.java.apiary.mediator.EggMediatorImpl;
import main.java.apiary.mediator.Queen;
import main.java.apiary.mediator.Worker;
import main.java.apiary.singleton.Apiary;

public class RunTestDesignPatterns {

    /**
     * Method: main Inputs: Returns:
     * 
     * <p>
     * Description: This will run each of the different design patterns and
     * demonstrate that each of them work and work together.
     */
    public static void main(String[] args) {

        runDemo();
    }

    /**
     * Method: addBroodRoom. Inputs: hive Returns:
     *
     * <p>
     * Description: Adds a brood room for that specific hive.
     */
    private static void addBroodRoom(Hive hive) {
        hive.roomBuilder(RoomType.BROOD, hive.getType());
    }

    /**
     * Method: createHive Inputs: hiveType Returns: returns the Hive created
     * 
     * <p>
     * Description: Makes the call to create the specific type of bee in the apiary.
     */
    private static IBee createBee(BeeType beeType, BeeRole beeRole) {

        IBee myBee = null;

        if (beeRole == BeeRole.WORKER) {
            // add bees to the apiary
            myBee = Apiary.getInstance().addWorkerBee(beeType);
            // } else if (beeRole == BeeRole.DRONE) {
            // myBee = Apiary.getInstance().addDroneBee(beeType);
        } else if ((beeRole == BeeRole.QUEEN)) {
            myBee = Apiary.getInstance().addQueenBee(beeType);
        } else {
            System.out.println("This bee role does not exist");
        }
        return myBee;
    }

    /**
     * Method: addRestRoom Inputs: hive Returns:
     * 
     * <p>
     * Description: Adds a rest room for that specific hive.
     */
    private static void addRestRoom(Hive hive) {
        hive.roomBuilder(RoomType.REST, hive.getType());
    }

    /**
     * Method: createHive Inputs: hiveType Returns: returns the Hive created
     * 
     * <p>
     * Description: Makes the call to create the specific type of hive in the
     * apiary.
     */
    private static Hive createHive(BeeType hiveType) {
        // add hives to the apiary
        Hive myHive = Apiary.getInstance().buildHive(hiveType);
        return myHive;
    }

    /**
     * Method: removeHive Inputs: Hive hive - the hive to be removed Returns:
     * Returns: void
     * 
     * <p>
     * Description: Removes the hive from the apiary.
     */
    private static void removeHive(Hive hive) {
        // remove hives from the apiary
        Apiary.getInstance().removeHives(hive);
    }

    /**
     * Method: layEgg Inputs: Bee Returns: void
     * 
     * <p>
     * Description: Mediator Pattern: Queen or worker can lay the egg
     */
    private static void layEgg(IBee bee) {

        // Mediator Pattern: eggs management
        EggMediatorImpl nature = new EggMediatorImpl();
        Queen queenBee;
        Worker workerBee;

        if (bee.getRole() == BeeRole.WORKER) {

            workerBee = new Worker(nature);
            workerBee.laidEggs(bee, bee.getReproduction());

        } else if (bee.getRole() == BeeRole.QUEEN) {
            queenBee = new Queen(nature);
            queenBee.laidEggs(bee, bee.getReproduction());
        }

    }

    /**
     * Method: layEgg Inputs: Bee Type egg Returns: void
     * 
     * <p>
     * Description: Mediator Pattern: Queen or worker can lay the egg
     */
    private static void feedEgg(IBee bee) {

        // Mediator Pattern: eggs management
        EggMediatorImpl nature = new EggMediatorImpl();
        Worker workerBee;

        workerBee = new Worker(nature);
        workerBee.laidEggs(bee, bee.getReproduction());
        nature.getEggStatus();

    }

    /**
     * Method: eatEgg Inputs: Bee Returns: void
     * 
     * <p>
     * Description: Mediator Pattern: Queen or worker can eat the egg
     */
    private static void eatEgg(IBee bee) {

        EggMediatorImpl nature = new EggMediatorImpl();
        Queen queenBee;
        Worker workerBee;

        if (bee.getRole() == BeeRole.WORKER) {

            workerBee = new Worker(nature);
            workerBee.eatEggs(bee, bee.getReproduction());

        } else if (bee.getRole() == BeeRole.QUEEN) {
            queenBee = new Queen(nature);
            queenBee.eatEggs(bee, bee.getReproduction());
        }

        nature.getEggStatus();

    }

    static void runDemo() {
        // Builder Pattern: to create hives in apiary

        System.out.println("\nSingeton Apiary:");

        Hive hive1 = createHive(BeeType.BUCKFAST);
        Hive hive2 = createHive(BeeType.GERMAN);
        Hive hive3 = createHive(BeeType.ITALIAN);
        Hive hive4 = createHive(BeeType.RUSSIAN);
        Hive hive5 = createHive(BeeType.CARNIOLAN);
        Hive hive6 = createHive(BeeType.CAUCASIAN);

        // Singleton Pattern: apiary to get information on the hives and the hive rooms
        System.out.println(Apiary.getInstance().toString());

        // Builder Pattern: create rooms for hives
        System.out.println("\nBuilder Pattern: Hive Rooms");
        addBroodRoom(hive1);
        addRestRoom(hive2);
        addBroodRoom(hive3);
        addRestRoom(hive4);
        addBroodRoom(hive5);
        addRestRoom(hive6);
        addBroodRoom(hive2);
        addRestRoom(hive1);
        addBroodRoom(hive4);
        addRestRoom(hive3);
        addBroodRoom(hive6);
        addRestRoom(hive5);
        addBroodRoom(hive4);
        addRestRoom(hive3);
        addBroodRoom(hive1);
        addRestRoom(hive2);
        addBroodRoom(hive6);
        addRestRoom(hive3);

        // Singleton Pattern: apiary to get information on the hives and the hive rooms
        System.out.println(Apiary.getInstance().toString());

        // Remove hive
        removeHive(hive3);

        // Singleton Pattern: apiary to get information on the hives and the hive rooms
        System.out.println(Apiary.getInstance().toString());

        // Create some bees
        IBee bee1 = createBee(BeeType.BUCKFAST, BeeRole.WORKER);
        IBee bee2 = createBee(BeeType.BUCKFAST, BeeRole.QUEEN);
        IBee bee3 = createBee(BeeType.GERMAN, BeeRole.WORKER);
        IBee bee4 = createBee(BeeType.GERMAN, BeeRole.QUEEN);
        IBee bee5 = createBee(BeeType.ITALIAN, BeeRole.WORKER);
        IBee bee6 = createBee(BeeType.ITALIAN, BeeRole.QUEEN);
        IBee bee7 = createBee(BeeType.CAUCASIAN, BeeRole.WORKER);
        IBee bee8 = createBee(BeeType.CAUCASIAN, BeeRole.QUEEN);
        IBee bee9 = createBee(BeeType.RUSSIAN, BeeRole.WORKER);
        IBee bee10 = createBee(BeeType.RUSSIAN, BeeRole.QUEEN);
        IBee bee11 = createBee(BeeType.CARNIOLAN, BeeRole.WORKER);
        IBee bee12 = createBee(BeeType.CARNIOLAN, BeeRole.QUEEN);

        // Singleton Pattern: apiary to get information on the hives and the hive rooms
        System.out.println(Apiary.getInstance().toString());

        // Do some actions
        layEgg(bee1);
        layEgg(bee2);
        feedEgg(bee1);
        eatEgg(bee4);
        layEgg(bee5);
        feedEgg(bee2);
        eatEgg(bee7);
        layEgg(bee8);
        feedEgg(bee5);
        eatEgg(bee10);
        feedEgg(bee8);
        layEgg(bee12);
        eatEgg(bee1);
        feedEgg(bee12);
        layEgg(bee3);

    }
}
