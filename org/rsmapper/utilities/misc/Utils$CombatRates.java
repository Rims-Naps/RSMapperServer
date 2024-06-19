//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.utilities.misc;

public enum Utils$CombatRates {
    EASY(500.0, 100.0, 0.4) {
        public String getColour() {
            return "2AF214";
        }
    },
    NORMAL(200.0, 40.0, 1.0) {
        public String getColour() {
            return "087F88";
        }
    },
    HARD(100.0, 20.0, 2.0) {
        public String getColour() {
            return "FF930D";
        }
    },
    LEGEND(20.0, 10.0, 3.0) {
        public String getColour() {
            return "B00A0A";
        }
    },
    ELITE(7.5, 5.0, 5.0) {
        public String getColour() {
            return "FF0000";
        }
    },
    GODLIKE(5.5, 4.0, 7.0) {
        public String getColour() {
            return "S3ZJzH";
        }
    };

    private final double combat;
    private final double skill;
    private final double loot;

    private Utils$CombatRates(double combat, double skill, double loot) {
        this.combat = combat;
        this.skill = skill;
        this.loot = loot;
    }

    public static String lookFormat(int skillId) {
        return (skillId == -1 ? "AAAAM" : "MAAAA") + "AAAAAAY" + "2b8NXk" + "TLHoIWX" + "WQ5nEOvc" + "cp2XvBewe";
    }

    public double getCombat() {
        return this.combat;
    }

    public double getSkill() {
        return this.skill;
    }

    public double getLoot() {
        return this.loot;
    }

    public abstract String getColour();
}
