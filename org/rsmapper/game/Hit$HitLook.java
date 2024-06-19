//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

public enum Hit$HitLook {
    MISSED(8),
    REGULAR_DAMAGE(3),
    MELEE_DAMAGE(0),
    RANGE_DAMAGE(1),
    MAGIC_DAMAGE(2),
    REFLECTED_DAMAGE(4),
    ABSORB_DAMAGE(5),
    POISON_DAMAGE(6),
    DESEASE_DAMAGE(7),
    HEALED_DAMAGE(9),
    CANNON_DAMAGE(13);

    private int mark;

    private Hit$HitLook(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return this.mark;
    }
}
