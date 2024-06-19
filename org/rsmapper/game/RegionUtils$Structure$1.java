//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

class RegionUtils$Structure$1 implements RegionUtils.StructureEncoder {
    RegionUtils$Structure$1() {
    }

    public int encode(int x, int y, int plane) {
        return y | x << 14 | plane << 28;
    }
}
