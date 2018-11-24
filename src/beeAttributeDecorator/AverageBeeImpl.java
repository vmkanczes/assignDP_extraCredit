package beeAttributeDecorator;
/**
File: IAverageBee.java
Author: vkanczes
Date: Nov 23, 2018

Description: The average bee so other bee attributes can be increased or decreased.
 */
import builder.BeeType;

/**
Class: IAverageBee

Description: This class is to create an average ordinary bee with average attributes
 */
public class AverageBeeImpl implements IBee {
    
    /**
     * 
     Method: getType
     Inputs: 
     Returns: @return enum BeeType
     
     Description:  Gets the type of bee
     */
    @Override
    public BeeType getType() {
        return BeeType.UNKNOWN;
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
        return 3;
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
        return 3;
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
        return 3;

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
        return 3;
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
        return 3;
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
        return BeeRole.UNKNOWN;
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