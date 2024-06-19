//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.utilities.security;

public class ISAACCipher {
    public static final int RATIO = -1640531527;
    public static final int SIZE_LOG = 8;
    public static final int SIZE = 256;
    public static final int MASK = 1020;
    private int count = 0;
    private int[] results = new int[256];
    private int[] memory = new int[256];
    private int a;
    private int b;
    private int c;

    public ISAACCipher(int[] seed) {
        for(int i = 0; i < seed.length; ++i) {
            this.results[i] = seed[i];
        }

        this.init(true);
    }

    public int getNextValue() {
        return 0;
    }

    public void isaac() {
        this.b += ++this.c;
        int i = 0;

        int j;
        int x;
        int y;
        for(j = 128; i < 128; this.results[i++] = this.b = this.memory[(y >> 8 & 1020) >> 2] + x) {
            x = this.memory[i];
            this.a ^= this.a << 13;
            this.a += this.memory[j++];
            this.memory[i] = y = this.memory[(x & 1020) >> 2] + this.a + this.b;
            this.results[i++] = this.b = this.memory[(y >> 8 & 1020) >> 2] + x;
            x = this.memory[i];
            this.a ^= this.a >>> 6;
            this.a += this.memory[j++];
            this.memory[i] = y = this.memory[(x & 1020) >> 2] + this.a + this.b;
            this.results[i++] = this.b = this.memory[(y >> 8 & 1020) >> 2] + x;
            x = this.memory[i];
            this.a ^= this.a << 2;
            this.a += this.memory[j++];
            this.memory[i] = y = this.memory[(x & 1020) >> 2] + this.a + this.b;
            this.results[i++] = this.b = this.memory[(y >> 8 & 1020) >> 2] + x;
            x = this.memory[i];
            this.a ^= this.a >>> 16;
            this.a += this.memory[j++];
            this.memory[i] = y = this.memory[(x & 1020) >> 2] + this.a + this.b;
        }

        for(j = 0; j < 128; this.results[i++] = this.b = this.memory[(y >> 8 & 1020) >> 2] + x) {
            x = this.memory[i];
            this.a ^= this.a << 13;
            this.a += this.memory[j++];
            this.memory[i] = y = this.memory[(x & 1020) >> 2] + this.a + this.b;
            this.results[i++] = this.b = this.memory[(y >> 8 & 1020) >> 2] + x;
            x = this.memory[i];
            this.a ^= this.a >>> 6;
            this.a += this.memory[j++];
            this.memory[i] = y = this.memory[(x & 1020) >> 2] + this.a + this.b;
            this.results[i++] = this.b = this.memory[(y >> 8 & 1020) >> 2] + x;
            x = this.memory[i];
            this.a ^= this.a << 2;
            this.a += this.memory[j++];
            this.memory[i] = y = this.memory[(x & 1020) >> 2] + this.a + this.b;
            this.results[i++] = this.b = this.memory[(y >> 8 & 1020) >> 2] + x;
            x = this.memory[i];
            this.a ^= this.a >>> 16;
            this.a += this.memory[j++];
            this.memory[i] = y = this.memory[(x & 1020) >> 2] + this.a + this.b;
        }

    }

    public void init(boolean flag) {
        int h = -1640531527;
        int g = -1640531527;
        int f = -1640531527;
        int e = -1640531527;
        int d = -1640531527;
        int c = -1640531527;
        int b = -1640531527;
        int a = -1640531527;

        int i;
        for(i = 0; i < 4; ++i) {
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            e += b;
            c += d;
            c ^= d << 8;
            f += c;
            d += e;
            d ^= e >>> 16;
            g += d;
            e += f;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            a += f;
            g += h;
            g ^= h << 8;
            b += g;
            h += a;
            h ^= a >>> 9;
            c += h;
            a += b;
        }

        for(i = 0; i < 256; i += 8) {
            if (flag) {
                a += this.results[i];
                b += this.results[i + 1];
                c += this.results[i + 2];
                d += this.results[i + 3];
                e += this.results[i + 4];
                f += this.results[i + 5];
                g += this.results[i + 6];
                h += this.results[i + 7];
            }

            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            e += b;
            c += d;
            c ^= d << 8;
            f += c;
            d += e;
            d ^= e >>> 16;
            g += d;
            e += f;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            a += f;
            g += h;
            g ^= h << 8;
            b += g;
            h += a;
            h ^= a >>> 9;
            c += h;
            a += b;
            this.memory[i] = a;
            this.memory[i + 1] = b;
            this.memory[i + 2] = c;
            this.memory[i + 3] = d;
            this.memory[i + 4] = e;
            this.memory[i + 5] = f;
            this.memory[i + 6] = g;
            this.memory[i + 7] = h;
        }

        if (flag) {
            for(i = 0; i < 256; i += 8) {
                a += this.memory[i];
                b += this.memory[i + 1];
                c += this.memory[i + 2];
                d += this.memory[i + 3];
                e += this.memory[i + 4];
                f += this.memory[i + 5];
                g += this.memory[i + 6];
                h += this.memory[i + 7];
                a ^= b << 11;
                d += a;
                b += c;
                b ^= c >>> 2;
                e += b;
                c += d;
                c ^= d << 8;
                f += c;
                d += e;
                d ^= e >>> 16;
                g += d;
                e += f;
                e ^= f << 10;
                h += e;
                f += g;
                f ^= g >>> 4;
                a += f;
                g += h;
                g ^= h << 8;
                b += g;
                h += a;
                h ^= a >>> 9;
                c += h;
                a += b;
                this.memory[i] = a;
                this.memory[i + 1] = b;
                this.memory[i + 2] = c;
                this.memory[i + 3] = d;
                this.memory[i + 4] = e;
                this.memory[i + 5] = f;
                this.memory[i + 6] = g;
                this.memory[i + 7] = h;
            }
        }

        this.isaac();
        this.count = 256;
    }
}
