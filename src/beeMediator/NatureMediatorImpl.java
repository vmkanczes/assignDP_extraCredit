/**
File: IMediator.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package beeMediator;

import java.util.ArrayList;

import builder.BeeType;

/**
Class:

Description:
 */
public class NatureMediatorImpl implements INature {
    
    private ArrayList<Bee> bees;
    private ArrayList<EggCare> eggsLaid;
    private ArrayList<EggCare> eggsFertilized;
    
    private int beeCodes = 0;
    
    public NatureMediatorImpl() {
        
        bees = new ArrayList<Bee>();
        eggsLaid = new ArrayList<EggCare>();
        eggsFertilized = new ArrayList<EggCare>();
        
    }
    
    public void addBee(Bee newBee) {
        bees.add(newBee);
        beeCodes++;
        newBee.setCode(beeCodes);
        
    }
    
    public void layEggs(BeeType type, int eggs,  int code) {
        
        boolean giveEgg = false;
        
        System.out.println( "\nMEDIATOR: ");
        
        System.out.println("Laid eggs call: " + eggs + " of type " + type +
                " by bee code " + eggs);
        
        for (EggCare egg : eggsFertilized) {
            
            System.out.println("Laid eggs call: " + eggs + " of type " + type +
                    " by bee code " + egg.getCode());
            
            
            if((egg.getType() == type) && (egg.getEggs() == eggs)) {
                
                System.out.println(eggs + "of type" + type +
                        " fertilized by bee code " + egg.getCode());
                
                eggsFertilized.remove(egg);
                
                giveEgg = true;
            }
            if (giveEgg) {
                break;
            }
            
            if (!giveEgg) {
                
                System.out.println(eggs + " eggs of type " + type + 
                        " still unfertilized...");
                
                EggCare newRequest = new EggCare(type, eggs, code);
                
                eggsLaid.add(newRequest);      
                
            }
        }
    }  

    /**
     * Method: fertilizeEggs
     * 
     * Description:  queen will request to have the eggs fertilized
     */
public void fertilizeEggs(BeeType type, int eggs,  int code) {
        
        boolean eggFertilized = false;
        
        for (EggCare egg : eggsLaid) {
            
            System.out.println("fertilizeEggs Call: " + eggs + " of type " + type +
                    " by bee code " + egg.getCode());
            
            if((egg.getType() == type) && (egg.getEggs() == eggs)) {
                
                System.out.println(eggs + "of type" + type +
                        " fertilized by bee code " + egg.getCode());
                
                eggsLaid.remove(egg);
                
                eggFertilized = true;
            }
            if (eggFertilized) {
                break;
            }
            
            if (!eggFertilized) {
                
                System.out.println(eggs + " eggs of type " + type + 
                        " still unfertilized...");
                
                EggCare newRequest = new EggCare(type, eggs, code);
                
                eggsLaid.add(newRequest);      
                
            }
        }
    }  

    public void getEggStatus() {
        System.out.println("Unfertilized Eggs");
        
        for (EggCare egg : eggsLaid) {
            
            System.out.println(egg.getEggs() + " of type " + egg.getType());
        }
        
        System.out.println("Fertilized Eggs");
        
        for (EggCare egg : eggsFertilized) {
            
            System.out.println(egg.getEggs() + " of type " + egg.getType());
        }
    }


      

}
