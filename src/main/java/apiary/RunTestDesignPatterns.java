package main.java.apiary;

import main.java.apiary.attributeDecorator.AverageBeeImpl;
import main.java.apiary.attributeDecorator.BuckfastWorkerBee;
import main.java.apiary.attributeDecorator.CarniolanWorkerBee;
import main.java.apiary.attributeDecorator.CaucasianWorkerBee;
import main.java.apiary.attributeDecorator.GermanWorkerBee;
import main.java.apiary.attributeDecorator.IBee;
import main.java.apiary.attributeDecorator.ItalianWorkerBee;
import main.java.apiary.attributeDecorator.RussianWorkerBee;
import main.java.apiary.builder.BeeType;
import main.java.apiary.builder.Hive;
import main.java.apiary.builder.RoomType;
import main.java.apiary.mediator.Drone;
import main.java.apiary.mediator.Honey;
import main.java.apiary.mediator.NatureMediatorImpl;
import main.java.apiary.mediator.Queen;
import main.java.apiary.mediator.Worker;
import main.java.apiary.singleton.Apiary;


public class RunTestDesignPatterns {

    public static void main(String[] args) {
        
        // Builder Pattern: to create hives in apiary
        System.out.println("\nSingeton Apiary: Hive Rooms");
        System.out.println("\nBuilder Pattern: Hives");

        Hive hive1 = createHive(BeeType.BUCKFAST);
        Hive hive2 = createHive(BeeType.GERMAN);
        Hive hive3 = createHive(BeeType.RUSSIAN);

        // remove a hive
        removeHive(BeeType.RUSSIAN);
        
        // Builder Pattern: create rooms for hives
        System.out.println("\nBuilder Pattern: Hive Rooms");
        addBroodRoom(hive1);
        addRestRoom(hive2);       

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
        
        // Mediator Pattern:  Fertilize eggs
        System.out.println("\nMediator Pattern");
         NatureMediatorImpl  nature = new NatureMediatorImpl();
         
         // create egg laying
         Worker workerBee = new Worker(nature);
         Queen queenBee = new Queen(nature);
         
         // create fertilizers
         Drone drone = new Drone(nature);
         Honey honeyBee = new Honey(nature);
         
         // Decorator Pattern and Mediator: 
         // bee attributes used to determine how many eggs they lay
         queenBee.layEggs(BeeType.GERMAN, germanWorkerBee.getReproduction() * 50);
         queenBee.layEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 60);
         workerBee.layEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 10);

         honeyBee.fertilizeEggs(BeeType.GERMAN, germanWorkerBee.getReproduction() * 30, 1);
         honeyBee.fertilizeEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 35, 1);
         drone.fertilizeEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 40, 2);

         nature.getEggStatus();
         
    }

    /** 
     Method:  addBroodRoom
     Inputs:  hive 
     Returns: 
     
     Description: Adds a brood room for that specific hive
     */
    private static void addBroodRoom(Hive hive) {
        hive.roomBuilder(RoomType.BROOD, hive.getType());        
    }
    
    /** 
    Method:  addRestRoom
    Inputs:  hive 
    Returns: 
    
    Description: Adds a rest room for that specific hive
    */
    private static void addRestRoom(Hive hive) {
        hive.roomBuilder(RoomType.REST, hive.getType());        
    }
    
    /** 
    Method:  createHive
    Inputs:  hive 
    Returns: 
    
    Description: Makes the call to create the hive
    */
    private static Hive createHive(BeeType hiveType) {
        // add hives to the apiary
        Hive myHive = Apiary.getInstance().buildHive(hiveType);
        return myHive;       
    }  
    
    /** 
    Method:  removeHive
    Inputs:  hive 
    Returns: 
    
    Description: Removes the hive from the apiary
    */
    private static void removeHive(BeeType beeType) {
        // remove hives from the apiary
        Apiary.getInstance().removeHives(beeType);
    }    

}
