package main.java.apiary.builder;

/**
File: BeeBuildDirector.java
Author: vkanczes
Date: Nov 26, 2018

Description: 
 */

public class BeeBuildDirector {
    private IBeeBuilder builder;

    public BeeBuildDirector(final IBeeBuilder builder) {
        this.builder = builder;
    }

    public Bee construct() {
        return builder.buildBee();        
    }
}
