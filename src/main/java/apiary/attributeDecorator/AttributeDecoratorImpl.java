package main.java.apiary.attributeDecorator;

import main.java.apiary.builder.BeeType;

/**
Class:  AttributeDecoratorImpl

Description: This class allows creation of different bees with different attributes.
 */
abstract class AttributeDecoratorImpl implements IBee {
    
    protected IBee tempBee;
   
    /*
     * Constructor to be able to create a new bee with different attribute levels
     */
    public AttributeDecoratorImpl(IBee newBee) {
        tempBee = newBee;
    }
    
    /**
     Method:  getGentleness
     Inputs: 
     Returns: int bee's level of gentleness
     
     Description: Get the bee's friendliness.
     */
    @Override public int getGentleness() {
        return tempBee.getGentleness();
    }

    /**
     Method:  getHoneyProduction
     Inputs: 
     Returns: int bee's level of honey production
     
     Description:  Get the bee's ability to produce honey.
     */
    @Override public int getHoneyProduction() {
        return tempBee.getHoneyProduction();
    }

    /**
     Method: getPollination
     Inputs: 
     Returns: int 
     
     Description:  Get the bee's ability to pollinate flowers.
     */
    @Override public int getPollination() {
        return tempBee.getPollination();

    }

    /**
     Method:  getReproduction
     Inputs: 
     Returns: 
     
     Description:  Get the bee's ability to help make baby bees.
     */
    @Override public int getReproduction() {
        return tempBee.getReproduction();
    }

    /**
     Method:  getWaxProduction
     Inputs: 
     Returns: 
     
     Description: Get the bee's ability to make wax to build the hive.
     */
    @Override public int getWaxProduction() {
        return tempBee.getWaxProduction();
    }

    /**
     Method: getRole
     Inputs: 
     Returns: 
     
     Description: Get the bee's role such as queen, worker, drone or spawner.
     */
    @Override public BeeRole getRole() {
        return tempBee.getRole();
    }

    /**
     Method: getType
     Inputs: 
     Returns: enum BeeType
     
     Description:  Gets the type of bee.
     */
    @Override public BeeType getType() {
        return tempBee.getType();
    }

}
