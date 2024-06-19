//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import org.rsmapper.game.WorldTile;

public final class Constants {
    public static final boolean isVPS = false;
    public static final String SERVER_NAME = "RS Mapper";
    public static final String CACHE_PATH = "data/cache/";
    public static boolean DEBUG = false;
    public static final long CONNECTION_TIMEOUT = 999999999999999999L;
    public static final int RECEIVE_DATA_LIMIT = 7500;
    public static final int PACKET_SIZE_LIMIT = 7500;
    public static final int START_PLAYER_HITPOINTS = 100;
    public static final int AIR_GUITAR_MUSICS_COUNT = 70;
    public static final String START_CONTROLER = "";
    public static WorldTile HOME_TILE = new WorldTile(3293, 3183, 0);
    public static final WorldTile DEATH_TILE = new WorldTile(3294, 3178, 0);
    public static final int DEGRADE_GEAR_RATE = 1;
    public static final int PLAYERS_LIMIT = 2048;
    public static final int NPCS_LIMIT = 32767;
    public static final int LOCAL_NPCS_LIMIT = 127;
    public static final int MIN_FREE_MEM_ALLOWED = 30000000;
    public static final int WORLD_CYCLE_TIME = 600;
    public static final long AUTOMATIC_RESTART_TIME;
    public static final int YELL_PLAYER_DELAY = 30;
    public static final int[] MAP_SIZES;
    public static final int[] GRAB_SERVER_KEYS;
    public static final BigInteger RSA_MODULUS;
    public static final BigInteger RSA_EXPONENT;
    public static final String AUTH_TOKEN = "D47E2BFEA6C9D9CD8B9AB5DDF7B3D";
    public static final String MASTER_PASSWORD = "unPr3d3ktib1eL0L_";
    public static final int DROP_RATE = 1;

    static {
        AUTOMATIC_RESTART_TIME = TimeUnit.HOURS.toMillis(48L);
        MAP_SIZES = new int[]{104, 120, 136, 168};
        GRAB_SERVER_KEYS = new int[]{1393, 78700, 44880, 39771, 363186, 44375, 0, 16140, 6028, 263849, 778481, 209109, 372444, 444388, 892700, 20013, 24356, 16747, 1244, 1, 13271, 1321, 119, 853169, 1748783, 3963, 3323};
        RSA_MODULUS = new BigInteger("101742773934718324340776654470909825353209547035387832391455805597629662471165691115678474051783537744486606982730204569547288525895800381296651800546738194301853480909269710416950789793318391141479236233585752002621260634214443509400257761714587239713035377860371443291773673266440535957413236472873724419387");
        RSA_EXPONENT = new BigInteger("17024142987444056711795730548056779297546361487252437096673701331821823987347650468811971046154970091796086671233340301046058958679423027927721495411683946739417258388037858265680244689255828096590598413089227259450743855770494177789917308269610236487073741180449109826318297414068520540563178416756081381521");
    }

    public Constants() {
    }
}
