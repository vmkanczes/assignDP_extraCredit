/**
File: AllTests.java

Author: @author
Date: Nov 24, 2018

Description: This file contains all of the tests for the bee application
 */

package test.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Class:
 * 
 * <p>Description: This will run each test of the bee application.
 */
@RunWith(Suite.class) @SuiteClasses({
    HiveBuilderTest.class, BeeAttributeTest.class, 
    RoomBuilderTest.class, ApiarySingletonTest.class,
    EggMediatorTest.class}) public class AllTests {

}
