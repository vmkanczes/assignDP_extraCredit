/**
File: RoomBuilderTest.java
Author: @author
Date: Nov 24, 2018

Description: 
 */

package test.java;

import static org.junit.Assert.assertTrue;

import builder.BeeType;
import builder.Hive;
import builder.RoomType;

import org.junit.Test;

import singletonDP.Apiary;

/**
 * Class: RoomBuilderTest
 * 
 * <p>Description: Verifies all room are created for the correct hive and count is
 * correct.
 */
public class RoomBuilderTest {

    private Hive italianHive;
    private Hive buckfastHive;
    private Hive germanHive;

    /**
     * Method: apiaryRoomCountTest Inputs: Returns:
     * 
     * <p>Description: Verifies that every room was created for the apiary.
     */
    @Test public void apiaryRoomCountTest() {

        italianHive = Apiary.getInstance().buildHive(BeeType.ITALIAN);
        italianHive.roomBuilder(RoomType.BROOD, italianHive.getType());
        italianHive.roomBuilder(RoomType.REST, italianHive.getType());

        int testRoomCount = 8;
        System.out.println(Apiary.getInstance().toString());

        assertTrue("Room count is incorrect", testRoomCount == Apiary.getInstance().getRoomCount());

    }

    /**
     * Method: restRoomCountForHiveTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the correct number of rest rooms were created for
     * the correct hive.
     */
    @Test public void restRoomCountForHiveTest() {

        buckfastHive = Apiary.getInstance().buildHive(BeeType.BUCKFAST);
        buckfastHive.roomBuilder(RoomType.REST, buckfastHive.getType());
        buckfastHive.roomBuilder(RoomType.REST, buckfastHive.getType());
        buckfastHive.roomBuilder(RoomType.REST, buckfastHive.getType());

        int testCount = 3;
        assertTrue("Room count is incorrect", testCount == buckfastHive.getRestRoomCount());

    }

    /**
     * Method: broodRoomCountForHiveTest Inputs: Returns:
     * 
     * <p>Description: Verifies that the correct number of brood rooms were created for
     * the correct hive.
     */
    @Test public void broodRoomCountForHiveTest() {

        germanHive = Apiary.getInstance().buildHive(BeeType.GERMAN);
        germanHive.roomBuilder(RoomType.BROOD, germanHive.getType());
        germanHive.roomBuilder(RoomType.BROOD, germanHive.getType());
        germanHive.roomBuilder(RoomType.BROOD, germanHive.getType());
        
        int testCount = 3;

        assertTrue("Room count is incorrect", testCount == germanHive.getBroodRoomCount());

    }

}
