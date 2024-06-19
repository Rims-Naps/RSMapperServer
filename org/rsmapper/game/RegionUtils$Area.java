//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

public final class RegionUtils$Area {
    private RegionUtils.Structure structure;
    private int x;
    private int y;
    private int width;
    private int height;

    public RegionUtils$Area(RegionUtils.Structure structure, int x, int y, int width, int height) {
        this.structure = structure;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getMapX() {
        return this.x * this.structure.getWidth();
    }

    public int getMapY() {
        return this.y * this.structure.getHeight();
    }

    public int getMapWidth() {
        return this.width * this.structure.getWidth();
    }

    public int getMapHeight() {
        return this.height * this.structure.getHeight();
    }

    public RegionUtils.Structure getStructure() {
        return this.structure;
    }

    public int hashCode() {
        return this.structure.encode(this.x, this.y, 0);
    }

    public String toString() {
        return "Structure: " + this.structure.toString() + ", x: " + this.x + ", y: " + this.y + ", width: " + this.width + ", height: " + this.height;
    }
}
