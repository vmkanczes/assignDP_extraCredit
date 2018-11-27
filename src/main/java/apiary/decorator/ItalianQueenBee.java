package main.java.apiary.decorator;

/**
File: ItalianWorkerBee.java
Author: vkanczes
Date: Nov 24, 2018

Description: creates the bee attributes for species ItalianWorkerBee.
 */

import main.java.apiary.builder.BeeType;

/**
Class: ItalianWorkerBee

Description: This class is to create an German ordinary bee with specific attributes.
 */
public class ItalianQueenBee extends AttributeDecoratorImpl {
    
    private BeeType type;
    
    public ItalianQueenBee(IBee newBee) {
        super(newBee);
        
    }

    /**
     Method: getType
     Inputs: 
     Returns: enum BeeType
     
     Description:  Gets the type of bee.
     */
    @Override public BeeType getType() {
        return BeeType.ITALIAN;
    }
    
    /**
     Method:  getGentleness
     Inputs: 
     Returns: int bee's level of gentleness
     
     Description: Get the bee's friendliness.
     */
    @Override public int getGentleness() {
        return tempBee.getGentleness() + 2;
    }
    
    /**
     Method:  getHoneyProduction
     Inputs: 
     Returns: int bee's level of honey production
     
     Description:  Get the bee's ability to produce honey.
     */
    @Override public int getHoneyProduction() {
        return tempBee.getHoneyProduction() + 2;
    }
    
    /**
     Method: getPollination
     Inputs: 
     Returns: 
     
     Description:  Get the bee's ability to pollinate flowers.
     */
    @Override public int getPollination() {
        return tempBee.getPollination() - 3;

    }
    
    /**
     Method:  getReproduction
     Inputs: 
     Returns: int 
     
     Description:  Get the bee's ability to help make baby bees.
     */
    @Override public int getReproduction() {
        return tempBee.getReproduction() + 2;
    }
    
    /**
     Method:  getWaxProduction
     Inputs: 
     Returns: 
     
     Description: Get the bee's ability to make wax to build the hive.
     */
    @Override public int getWaxProduction() {
        return tempBee.getWaxProduction() - 3;
    }
    
    /**
     Method: getRole
     Inputs: 
     Returns: 
     
     Description: Get the bee's role such as queen, worker, drone or spawner.
     */
    @Override public BeeRole getRole() {
        return BeeRole.QUEEN;
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
