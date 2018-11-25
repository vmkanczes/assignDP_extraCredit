/**
File: HiveBuilderTest.java
Author: @author
Date: Nov 24, 2018

Description: 
 */
package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import builder.BeeType;
import builder.Hive;
import singletonDP.Apiary;

/**
Class:  HiveBuilderTest

Description:  Verifies all hives are created for the correct type and the count is valid
 */
public class HiveBuilderTest {

        private Hive buckfastHive;
        private Hive germanHive;
        private Hive italianHive;
        private Hive russianHive;
        private Hive carniolanHive;
        private Hive caucasianHive;

        /**
         Method:
         Inputs: 
         Returns: @throws java.lang.Exception
         
         Description: 
         */
        @Before
        public void setUp() throws Exception {
            // create bee hives to verify their role, type and attributes are correct
            buckfastHive = Apiary.getInstance().buildHive(BeeType.BUCKFAST);
            italianHive = Apiary.getInstance().buildHive(BeeType.ITALIAN);
            russianHive = Apiary.getInstance().buildHive(BeeType.RUSSIAN);
            germanHive = Apiary.getInstance().buildHive(BeeType.GERMAN);
            caucasianHive = Apiary.getInstance().buildHive(BeeType.CAUCASIAN);
            carniolanHive = Apiary.getInstance().buildHive(BeeType.CARNIOLAN);
            
        }
        
        /**
        Method:
        Inputs: 
        Returns: @throws java.lang.Exception
        
        Description: 
        */
       @After
       public void tearDown() throws Exception {
           // remove hive mappings
           Apiary.getInstance().removeHives(BeeType.CAUCASIAN);
           Apiary.getInstance().removeHives(BeeType.ITALIAN);
           Apiary.getInstance().removeHives(BeeType.GERMAN);
           Apiary.getInstance().removeHives(BeeType.RUSSIAN);
           Apiary.getInstance().removeHives(BeeType.CARNIOLAN);
           Apiary.getInstance().removeHives(BeeType.BUCKFAST);
           
           // remove hive objects
           buckfastHive = null;
           italianHive = null;
           russianHive = null;
           germanHive = null;
           caucasianHive = null;
           carniolanHive = null;

       }
    /**
     * 
     Method: buckFastHiveTest
     Inputs: 
     Returns: 
     
     Description:  Verifies that the hive was created for the correct bee type
     */
    @Test public void buckFastHiveTest() {
        
        String testHive = "BUCKFAST";
        
            assertTrue(testHive.equals(buckfastHive.toString()));
            
    }
    
    /**
     * 
     Method: russianHiveTest
     Inputs: 
     Returns: 
     
     Description:  Verifies that the hive was created for the correct bee type
     */
    @Test public void russianHiveTest() {
        
        String testHive = "RUSSIAN";
        
            assertTrue(testHive.equals(russianHive.toString()));
            

    }
    
    /**
     * 
     Method: caucasianHiveTest
     Inputs: 
     Returns: 
     
     Description:  Verifies that the hive was created for the correct bee type
     */
    @Test public void caucasianHiveTest() {
        
            String testHive = "CAUCASIAN";
        
            assertTrue(testHive.equals(caucasianHive.toString()));

    }
    
    /**
     * 
     Method: carniolanHiveTest
     Inputs: 
     Returns: 
     
     Description:  Verifies that the hive was created for the correct bee type
     */
    @Test public void carniolanHiveTest() {
        
            String testHive = "CARNIOLAN";
        
            assertTrue(testHive.equals(carniolanHive.toString()));
            


    }
    
    /**
     * 
     Method: germanHiveTest
     Inputs: 
     Returns: 
     
     Description:  Verifies that the hive was created for the correct bee type
     */
    @Test public void germanHiveTest() {
        
            String testHive = "GERMAN";
        
            assertTrue(testHive.equals(germanHive.toString()));
            


    }
    
    /**
     * 
     Method: italianHiveTest
     Inputs: 
     Returns: 
     
     Description:  Verifies that the hive was created for the correct bee type
     */
    @Test public void italianHiveTest() {
        
            String testHive = "ITALIAN";
        
            assertTrue(testHive.equals(italianHive.toString()));
            
    }
    
    /**
     * 
     Method: hiveCountTest
     Inputs: 
     Returns: 
     
     Description:  Verifies that the hive was not created for a bee type that does not exist
     */
    @Test public void hiveCountTest() {

        System.out.println(Apiary.getInstance().toString());

            int testHiveCount = 6;
            assertTrue("Hive count is incorrect", testHiveCount == Apiary.getInstance().getHiveCount());
    }
    
    /**
     * 
     Method: hiveCountTest
     Inputs: 
     Returns: 
     
     Description:  Verifies that the hive was not created for a bee type that does not exist
     */
    @Test public void removeHiveTest() {

            int testHiveCount = 5;
            Apiary.getInstance().removeHives(BeeType.BUCKFAST);
            assertTrue("Hive count is incorrect", testHiveCount == Apiary.getInstance().getHiveCount());

    }

}
