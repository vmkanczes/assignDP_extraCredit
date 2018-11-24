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
import builder.BeeType;
import builder.RoomType;
import singletonDP.Apiary;


public class TestDesignPatterns {

    public static void main(String[] args) {
        
        // Build Pattern - create hives
        Hive hive1 = createHive(BeeType.BUCKFAST);
        Hive hive2 = createHive(BeeType.BUCKFAST);
        Hive hive3 = createHive(BeeType.GERMAN);
        Hive hive4 = createHive(BeeType.GERMAN);
        Hive hive5 = createHive(BeeType.RUSSIAN);
        Hive hive6 = createHive(BeeType.CARNIOLAN);
        Hive hive7 = createHive(BeeType.CAUCASIAN);
        Hive hive8 = createHive(BeeType.ITALIAN);
        
        removeBeeHives(BeeType.BUCKFAST);
        
        // Builder Pattern - create rooms for hives
        addBroodRoom(hive1);
        addRestRoom(hive1);
        addBroodRoom(hive1);
        addRestRoom(hive1);
        addBroodRoom(hive2);
        addRestRoom(hive2);
        addBroodRoom(hive2);
        addRestRoom(hive3);
        addBroodRoom(hive3);
        addRestRoom(hive3);  
        addRestRoom(hive4);        
        addRestRoom(hive5);        
        addRestRoom(hive6); 
        addBroodRoom(hive7);        
        addBroodRoom(hive8);    
        addRestRoom(hive8);        

        // Call singleton apiary to get information on the hives and the hive rooms
        System.out.println(Apiary.getInstance().toString());
        
        // create some worker bees of each type
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
    }

    private static void addBroodRoom(Hive hive) {
        hive.roomBuilder(RoomType.BROOD, hive.getType());        
    }
    
    private static void addRestRoom(Hive hive) {
        hive.roomBuilder(RoomType.REST, hive.getType());        
    }

    private static Hive createHive(BeeType hiveType) {
        // add hives to the apiary
        Hive myHive = Apiary.getInstance().buildHive(hiveType);
        return myHive;       
    }  
    
    private static void removeBeeHives(BeeType beeType) {
        // remove hives from the apiary
        Apiary.getInstance().removeHives(beeType);
    }  
    
    

}
