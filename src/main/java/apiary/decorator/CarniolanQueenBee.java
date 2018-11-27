package main.java.apiary.decorator;

/**
File: CarniolanWorkerBee.java
Author: vkanczes
Date: Nov 24, 2018

Description: creates the bee attributes for species CarniolanWorkerBee.
 */

import main.java.apiary.builder.BeeType;

/**
 * Class: CarniolanWorkerBee
 * 
 * <p>Description: This class is to create an Carniolan bee with specific
 * attributes.
 */
public class CarniolanQueenBee extends AttributeDecoratorImpl {

    private BeeType type;
    
    /**
     * Constructor Input: newBee
     * 
     * <p>Description: constructor to a bee.
     */
    public CarniolanQueenBee(IBee newBee) {
        super(newBee);

    }

    /**
     * Method: getType 
     * Inputs: 
     * Returns: enum BeeType
     * 
     * <p>Description: Gets the type of bee.
     */
    @Override public BeeType getType() {
        return BeeType.CARNIOLAN;
    }

    /**
     * Method: getGentleness 
     * Inputs: 
     * Returns: int bee's level of gentleness
     * 
     * <p>Description: Get the bee's friendliness.
     */
    @Override public int getGentleness() {
        return tempBee.getGentleness() - 1;
    }

    /**
     * Method: getHoneyProduction 
     * Inputs: 
     * Returns: int bee's level of honey
     * production
     * 
     * <p>Description: Get the bee's ability to produce honey.
     */
    @Override public int getHoneyProduction() {
        return tempBee.getHoneyProduction() - 3;
    }

    /**
     * Method: getPollination 
     * Inputs: 
     * Returns: int bee's ability to pollinate
     * 
     * <p>Description: Get the bee's ability to pollinate flowers.
     */
    @Override public int getPollination() {
        return tempBee.getPollination() - 3;

    }

    /**
     * Method: getReproduction 
     * Inputs: 
     * Returns: int bee's ability to reproduce
     * 
     * <p>Description: Get the bee's ability to help make baby bees.
     */
    @Override public int getReproduction() {
        return tempBee.getReproduction() - 1;
    }

    /**
     * Method: getWaxProduction 
     * Inputs: 
     * Returns: int bee's ability to create wax
     * 
     * <p>Description: Get the bee's ability to make wax to build the hive.
     */
    @Override public int getWaxProduction() {
        return tempBee.getWaxProduction() - 3;
    }

    /**
     * Method: getRole 
     * Inputs: 
     * Returns: int bee's role
     * 
     * <p>Description: Get the bee's role such as queen, worker, drone or spawner.
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
