/**
File: ApriarySingletonTest.java
Author: @author
Date: Nov 24, 2018

Description: 
 */

package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import main.java.apiary.singleton.Apiary;

import org.junit.Test;

/**
 * Class: ApiarySingletonTest
 * 
 * <p>Description: This is a singleton class that creates the apiary to hold all of
 * the hives.
 */
public class ApiarySingletonTest {

    @Test public void singletonTest() {

        Apiary myApiary = Apiary.getInstance();
        Apiary testApiary = Apiary.getInstance();

        assertEquals(testApiary, myApiary);
        assertSame(testApiary, myApiary);

    }

}
