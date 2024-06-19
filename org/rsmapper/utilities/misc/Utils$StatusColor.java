//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.utilities.misc;

public enum Utils$StatusColor {
    TRAINED(Utils.assorted),
    UNTRAINED(Utils.unassorted);

    private final String color;

    private Utils$StatusColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
