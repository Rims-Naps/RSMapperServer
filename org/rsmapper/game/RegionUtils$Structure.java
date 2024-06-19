//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import org.rsmapper.utilities.misc.Utils;

public enum RegionUtils$Structure {
    TILE((RegionUtils$Structure)null, 1, 1, new RegionUtils.StructureEncoder() {
        public int encode(int x, int y, int plane) {
            return y | x << 14 | plane << 28;
        }
    }),
    CHUNK(TILE, 8, 8, new RegionUtils.StructureEncoder() {
        public int encode(int x, int y, int plane) {
            return x << 14 | y << 3 | plane << 24;
        }
    }),
    REGION(CHUNK, 8, 8, new RegionUtils.StructureEncoder() {
        public int encode(int x, int y, int plane) {
            return x << 8 | y | plane << 16;
        }
    }),
    MAP(REGION, 255, 255);

    private RegionUtils$Structure child;
    private int width;
    private int height;
    private RegionUtils.StructureEncoder encoder;

    private RegionUtils$Structure(RegionUtils$Structure child, int width, int height, RegionUtils.StructureEncoder encode) {
        this.child = child;
        this.width = width;
        this.height = height;
        this.encoder = encode;
    }

    private RegionUtils$Structure(RegionUtils$Structure child, int width, int height) {
        this(child, width, height, (RegionUtils.StructureEncoder)null);
    }

    public int getWidth() {
        int x = this.width;

        for(RegionUtils$Structure nextChild = this.child; nextChild != null; nextChild = nextChild.child) {
            x *= nextChild.width;
        }

        return x;
    }

    public int getChildWidth() {
        return this.width;
    }

    public int getHeight() {
        int y = this.height;

        for(RegionUtils$Structure nextChild = this.child; nextChild != null; nextChild = nextChild.child) {
            y *= nextChild.height;
        }

        return y;
    }

    public int encode(int x, int y) {
        return this.encode(x, y, 0);
    }

    public int encode(int x, int y, int plane) {
        return this.encoder == null ? -1 : this.encoder.encode(x, y, plane);
    }

    public int getChildHeight() {
        return this.width;
    }

    public String toString() {
        return Utils.formatPlayerNameForDisplay(this.name());
    }
}
