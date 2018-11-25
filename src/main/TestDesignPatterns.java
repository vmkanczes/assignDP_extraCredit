package main;

import builder.Hive;
import beeAttributeDecorator.AverageBeeImpl;
import beeAttributeDecorator.BuckfastWorkerBee;
import beeAttributeDecorator.CarniolanWorkerBee;
import beeAttributeDecorator.CaucasianWorkerBee;
import beeAttributeDecorator.GermanWorkerBee;
import beeAttributeDecorator.IBee;
import beeAttributeDecorator.ItalianWorkerBee;
import beeAttributeDecorator.RussianWorkerBee;
import beeMediator.Drone;
import beeMediator.QueenMediatorImpl;
import beeMediator.Worker;
import builder.BeeType;
import builder.RoomType;
import singletonDP.Apiary;


public class TestDesignPatterns {

    public static void main(String[] args) {
        
        // Builder Pattern: to create hives in apiary
        Hive hive1 = createHive(BeeType.BUCKFAST);
        Hive hive2 = createHive(BeeType.GERMAN);
        Hive hive3 = createHive(BeeType.RUSSIAN);

        // remove a hive
        removeHive(BeeType.RUSSIAN);
        
        // Builder Pattern: create rooms for hives
        addBroodRoom(hive1);
        addRestRoom(hive2);       

        // Singleton Pattern: apiary to get information on the hives and the hive rooms
        System.out.println(Apiary.getInstance().toString());
        
        // Decorator Pattern: to create some worker bees of each type
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
         QueenMediatorImpl  nature = new QueenMediatorImpl();
         
         // create egg laying
         Worker workerBee = new Worker(nature);
         Drone droneBee = new Drone(nature);
         
         // Decorator Pattern and Mediator: 
         // bee attributes used to determine how many eggs they lay
         drone.layEggs(BeeType.GERMAN, germanWorkerBee.getReproduction() * 100);
         queenBee.layEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 100);
         workerBee.layEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 10);

         workerBee.fertilizeEggs(BeeType.GERMAN, germanWorkerBee.getReproduction() * 100, 0);
         queenBee.fertilizeEggs(BeeType.ITALIAN, italianWorkerBee.getReproduction() * 100, 0);
         
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
