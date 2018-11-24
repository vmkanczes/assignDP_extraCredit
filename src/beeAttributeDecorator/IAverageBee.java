package beeAttributeDecorator;

import builder.BeeType;

public class IAverageBee implements IBee {

    @Override
    public AttributeRange getGentleness() {
        return AttributeRange.LOW;
    }

    @Override
    public AttributeRange getHoneyProduction() {
        return AttributeRange.AVERAGE;
    }

    @Override
    public AttributeRange getPollination() {
        return AttributeRange.LOW;

    }

    @Override
    public AttributeRange getReproduction() {
        return AttributeRange.NONE;
    }

    @Override
    public AttributeRange getWaxProduction() {
        return AttributeRange.AVERAGE;
    }

    @Override
    public BeeRole getRole() {
        return BeeRole.WORKER;
    }

    @Override
    public BeeType getType() {
        return BeeType.GERMAN;
    }

}
