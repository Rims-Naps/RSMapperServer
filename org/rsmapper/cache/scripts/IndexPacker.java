//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.cache.scripts;

import com.alex.store.Store;

public class IndexPacker {
    private static final Store matrix718 = new Store("C:/Users/Maria/Desktop/Runescape Private Servers/projects/Who Cares 667/ScapeSoft 667/data/cache/", true);
    private static final Store ours = new Store("C:/Users/Maria/ScapeSoft_Cachev3.0/runescape/", false);
    private static final int INDEX = 8;

    public IndexPacker() {
    }

    public static void main(String[] args) {
        System.out.println(ours.getIndexes()[8].packIndex(matrix718));
    }
}
