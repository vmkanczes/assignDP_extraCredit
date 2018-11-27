package main.java.apiary.builder;

import main.java.apiary.decorator.GermanWorkerBee;

/**
File: GermanWorkerBeeBuilderImpl.java
Author: vkanczes
Date: Nov 26, 2018

Description: interface to build the bee with type (species) and role (queen, worker, etc).
 */

public class GermanWorkerBeeBuilderImpl implements IBeeBuilder {

    private Bee bee;

    public GermanWorkerBeeBuilderImpl() {
        this.bee = new Bee();
    }

    @Override public Bee buildBee() {
        bee.setBee();
        return bee;
    }

    @Override public IBeeBuilder setBee(final GermanWorkerBee bee) {
        bee.setBee(bee);
        return this;
    }

    /**
     Method:
     Inputs: 
     Returns: 
     
     Description: 
     */
    @Override
    public Bee getBee() {
        return this.bee;
    }

}