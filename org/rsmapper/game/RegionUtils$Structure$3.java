//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

class RegionUtils$Structure$3 implements RegionUtils.StructureEncoder {
    RegionUtils$Structure$3() {
    }

    public int encode(int x, int y, int plane) {
        return x << 8 | y | plane << 16;
    }
}
