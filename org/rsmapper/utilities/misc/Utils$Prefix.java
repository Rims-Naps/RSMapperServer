//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.utilities.misc;

enum Utils$Prefix {
    NONE(-2147483648L, ""),
    THOUSAND(100000L, "K"),
    MILLION(1000000L, "M"),
    BILLION(1000000000L, "B"),
    TRILLION(1000000000000L, "T");

    private final long minimum;
    private final String symbol;

    private Utils$Prefix(long minimum, String symbol) {
        this.minimum = minimum;
        this.symbol = symbol;
    }
}
