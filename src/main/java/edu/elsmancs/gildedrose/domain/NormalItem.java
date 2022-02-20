package edu.elsmancs.gildedrose.domain;

public class NormalItem implements Updateable {

    /**
     * Item 18: Favor composition over inheritance.
     * Each instance method in the new class invokes 
     * the corresponding method on the contained instance 
     * of the existing class and returns the results. 
     * This is known as forwarding, and the methods in the
     * new class are known as forwarding methods.
     * Bloch, Joshua; Effective Java, Third Edition.
     */

    /** 
     * Item 17: Minimize mutability.
     * Bloch, Joshua; Effective Java, Third Edition.
     */
    private final Item item;

    public NormalItem(String name, int sell_in, int quality) {
        this.item = new Item(name, sell_in, quality);
    }

    @Override
    public String toString() {
        return item.toString();
    }

    // SRP
    Item getItem() {
        return this.item;
    }

    public String getName() {
        return item.getName();
    }

    public int getSell_in() {
        return item.getSell_in();
    }

    void setSell_in() {
        item.setSell_in();
    }

    public int getQuality() {
        return item.getQuality();
    }

    void computeQuality(int value) {

        if (getQuality() + value > 50) {
            item.setQuality(50);
        }
        else if (getQuality() + value >= 0) {
            item.setQuality(getQuality() + value);
        }
        else {
            item.setQuality(0);
        }
    }

    @Override
    public void updateQuality() {

        if (getSell_in() > 0) {
            computeQuality(-1);
        } else {
            computeQuality(-2);
        }
        setSell_in();
    }
}