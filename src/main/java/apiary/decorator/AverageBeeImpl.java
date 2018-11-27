/**
File: IAverageBee.java
Author: vkanczes
Date: Nov 24, 2018

<p>Description: Implements the bee attributes for species average.
*/

package main.java.apiary.decorator;

import main.java.apiary.builder.BeeType;

/**
 * Class: IAverageBee
 * 
 * <p>Description: This class is to create an average ordinary bee with average
 * attributes.
 */
public class AverageBeeImpl implements IBee {
    
    private BeeType type;
    
    /**
     Method:
     Inputs: 
     Returns: 
     
     Description: 
     */
    public AverageBeeImpl(BeeType beeType) {
        this.type = beeType;
    }

    /**
     * Method: setType 
     * Inputs: 
     * Returns: enum BeeType
     * 
     * <p>Description: Sets the type of bee.
     */
    @Override public void setType(BeeType beeType) {
        this.type = beeType;
    }

    /**
     * Method: getType 
     * Inputs: 
     * Returns: enum BeeType
     * 
     * <p>Description: Gets the type of bee.
     */
    @Override public BeeType getType() {
        return this.type;
    }

    /**
     * Method: getGentleness 
     * Inputs: 
     * Returns: int bee's level of gentleness
     * 
     * <p>Description: Get the bee's friendliness.
     */
    @Override public int getGentleness() {
        return 3;
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
        return 3;
    }

    /**
     * Method: getPollination Inputs: Returns: int bee's level of honey pollination
     * 
     * <p>Description: Get the bee's ability to pollinate flowers.
     */
    @Override public int getPollination() {
        return 3;

    }

    /**
     * Method: getReproduction 
     * Inputs: 
     * Returns: int bee's level of ability to
     * production
     * 
     * <p>Description: Get the bee's ability to help make baby bees.
     */
    @Override public int getReproduction() {
        return 3;
    }

    /**
     * Method: getWaxProduction 
     * Inputs: 
     * Returns: int bee's level of wax production
     * 
     * <p>Description: Get the bee's ability to make wax to build the hive.
     */
    @Override public int getWaxProduction() {
        return 3;
    }

    /**
     * Method: getRole Inputs: Returns: BeeRole bee's role
     * 
     * <p>Description: Get the bee's role such as queen, worker, drone or spawner.
     */
    @Override public BeeRole getRole() { 
        return BeeRole.REGULAR;
    }

    /**
     * Method: toString
     * Inputs:
     * Outputs: String of attributes of the bee
     * 
     * <p>Description:  Creates string containing attributes of the bee.
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
