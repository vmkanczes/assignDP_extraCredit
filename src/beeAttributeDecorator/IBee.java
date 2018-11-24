package beeAttributeDecorator;

import builder.BeeType;

public interface IBee  {
      
    public BeeType getType();
    public AttributeRange getGentleness();
    public AttributeRange getHoneyProduction();
    public AttributeRange getPollination();
    public AttributeRange getReproduction();
    public AttributeRange getWaxProduction();
    public BeeRole getRole();
    
    
    
    
    
}