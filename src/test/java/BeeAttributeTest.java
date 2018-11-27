/**
File: BeeAttributeTest.java
Author: @author
Date: Nov 24, 2018

Description: Test the bee attributes created using decorator design pattern
 */

package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import main.java.apiary.builder.BeeType;
import main.java.apiary.decorator.AverageBeeImpl;
import main.java.apiary.decorator.BeeRole;
import main.java.apiary.decorator.BuckfastQueenBee;
import main.java.apiary.decorator.BuckfastWorkerBee;
import main.java.apiary.decorator.CarniolanQueenBee;
import main.java.apiary.decorator.CarniolanWorkerBee;
import main.java.apiary.decorator.CaucasianQueenBee;
import main.java.apiary.decorator.CaucasianWorkerBee;
import main.java.apiary.decorator.GermanQueenBee;
import main.java.apiary.decorator.GermanWorkerBee;
import main.java.apiary.decorator.IBee;
import main.java.apiary.decorator.ItalianQueenBee;
import main.java.apiary.decorator.ItalianWorkerBee;
import main.java.apiary.decorator.RussianQueenBee;
import main.java.apiary.decorator.RussianWorkerBee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Class: BeeAttributeTest
 * 
 * <p>Description: This call will verify each bee types is created with correct
 * role and attributes.
 */
public class BeeAttributeTest {

    private IBee regularBee;
    private IBee germanWorkerBee;
    private IBee italianWorkerBee;
    private IBee buckfastWorkerBee;
    private IBee carniolanWorkerBee;
    private IBee russianWorkerBee;
    private IBee caucasianWorkerBee;
    private IBee germanQueenBee;
    private IBee italianQueenBee;
    private IBee buckfastQueenBee;
    private IBee carniolanQueenBee;
    private IBee russianQueenBee;
    private IBee caucasianQueenBee;
    
    

    /**
     * Method: setUp.
     * Inputs: 
     * Returns: 
     * @throws java.lang.Exception
     * 
     Description: Setups up the call by creating all of the bees with their different attributes.
     */
    @Before public void setUp() throws Exception {
        // create bees to verify their role, type and attributes are correct
        regularBee = new AverageBeeImpl(BeeType.REGULAR);
        germanWorkerBee = new GermanWorkerBee(new AverageBeeImpl(BeeType.GERMAN));
        italianWorkerBee = new ItalianWorkerBee(new AverageBeeImpl(BeeType.ITALIAN));
        buckfastWorkerBee = new BuckfastWorkerBee(new AverageBeeImpl(BeeType.BUCKFAST));
        carniolanWorkerBee = new CarniolanWorkerBee(new AverageBeeImpl(BeeType.CARNIOLAN));
        russianWorkerBee = new RussianWorkerBee(new AverageBeeImpl(BeeType.RUSSIAN));
        caucasianWorkerBee = new CaucasianWorkerBee(new AverageBeeImpl(BeeType.CAUCASIAN));
        germanQueenBee = new GermanQueenBee(new AverageBeeImpl(BeeType.GERMAN));
        italianQueenBee = new ItalianQueenBee(new AverageBeeImpl(BeeType.ITALIAN));
        buckfastQueenBee = new BuckfastQueenBee(new AverageBeeImpl(BeeType.BUCKFAST));
        carniolanQueenBee = new CarniolanQueenBee(new AverageBeeImpl(BeeType.CARNIOLAN));
        russianQueenBee = new RussianQueenBee(new AverageBeeImpl(BeeType.RUSSIAN));
        caucasianQueenBee = new CaucasianQueenBee(new AverageBeeImpl(BeeType.CAUCASIAN));
        
        
    }

    /**
     * Method: Inputs: Returns: @throws java.lang.Exception
     * 
     * <p>Description: Removes all of the bee objects
     */
    @After public void tearDown() throws Exception {
        regularBee = null;
        germanWorkerBee = null;
        italianWorkerBee = null;
        buckfastWorkerBee = null;
        carniolanWorkerBee = null;
        russianWorkerBee = null;
        caucasianWorkerBee = null;

    }

