package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.Element;

public class Pokefruit extends Item {
    Element element;
    /***
     * Constructor.
     */
    public Pokefruit(Element element) {
        super("Pokefruit",'f',true);
        this.element=element;
    }
}
