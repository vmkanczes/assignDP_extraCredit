package main.java.apiary.decorator;

/**
File: RussianWorkerBee.java
Author: vkanczes
Date: Nov 24, 2018

Description: creates the bee attributes for species RussianWorkerBee.
 */

import main.java.apiary.builder.BeeType;

/**
Class: RussianWorkerBee

Description: This class is to create an Russian bee with specific attributes.
 */
public class RussianWorkerBee extends AttributeDecoratorImpl {
    
    private BeeType type;
    
    public RussianWorkerBee(IBee newBee) {
        super(newBee);
        
    }

    /**
     Method: getType
     Inputs: 
     Returns: enum BeeType
     
     Description:  Gets the type of bee.
     */
    @Override public BeeType getType() {
        return BeeType.RUSSIAN;
    }
    
    /**
     Method:  getGentleness
     Inputs: 
     Returns: int bee's level of gentleness
     
     Description: Get the bee's friendliness.
     */
    @Override public int getGentleness() {
        return tempBee.getGentleness();
    }
    
    /**
     Method:  getHoneyProduction
     Inputs: 
     Returns: int bee's level of honey production
     
     Description:  Get the bee's ability to produce honey.
     */
    @Override public int getHoneyProduction() {
        return tempBee.getHoneyProduction() - 2;
    }
    
    /**
     Method: getPollination
     Inputs: 
     Returns: 
     
     Description:  Get the bee's ability to pollinate flowers.
     */
    @Override public int getPollination() {
        return tempBee.getPollination();

    }
    
    /**
     Method:  getReproduction
     Inputs: 
     Returns: int 
     
     Description:  Get the bee's ability to help make baby bees.
     */
    @Override public int getReproduction() {
        return tempBee.getReproduction();
    }
    
    /**
     Method:  getWaxProduction
     Inputs: 
     Returns: 
     
     Description: Get the bee's ability to make wax to build the hive.
     */
    @Override public int getWaxProduction() {
        return tempBee.getWaxProduction();
    }
    
    /**
     Method: getRole
     Inputs: 
     Returns: 
     
     Description: Get the bee's role such as queen, worker, drone or spawner.
     */
    @Override public BeeRole getRole() {
        return BeeRole.WORKER;
    } 
    
    /**
     * Method: toString
     * Inputs:
     * Outputs: String of bee attribute information
     * 
     * <p>Description:  Creates string containing details about the bee.
     */
    public String toString() {
        
        String beeAttributes = (getType() + " "
                + getRole() + " " 
                + "Gentleness: " + getGentleness() + " "
                + "Honey Production: " + getHoneyProduction() + " "
                + "Pollination: " + getPollination() + " "
                + "Reproduction: " + getReproduction() + " "
                + "Wax Production: " + getWaxProduction() + " "
                );
        
        return beeAttributes;
    }
    
    /**
    Method:
    Inputs: 
    Returns: 
    
    Description: 
    */
   @Override
   public void setType(BeeType beeType) {
           this.type = beeType;
   }

    /**
     Method:
     Inputs: 
     Returns: 
     
     Description: 
     */
    @Override
    public void laidEggs(IBee bee, int reproduction) {
        // TODO Auto-generated method stub
        
    }
    
}
