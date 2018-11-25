package beeAttributeDecorator;
/**
File: IBee.java
Author: vkanczes
Date: Nov 23, 2018

Description: Interface for the bee attributes, type, and role
 */
import builder.BeeType;

/**
Class: IBee

Description: Bee interface with all the necessary attributes, role, and type
 */
public interface IBee  {
    
    /**
     * 
     Method: getType
     Inputs: 
     Returns: @return enum BeeType
     
     Description:  Gets the type of bee
     */
    public BeeType getType();
    
    /**
     * 
     Method:  getGentleness
     Inputs: 
     Returns: @return  int bee's level of gentleness
     
     Description: Get the bee's friendliness
     */
    public int getGentleness();
    
    /**
     * 
     Method:  getHoneyProduction
     Inputs: 
     Returns: @return int bee's level of honey production
     
     Description:  Get the bee's ability to produce honey.
     */
    public int getHoneyProduction();
    
    /**
     * 
     Method: getPollination
     Inputs: 
     Returns: @return int 
     
     Description:  Get the bee's ability to pollinate flowers
     */
    public int getPollination();
    
    /**
     * 
     Method:  getReproduction
     Inputs: 
     Returns: @return
     
     Description:  Get the bee's ability to help make baby bees
     */
    public int getReproduction();
    
    /**
     * 
     Method:  getWaxProduction
     Inputs: 
     Returns: @return
     
     Description: Get the bee's ability to make wax to build the hive
     */
    public int getWaxProduction();
    
    /**
     * 
     Method: getRole
     Inputs: 
     Returns: @return
     
     Description: Get the bee's role such as queen, worker, drone or spawner
     */
    public BeeRole getRole();
    
    
    
    
    
}