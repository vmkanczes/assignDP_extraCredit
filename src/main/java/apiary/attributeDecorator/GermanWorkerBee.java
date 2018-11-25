package beeAttributeDecorator;
/**
File: GermanWorkerBee.java
Author: vkanczes
Date: Nov 23, 2018

Description: The average bee so other bee attributes can be increased or decreased.
 */
import builder.BeeType;

/**
Class: GermanWorkerBee

Description: This class is to create an German ordinary bee with specific attributes
 */
public class GermanWorkerBee extends AttributeDecoratorImpl {
    
    /**
     * @param newBee
     */
    public GermanWorkerBee(IBee newBee) {
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
        return BeeType.GERMAN;
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
        return tempBee.getGentleness() -1;
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
        return tempBee.getHoneyProduction();
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
        return tempBee.getPollination() -1;

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
        return tempBee.getReproduction() -1;
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
        return tempBee.getWaxProduction();
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