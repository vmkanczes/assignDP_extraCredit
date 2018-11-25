package main.java.apiary.attributeDecorator;
import main.java.apiary.builder.BeeType;

/**
Class: BuckfastWorkerBee

Description: This class is to create an Buckfast bee with specific attributes.
 */
public class BuckfastWorkerBee extends AttributeDecoratorImpl {
    
    /**
     * @param newBee
     */
    public BuckfastWorkerBee(IBee newBee) {
        super(newBee);
        
    }

    /**
     Method: getType
     Inputs: 
     Returns: enum BeeType
     
     Description:  Gets the type of bee.
     */
    @Override
    public BeeType getType() {
        return BeeType.BUCKFAST;
    }
    
    /**
     Method:  getGentleness
     Inputs: 
     Returns: int bee's level of gentleness
     
     Description: Get the bee's friendliness.
     */
    @Override
    public int getGentleness() {
        return tempBee.getGentleness() - 1;
    }
    
    /**
     Method:  getHoneyProduction
     Inputs: 
     Returns: int bee's level of honey production
     
     Description:  Get the bee's ability to produce honey.
     */
    @Override
    public int getHoneyProduction() {
        return tempBee.getHoneyProduction();
    }
    
    /**
     Method: getPollination
     Inputs: 
     Returns: 
     
     Description:  Get the bee's ability to pollinate flowers.
     */
    @Override
    public int getPollination() {
        return tempBee.getPollination();

    }
    
    /**
     Method:  getReproduction
     Inputs: 
     Returns: int 
     
     Description:  Get the bee's ability to help make baby bees.
     */
    @Override
    public int getReproduction() {
        return tempBee.getReproduction() - 1;
    }
    
    /**
     Method:  getWaxProduction
     Inputs: 
     Returns: 
     
     Description: Get the bee's ability to make wax to build the hive.
     */
    @Override
    public int getWaxProduction() {
        return tempBee.getWaxProduction() -2;
    }
    
    /**
     Method: getRole
     Inputs: 
     Returns: 
     
     Description: Get the bee's role such as queen, worker, drone or spawner.
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