    /**
     * Method: germanWorkerBeeTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void germanWorkerBeeTest() {

        assertTrue("Gentleness is incorrect", 2 == germanWorkerBee.getGentleness());
        assertTrue("Honey production is incorrect", 5 == germanWorkerBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 2 == germanWorkerBee.getPollination());
        assertTrue("Reproduction is incorrect", 1 == germanWorkerBee.getReproduction());
        assertTrue("Wax production is incorrect", 3 == germanWorkerBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.GERMAN, germanWorkerBee.getType()));
        assertTrue(Objects.equals(BeeRole.WORKER, germanWorkerBee.getRole()));

    }

    /**
     * Method: italianWorkerBeeTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void italianWorkerBeeTest() {

        assertTrue("Gentleness is incorrect", 3 == italianWorkerBee.getGentleness());
        assertTrue("Honey production is incorrect", 5 == italianWorkerBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 3 == italianWorkerBee.getPollination());
        assertTrue("Reproduction is incorrect", 2 == italianWorkerBee.getReproduction());
        assertTrue("Wax production is incorrect", 1 == italianWorkerBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.ITALIAN, italianWorkerBee.getType()));
        assertTrue(Objects.equals(BeeRole.WORKER, italianWorkerBee.getRole()));

    }

    /**
     * Method: carniolanWorkerBeeTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void carniolanWorkerBeeTest() {

        assertTrue("Gentleness is incorrect", 4 == carniolanWorkerBee.getGentleness());
        assertTrue("Honey production is incorrect", 5 == carniolanWorkerBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 4 == carniolanWorkerBee.getPollination());
        assertTrue("Reproduction is incorrect", 3 == carniolanWorkerBee.getReproduction());
        assertTrue("Wax production is incorrect", 1 == carniolanWorkerBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.CARNIOLAN, carniolanWorkerBee.getType()));
        assertTrue(Objects.equals(BeeRole.WORKER, carniolanWorkerBee.getRole()));

    }

    /**
     * Method: buckfastWorkerBeeTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void buckfastWorkerBeeTest() {

        assertTrue("Gentleness is incorrect", 2 == buckfastWorkerBee.getGentleness());
        assertTrue("Honey production is incorrect", 3 == buckfastWorkerBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 3 == buckfastWorkerBee.getPollination());
        assertTrue("Reproduction is incorrect", 1 == buckfastWorkerBee.getReproduction());
        assertTrue("Wax production is incorrect", 1 == buckfastWorkerBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.BUCKFAST, buckfastWorkerBee.getType()));
        assertTrue(Objects.equals(BeeRole.WORKER, buckfastWorkerBee.getRole()));

    }

    /**
     * Method: russianWorkerBeeTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void russianWorkerBeeTest() {

        assertTrue("Gentleness is incorrect", 2 == russianWorkerBee.getGentleness());
        assertTrue("Honey production is incorrect", 1 == russianWorkerBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 3 == russianWorkerBee.getPollination());
        assertTrue("Reproduction is incorrect", 1 == russianWorkerBee.getReproduction());
        assertTrue("Wax production is incorrect", 3 == russianWorkerBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.RUSSIAN, russianWorkerBee.getType()));
        assertTrue(Objects.equals(BeeRole.WORKER, russianWorkerBee.getRole()));

    }

    /**
     * Method: caucasianWorkerBeeTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void caucasianWorkerBeeTest() {

        assertTrue("Gentleness is incorrect", 5 == caucasianWorkerBee.getGentleness());
        assertTrue("Honey production is incorrect", 2 == caucasianWorkerBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 4 == caucasianWorkerBee.getPollination());
        assertTrue("Reproduction is incorrect", 4 == caucasianWorkerBee.getReproduction());
        assertTrue("Wax production is incorrect", 4 == caucasianWorkerBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.CAUCASIAN, caucasianWorkerBee.getType()));
        assertTrue(Objects.equals(BeeRole.WORKER, caucasianWorkerBee.getRole()));

    }

    /**
     * Method: averageBeeTest Inputs: Returns:
     * 
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void averageBeeTest() {

        assertTrue("Gentleness is incorrect", 3 == regularBee.getGentleness());
        assertTrue("Honey production is incorrect", 3 == regularBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 3 == regularBee.getPollination());
        assertTrue("Reproduction is incorrect", 3 == regularBee.getReproduction());
        assertTrue("Wax production is incorrect", 3 == regularBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.REGULAR, regularBee.getType()));
        assertTrue(Objects.equals(BeeRole.REGULAR, regularBee.getRole()));

    }
    
    /**
     * Method: germanQueenBeeTest Inputs: Returns:
     *
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void germanQueenBeeTest() {

        assertTrue("Gentleness is incorrect", 2 == germanQueenBee.getGentleness());
        assertTrue("Honey production is incorrect", 0 == germanQueenBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 0 == germanQueenBee.getPollination());
        assertTrue("Reproduction is incorrect", 5 == germanQueenBee.getReproduction());
        assertTrue("Wax production is incorrect", 0 == germanQueenBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.GERMAN, germanQueenBee.getType()));
        assertTrue(Objects.equals(BeeRole.QUEEN, germanQueenBee.getRole()));

    }

    /**
     * Method: italianQueenBeeTest Inputs: Returns:
     *
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void italianQueenBeeTest() {

        assertTrue("Gentleness is incorrect", 2 == italianQueenBee.getGentleness());
        assertTrue("Honey production is incorrect", 0 == italianQueenBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 0 == italianQueenBee.getPollination());
        assertTrue("Reproduction is incorrect", 5 == italianQueenBee.getReproduction());
        assertTrue("Wax production is incorrect", 0 == italianQueenBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.ITALIAN, italianQueenBee.getType()));
        assertTrue(Objects.equals(BeeRole.QUEEN, italianQueenBee.getRole()));

    }
    
    /**
     * Method: carniolanQueenBeeTest Inputs: Returns:
     *
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void carniolanQueenBeeTest() {

        assertTrue("Gentleness is incorrect", 3 == carniolanQueenBee.getGentleness());
        assertTrue("Honey production is incorrect", 0 == carniolanQueenBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 0 == carniolanQueenBee.getPollination());
        assertTrue("Reproduction is incorrect", 5 == carniolanQueenBee.getReproduction());
        assertTrue("Wax production is incorrect", 0 == carniolanQueenBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.CARNIOLAN, carniolanQueenBee.getType()));
        assertTrue(Objects.equals(BeeRole.QUEEN, carniolanQueenBee.getRole()));

    }

    /**
     * Method: buckfastQueenBeeTest Inputs: Returns:
     *
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void buckfastQueenBeeTest() {

        assertTrue("Gentleness is incorrect", 1 == buckfastQueenBee.getGentleness());
        assertTrue("Honey production is incorrect", 0 == buckfastQueenBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 0 == buckfastQueenBee.getPollination());
        assertTrue("Reproduction is incorrect", 3 == buckfastQueenBee.getReproduction());
        assertTrue("Wax production is incorrect", 0 == buckfastQueenBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.BUCKFAST, buckfastQueenBee.getType()));
        assertTrue(Objects.equals(BeeRole.QUEEN, buckfastQueenBee.getRole()));

    }
    
    /**
     * Method: russianQueenBeeTest Inputs: Returns:
     *
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void russianQueenBeeTest() {

        assertTrue("Gentleness is incorrect", 1 == russianQueenBee.getGentleness());
        assertTrue("Honey production is incorrect", 0 == russianQueenBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 0 == russianQueenBee.getPollination());
        assertTrue("Reproduction is incorrect", 1 == russianQueenBee.getReproduction());
        assertTrue("Wax production is incorrect", 0 == russianQueenBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.RUSSIAN, russianQueenBee.getType()));
        assertTrue(Objects.equals(BeeRole.QUEEN, russianQueenBee.getRole()));

    }

    /**
     * Method: caucasianQueenBeeTest Inputs: Returns:
     *
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void caucasianQueenBeeTest() {

        assertTrue("Gentleness is incorrect", 5 == caucasianQueenBee.getGentleness());
        assertTrue("Honey production is incorrect", 0 == caucasianQueenBee.getHoneyProduction());
        assertTrue("Pollination is incorrect", 0 == caucasianQueenBee.getPollination());
        assertTrue("Reproduction is incorrect", 2 == caucasianQueenBee.getReproduction());
        assertTrue("Wax production is incorrect", 0 == caucasianQueenBee.getWaxProduction());
        assertTrue(Objects.equals(BeeType.CAUCASIAN, caucasianQueenBee.getType()));
        assertTrue(Objects.equals(BeeRole.QUEEN, caucasianQueenBee.getRole()));

    }
    
    /**
     * Method: toStringTest
     * Inputs: Returns:
     *
     * <p>Description: Check each attribute, role and type.
     */
    @Test public void toStringTest() {

        String testString = "REGULAR REGULAR Gentleness: 3 Honey Production: 3 "
                + "Pollination: 3 Reproduction: 3 Wax Production: 3 ";

        assertEquals(testString, regularBee.toString());

        testString = "GERMAN WORKER Gentleness: 2 Honey Production: 5 "
                + "Pollination: 2 Reproduction: 1 Wax Production: 3 ";
        assertEquals(testString, germanWorkerBee.toString());

        testString = "GERMAN QUEEN Gentleness: 2 Honey Production: 0 "
                + "Pollination: 0 Reproduction: 5 Wax Production: 0 ";
        assertEquals(testString, germanQueenBee.toString());

        testString = "ITALIAN WORKER Gentleness: 3 Honey Production: 5 "
                + "Pollination: 3 Reproduction: 2 Wax Production: 1 ";
        assertEquals(testString, italianWorkerBee.toString());

        testString = "ITALIAN QUEEN Gentleness: 2 Honey Production: 0 "
                + "Pollination: 0 Reproduction: 5 Wax Production: 0 ";
        assertEquals(testString, italianQueenBee.toString());

        testString = "BUCKFAST WORKER Gentleness: 2 Honey Production: 3 "
                + "Pollination: 3 Reproduction: 1 Wax Production: 1 ";
        assertEquals(testString, buckfastWorkerBee.toString());

        testString = "BUCKFAST QUEEN Gentleness: 1 Honey Production: 0 "
                + "Pollination: 0 Reproduction: 3 Wax Production: 0 ";
        assertEquals(testString, buckfastQueenBee.toString());

        testString = "CARNIOLAN WORKER Gentleness: 4 Honey Production: 5 "
                + "Pollination: 4 Reproduction: 3 Wax Production: 1 ";
        assertEquals(testString, carniolanWorkerBee.toString());

        testString = "CARNIOLAN QUEEN Gentleness: 3 Honey Production: 0 "
                + "Pollination: 0 Reproduction: 5 Wax Production: 0 ";
        assertEquals(testString, carniolanQueenBee.toString());

        testString = "RUSSIAN WORKER Gentleness: 2 Honey Production: 1 "
                + "Pollination: 3 Reproduction: 1 Wax Production: 3 ";
        assertEquals(testString, russianWorkerBee.toString());

        testString = "RUSSIAN QUEEN Gentleness: 1 Honey Production: 0 "
                + "Pollination: 0 Reproduction: 1 Wax Production: 0 ";
        assertEquals(testString, russianQueenBee.toString());

        testString = "CAUCASIAN WORKER Gentleness: 5 Honey Production: 2 "
                + "Pollination: 4 Reproduction: 4 Wax Production: 4 ";
        assertEquals(testString, caucasianWorkerBee.toString());

        testString = "CAUCASIAN QUEEN Gentleness: 5 Honey Production: 0 "
                + "Pollination: 0 Reproduction: 2 Wax Production: 0 ";
        assertEquals(testString, caucasianQueenBee.toString());
       
    }
    

}
