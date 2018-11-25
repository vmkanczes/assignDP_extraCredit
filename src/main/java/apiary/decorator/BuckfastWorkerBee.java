package main.java.apiary.decorator;

/**
File: BuckfastWorkerBee.java
Author: vkanczes
Date: Nov 24, 2018

Description: creates the bee attributes for species Buckfast.
 */

import main.java.apiary.builder.BeeType;

/**
 * Class: BuckfastWorkerBee
 * 
 * <p>Description: This class is to create an Buckfast bee with specific.
 * attributes.
 */
public class BuckfastWorkerBee extends AttributeDecoratorImpl {

    public BuckfastWorkerBee(IBee newBee) {
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
        return BeeType.BUCKFAST;
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
        return tempBee.getHoneyProduction();
    }

    /**
     * Method: getPollination 
     * Inputs: 
     * Returns: int ability to pollinate followers
     * 
     * <p>Description: Get the bee's ability to pollinate flowers.
     */
    @Override public int getPollination() {
        return tempBee.getPollination();

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
     * Inputs: int bee's ability to produce wax
     * Returns:
     * 
     * <p>Description: Get the bee's ability to make wax to build the hive.
     */
    @Override public int getWaxProduction() {
        return tempBee.getWaxProduction() - 2;
    }

    /**
     * Method: getRole 
     * Inputs: 
     * Returns:int bee's role
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
                + "Wax Production: " + getWaxProduction() + " ");

        return beeAttributes;
    }

}
