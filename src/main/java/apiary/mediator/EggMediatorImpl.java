package main.java.apiary.mediator;

/**
File: EggMediatorImpl.java
Author: @author
Date: Nov 24, 2018

Description:  Mediator implementation for the eggs to know egg status
 */

import java.util.ArrayList;

import main.java.apiary.builder.BeeType;

/**
Class:  EggMediatorImpl

Description: Mediator to keep track of the eggs and know what is happening.
 */
public class EggMediatorImpl implements IEggMediator {
    
    private ArrayList<Bee> bees;
    private ArrayList<EggCare> eggsLaid;
    private ArrayList<EggCare> eggsFed;
    private ArrayList<EggCare> eggsEaten;
    
    /**
     * Constructor.
     */
    public EggMediatorImpl() {
        
        bees = new ArrayList<Bee>();
        eggsLaid = new ArrayList<EggCare>();
        eggsFed = new ArrayList<EggCare>();
        eggsEaten = new ArrayList<EggCare>();
 
    }
    
    /**
     * Method: addBee
     * Inputs: Bee
     * Returns:  
     * 
     * <p>Description: updates the new bee.
     */
    public void addBee(Bee newBee) {

        bees.add(newBee);
        
    }
    
    /**
     * Method: layEggs
     * Inputs: Bee type, eggs laid, code
     * Returns:  
     * 
     * <p>Description: Updates the eggs to know there more to be fed.
     */
    public void layEggs(BeeType type, int eggs) {
        
        boolean eggFed = false;
                
        System.out.println("Eggs to be fed: " + eggs + " of type " + type);
        
        for (EggCare egg : eggsFed) {
            
            System.out.println("Eggs to be fed: " + eggs + " of type " + type);
            
            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {
                
                System.out.println("Eggs to be fed: " + eggs + " of type " + type);
                
                eggsFed.remove(egg);
                
                eggFed = true;
            }
            
            if (eggFed) {
                break;
            }
            
            if (!eggFed) {
                
                System.out.println(eggs + " eggs of type " + type
                        + " still need to be fed");
                
                EggCare newRequest = new EggCare(type, eggs);
                
                // egg wasn't feed so asking again..
                eggsLaid.add(newRequest);      
                
            }
        }
    }  

    /**
     * Method: feedEggs
     * Inputs: bee type, eggs to be fed
     * 
     * <p>Description:  queen will request to have the eggs fed.
     */
    public void feedEggs(BeeType type, int eggs) {
        
        boolean eggFed = false;
        
        for (EggCare egg : eggsLaid) {
            
            System.out.println("Eggs fed: " + eggs + " of type " + type);
            
            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {
                
                System.out.println("Eggs fed: " + eggs + " of type " + type);
                
                eggsLaid.remove(egg);
                
                eggFed = true;
            }
            if (eggFed) {
                break;
            }
            
            if (!eggFed) {
                
                System.out.println(eggs + " eggs of type " + type
                       + " still not fed.");
                
                EggCare newRequest = new EggCare(type, eggs);
                
                eggsLaid.add(newRequest);      
                
            }
        }
    }  
    
    /**
     * Method: eatEggs
     * Inputs: bee type, eggs that may be eaten
     * 
     * <p>Description:  queen may eat the eggs for worker bee.
     */
    public void eatEggs(BeeType type, int eggs) {
        
        boolean eggEaten = false;
        
        for (EggCare egg : eggsLaid) {
            
            System.out.println("Eggs eaten: " + eggs + " of type " + type);
            
            if ((egg.getType() == type) && (egg.getEggs() == eggs)) {
                
                System.out.println("Eggs eaten: " + eggs + " of type " + type);
                
                eggsLaid.remove(egg);
                
                eggEaten = true;
            }
            if (eggEaten) {
                
                System.out.println("Oh no! Egg eaten: " + eggs + " of type " + type);

                break;
            }
            
            if (!eggEaten) {
                
                System.out.println("Yay! Egg not eaten: " + eggs + " of type " + type);
                
                EggCare newRequest = new EggCare(type, eggs);
                
                eggsLaid.add(newRequest);      
                
            }
        }
    }  

    /**
     * Method: getEggStatus
     * Inputs: 
     * Returns:  
     * 
     * <p>Description: Gets the status of how many eggs were laid, fed and eaten.
     */
    public void getEggStatus() {
        System.out.println("Eggs Laid");
        
        for (EggCare egg : eggsLaid) {
            
            System.out.println("Eggs laid " + egg.getEggs() + " of type " + egg.getType());
        }
        
        System.out.println("Eggs Fed");
        
        for (EggCare egg : eggsFed) {
            
            System.out.println("Eggs fed " + egg.getEggs() + " of type " + egg.getType());
        }
        
        System.out.println("Eggs Eaten");
        
        for (EggCare egg : eggsEaten) {
            
            System.out.println("Eggs eaten " + egg.getEggs() + " of type " + egg.getType());
        }
    }

}
