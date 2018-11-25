/**
File: HiveBuilderTest.java
Author: @author
Date: Nov 24, 2018

Description: Runs all the test for the build design pattern used to build bee hives.
 */

package test.java;

import static org.junit.Assert.assertTrue;

import builder.BeeType;
import builder.Hive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import singletonDP.Apiary;


/**
 * Class: HiveBuilderTest
 * 
 * <p>Description: Verifies all hives are created for the correct type and the
 * count is valid.
 */
public class HiveBuilderTest {

    private Hive buckfastHive;
    private Hive germanHive;
    private Hive italianHive;
    private Hive russianHive;
    private Hive carniolanHive;
    private Hive caucasianHive;

    /**
     * Method: Inputs: Returns: @throws java.lang.Exception
     * 
     * <p>Description:
     */
    @Before public void setUp() throws Exception {
        // create bee hives to verify their role, type and attributes are correct
        buckfastHive = Apiary.getInstance().buildHive(BeeType.BUCKFAST);
        italianHive = Apiary.getInstance().buildHive(BeeType.ITALIAN);
        russianHive = Apiary.getInstance().buildHive(BeeType.RUSSIAN);
        germanHive = Apiary.getInstance().buildHive(BeeType.GERMAN);
        caucasianHive = Apiary.getInstance().buildHive(BeeType.CAUCASIAN);
        carniolanHive = Apiary.getInstance().buildHive(BeeType.CARNIOLAN);

    }

    /**
     * Method: Inputs: Returns: @throws java.lang.Exception
     * 
     * <p>Description:
     */
    @After
    public void tearDown() throws Exception {
        // remove hive mappings
        Apiary.getInstance().removeHives(buckfastHive);
        Apiary.getInstance().removeHives(italianHive);
        Apiary.getInstance().removeHives(germanHive);
        Apiary.getInstance().removeHives(caucasianHive);
        Apiary.getInstance().removeHives(carniolanHive);
        Apiary.getInstance().removeHives(russianHive);

        // remove hive objects
        buckfastHive = null;
        italianHive = null;
        russianHive = null;
        germanHive = null;
        caucasianHive = null;
        carniolanHive = null;

    }

    /**
     * Method: buckFastHiveTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the hive was created for the correct bee type.
     */
    @Test public void buckFastHiveTest() {

        String testHive = "BUCKFAST";

        assertTrue(testHive.equals(buckfastHive.toString()));

    }

    /**
     * Method: russianHiveTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the hive was created for the correct bee type.
     */
    @Test public void russianHiveTest() {

        String testHive = "RUSSIAN";

        assertTrue(testHive.equals(russianHive.toString()));

    }

    /**
     * Method: caucasianHiveTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the hive was created for the correct bee type.
     */
    @Test public void caucasianHiveTest() {

        String testHive = "CAUCASIAN";

        assertTrue(testHive.equals(caucasianHive.toString()));

    }

    /**
     * Method: carniolanHiveTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the hive was created for the correct bee type.
     */
    @Test public void carniolanHiveTest() {

        String testHive = "CARNIOLAN";

        assertTrue(testHive.equals(carniolanHive.toString()));

    }

    /**
     * Method: germanHiveTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the hive was created for the correct bee type.
     */
    @Test public void germanHiveTest() {

        String testHive = "GERMAN";

        assertTrue(testHive.equals(germanHive.toString()));

    }

    /**
     * Method: italianHiveTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the hive was created for the correct bee type.
     */
    @Test public void italianHiveTest() {

        String testHive = "ITALIAN";

        assertTrue(testHive.equals(italianHive.toString()));

    }

    /**
     * Method: hiveCountTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the hive was not created for a bee type that does
     * not exist.
     */
    @Test public void hiveCountTest() {

        System.out.println(Apiary.getInstance().toString());

        int testHiveCount = 6;
        assertTrue("Hive count is incorrect", testHiveCount == Apiary.getInstance().getHiveCount());
    }

    /**
     * Method: hiveCountTest 
     * Inputs: 
     * Returns:
     * 
     * <p>Description: Verifies that the hive was not created for a bee type that does
     * not exist.
     */
    @Test public void removeHiveTest() { 
        int testHiveCount = 5;
        Apiary.getInstance().removeHives(buckfastHive);
        assertTrue("Hive count is incorrect", testHiveCount == Apiary.getInstance().getHiveCount());

    }

}
