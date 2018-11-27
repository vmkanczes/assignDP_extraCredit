package main.java.apiary.decorator;

/**
File: IBee.java
Author: @author
Date: Nov 24, 2018

Description: Bee interface for bee attributes.  
*/

import main.java.apiary.builder.BeeType;

/**
Class: IBee

Description: Bee interface with all the necessary attributes, role, and type.
 */
public interface IBee  {
    
    /**
     Method: getType
     Inputs: 
     Returns: enum BeeType
     
     Description:  Gets the type of bee.
     */
    public BeeType getType();
    
    /**
     Method:  getGentleness
     Inputs: 
     Returns: int bee's level of gentleness
     
     Description: Get the bee's friendliness.
     */
    public int getGentleness();
    
    /**
     Method:  getHoneyProduction
     Inputs: 
     Returns: int bee's level of honey production
     
     Description:  Get the bee's ability to produce honey.
     */
    public int getHoneyProduction();
    
    /**
     Method: getPollination
     Inputs: 
     Returns: int 
     
     Description:  Get the bee's ability to pollinate flowers.
     */
    public int getPollination();
    
    /**
     Method:  getReproduction
     Inputs: 
     Returns: 
     
     Description:  Get the bee's ability to help make baby bees.
     */
    public int getReproduction();
    
    /**
     Method:  getWaxProduction
     Inputs: 
     Returns: 
     
     Description: Get the bee's ability to make wax to build the hive.
     */
    public int getWaxProduction();
    
    /**
     Method: getRole
     Inputs: 
     Returns: 
     
     Description: Get the bee's role such as queen, worker, drone or spawner.
     */
    public BeeRole getRole();

    /**
     Method: setType
     Inputs: 
     Returns: 
     
     Description: 
     */
    public void setType(BeeType beeType);

    public void laidEggs(IBee bee, int reproduction); 
    
}
