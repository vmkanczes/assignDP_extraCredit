package beeAttributeDecorator;
/**
File: CaucasianWorkerBee.java
Author: vkanczes
Date: Nov 23, 2018

Description: The average bee so other bee attributes can be increased or decreased.
 */
import builder.BeeType;

/**
Class: CaucasianWorkerBee

Description: This class is to create an Caucasian bee with specific attributes
 */
public class CaucasianWorkerBee extends AttributeDecoratorImpl {
    
    /**
     * @param newBee
     */
    public CaucasianWorkerBee(IBee newBee) {
        super(newBee);
        
    }

    /**
     * 
     Method: getType
     Inputs: 
     Returns: @return enum BeeType
     
     Description:  Gets the type of bee
     */
    @Override
    public BeeType getType() {
        return BeeType.CAUCASIAN;
    }
    
    /**
     * 
     Method:  getGentleness
     Inputs: 
     Returns: @return  int bee's level of gentleness
     
     Description: Get the bee's friendliness
     */
    @Override
    public int getGentleness() {
        return tempBee.getGentleness() + 2;
    }
    
    /**
     * 
     Method:  getHoneyProduction
     Inputs: 
     Returns: @return int bee's level of honey production
     
     Description:  Get the bee's ability to produce honey.
     */
    @Override
    public int getHoneyProduction() {
        return tempBee.getHoneyProduction() - 1;
    }
    
    /**
     * 
     Method: getPollination
     Inputs: 
     Returns: @return 
     
     Description:  Get the bee's ability to pollinate flowers
     */
    @Override
    public int getPollination() {
        return tempBee.getPollination() + 1;

    }
    
    /**
     * 
     Method:  getReproduction
     Inputs: 
     Returns: @return int 
     
     Description:  Get the bee's ability to help make baby bees
     */
    @Override
    public int getReproduction() {
        return tempBee.getReproduction() -2;
    }
    
    /**
     * 
     Method:  getWaxProduction
     Inputs: 
     Returns: @return
     
     Description: Get the bee's ability to make wax to build the hive
     */
    @Override
    public int getWaxProduction() {
        return tempBee.getWaxProduction() + 1;
    }
    
    /**
     * 
     Method: getRole
     Inputs: 
     Returns: @return
     
     Description: Get the bee's role such as queen, worker, drone or spawner
     */
    @Override
    public BeeRole getRole() {
        return BeeRole.WORKER;
    } 
    
    public String toString() {
        
        String beeAttributes = (getType() + " " + 
                getRole() + " " +
                "Gentleness: " + getGentleness() + " " +
                "Honey Production: " + getHoneyProduction() + " " + 
                "Pollination: " + getPollination() + " " +
                "Reproduction: " + getReproduction() + " " +
                "Wax Production: " + getWaxProduction() + " "
                );
        
        return beeAttributes;
    }
    
}