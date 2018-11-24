package beeAttributeDecorator;

import builder.BeeType;

abstract class AttributeDecoratorImpl implements IBee{
    
    protected IBee tempBee;
    
    public AttributeDecoratorImpl(IBee newBee) {
        
        tempBee = newBee;
    }
    
    @Override
    public AttributeRange getGentleness() {
        return AttributeRange.LOW;
    }

    @Override
    public AttributeRange getHoneyProduction() {
        return tempBee.getHoneyProduction();
    }

    @Override
    public AttributeRange getPollination() {
        return tempBee.getPollination();

    }

    @Override
    public AttributeRange getReproduction() {
        return tempBee.getReproduction();
    }

    @Override
    public AttributeRange getWaxProduction() {
        return tempBee.getWaxProduction();
    }

    @Override
    public BeeRole getRole() {
        return tempBee.getRole();
    }

    @Override
    public BeeType getType() {
        return tempBee.getType();
    }


}
