package main.java.apiary.decorator;

/**
File: GermanWorkerBee.java
Author: vkanczes
Date: Nov 24, 2018

Description: creates the bee attributes for species GermanWorkerBee.
 */

import main.java.apiary.builder.BeeType;

/**
 * Class: GermanWorkerBee
 * 
 * <p>Description: This class is to create an German ordinary bee with specific
 * attributes.
 */
public class GermanWorkerBee extends AttributeDecoratorImpl {

    public GermanWorkerBee(IBee newBee) {
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
        return BeeType.GERMAN;
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
     * Returns: int bee's level of honey production
     * 
     * <p>Description: Get the bee's ability to produce honey.
     */
    @Override public int getHoneyProduction() {
        return tempBee.getHoneyProduction() + 2;
    }

    /**
     * Method: getPollination 
     * Inputs: 
     * Returns: int bee's ability to pollinate
     * 
     * <p>Description: Get the bee's ability to pollinate flowers.
     */
    @Override public int getPollination() {
        return tempBee.getPollination() - 1;

    }

    /**
     * Method: getReproduction 
     * Inputs: 
     * Returns: int bee's reproduction abilities
     * 
     * <p>Description: Get the bee's ability to help make baby bees.
     */
    @Override public int getReproduction() {
        return tempBee.getReproduction()  + 2;
    }

    /**
     * Method: getWaxProduction 
     * Inputs: 
     * Returns: int bee's ability to make wax
     * 
     * <p>Description: Get the bee's ability to make wax to build the hive.
     */
    @Override public int getWaxProduction() {
        return tempBee.getWaxProduction();
    }

    /**
     * Method: getRole 
     * Inputs: 
     * Returns:
     * 
     * <p>Description: Get the bee's role such as queen, worker, drone or spawner.
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

}
