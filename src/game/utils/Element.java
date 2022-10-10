package game.utils;

public enum Element {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),

    // REQ1: Evolution
    // Dragon-type
    DRAGON("Dragon");

    private final String label;

    Element(String label){
        this.label = label;
    }

    /**
     *
     * @return the label text
     */
    @Override
    public String toString() {
        return label;
    }
}
