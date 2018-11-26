/**
File: EggMediatorTest.java
Author: @author
Date: Nov 24, 2018

Description: Test the bee attributes created using decorator design pattern
 */

package test.java;

import main.java.apiary.builder.BeeType;
import main.java.apiary.decorator.AverageBeeImpl;
import main.java.apiary.decorator.GermanQueenBee;
import main.java.apiary.decorator.IBee;
import main.java.apiary.decorator.ItalianWorkerBee;
import main.java.apiary.mediator.EggMediatorImpl;
import main.java.apiary.mediator.Queen;
import main.java.apiary.mediator.Worker;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Class: EggMediatorTest
 * 
 * <p>Description: Verifies the bee objects can talk with one another to take care of eggs.
 */
public class EggMediatorTest {

    private EggMediatorImpl nature;
    private Queen queenBee;
    private Worker workerBee;
    private IBee italianWorkerBee;
    private IBee germanQueenBee;

    /**
     * Method: setUp.
     * Inputs: 
     * Returns: 
     * @throws java.lang.Exception
     * 
     Description: Setups up the mediators
     */
    @Before public void setUp() throws Exception {
        nature = new EggMediatorImpl();
        queenBee = new Queen(nature);
        workerBee = new Worker(nature);
        italianWorkerBee = new ItalianWorkerBee(new AverageBeeImpl());
        germanQueenBee = new GermanQueenBee(new AverageBeeImpl());     
    }

    /**
     * Method: Inputs: Returns: @throws java.lang.Exception
     * 
     * <p>Description: Removes all of the bee objects
     */
    @After public void tearDown() throws Exception {
        queenBee = null;
        workerBee = null;
    }

    /**
     * Method: laidEggsTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void laidEggsTest() {

        // lay eggs
        queenBee.laidEggs(BeeType.GERMAN, germanQueenBee.getReproduction());
              
        Assert.assertThat(nature.getEggStatus().toString(), 
                CoreMatchers.containsString("Hungry eggs 5 of type GERMAN"));         
    }
    
    /**
     * Method: feedEggsTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void feedEggsTest() {

        // feed eggs
        workerBee.feedEggs(BeeType.ITALIAN, italianWorkerBee.getHoneyProduction());       
        Assert.assertThat(nature.getEggStatus().toString(), 
                CoreMatchers.containsString("Pollinated bees 5 of type ITALIAN"));         
    }
}
