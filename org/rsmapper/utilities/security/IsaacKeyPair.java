//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.utilities.security;

public class IsaacKeyPair {
    private ISAACCipher inKey;
    private ISAACCipher outKey;

    public IsaacKeyPair(int[] seed) {
        this.inKey = new ISAACCipher(seed);

        for(int i = 0; i < seed.length; ++i) {
            seed[i] += 50;
        }

        this.outKey = new ISAACCipher(seed);
    }

    public ISAACCipher inKey() {
        return this.inKey;
    }

    public ISAACCipher outKey() {
        return this.outKey;
    }
}
