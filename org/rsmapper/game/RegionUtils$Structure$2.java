//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

class RegionUtils$Structure$2 implements RegionUtils.StructureEncoder {
    RegionUtils$Structure$2() {
    }

    public int encode(int x, int y, int plane) {
        return x << 14 | y << 3 | plane << 24;
    }
}
