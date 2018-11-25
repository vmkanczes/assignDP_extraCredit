/**
File: ApriarySingletonTest.java
Author: @author
Date: Nov 24, 2018

Description: 
 */

package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import singletonDP.Apiary;

/**
Class:

Description:
 */
public class ApiarySingletonTest {

    @Test public void singletonTest() {
        
         Apiary myApiary = Apiary.getInstance();
         Apiary testApiary = Apiary.getInstance();
         
         assertEquals(testApiary, myApiary);
         assertSame(testApiary, myApiary);

    }

}
