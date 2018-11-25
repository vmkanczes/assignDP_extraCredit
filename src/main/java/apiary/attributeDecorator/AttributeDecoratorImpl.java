package main.java.apiary.attributeDecorator;

import main.java.apiary.builder.BeeType;
/**
 * 
Class:  AttributeDecoratorImpl

Description: This class allows creation of different bees with different attributes
 */
abstract class AttributeDecoratorImpl implements IBee{
    
    protected IBee tempBee;
   
    /*
     * Constructor to be able to create a new bee with different attribute levels
     */
    public AttributeDecoratorImpl(IBee newBee) {
        tempBee = newBee;
    }
    
    @Override
    /**
     * 
     Method:  getGentleness
     Inputs: 
     Returns: @return  int bee's level of gentleness
     
     Description: Get the bee's friendliness
     */
    public int getGentleness() {
        return tempBee.getGentleness();
    }

    @Override
    /**
     * 
     Method:  getHoneyProduction
     Inputs: 
     Returns: @return int bee's level of honey production
     
     Description:  Get the bee's ability to produce honey.
     */
    public int getHoneyProduction() {
        return tempBee.getHoneyProduction();
    }

    @Override
    /**
     * 
     Method: getPollination
     Inputs: 
     Returns: @return int 
     
     Description:  Get the bee's ability to pollinate flowers
     */
    public int getPollination() {
        return tempBee.getPollination();

    }

    @Override
    /**
     * 
     Method:  getReproduction
     Inputs: 
     Returns: @return
     
     Description:  Get the bee's ability to help make baby bees
     */
    public int getReproduction() {
        return tempBee.getReproduction();
    }

    @Override
    /**
     * 
     Method:  getWaxProduction
     Inputs: 
     Returns: @return
     
     Description: Get the bee's ability to make wax to build the hive
     */
    public int getWaxProduction() {
        return tempBee.getWaxProduction();
    }

    @Override
    /**
     * 
     Method: getRole
     Inputs: 
     Returns: @return
     
     Description: Get the bee's role such as queen, worker, drone or spawner
     */
    public BeeRole getRole() {
        return tempBee.getRole();
    }

    @Override
    /**
     * 
     Method: getType
     Inputs: 
     Returns: @return enum BeeType
     
     Description:  Gets the type of bee
     */
    public BeeType getType() {
        return tempBee.getType();
    }

}
