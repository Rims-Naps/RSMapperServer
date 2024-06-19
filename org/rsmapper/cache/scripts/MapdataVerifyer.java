//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.cache.scripts;

import com.alex.store.Store;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class MapdataVerifyer {
    private static final HashMap<Integer, int[]> keys = new HashMap();

    public MapdataVerifyer() {
    }

    public static void main(String[] args) throws IOException {
        Store newMaps = new Store("./data/alotic/");
        loadUnpackedKeys("./data/map/containersXteas/output 667/");
        int regionId = 9515;
        Iterator var4 = keys.keySet().iterator();

        while(var4.hasNext()) {
            int i = (Integer)var4.next();
            if (!verifyMaps(newMaps, i, getKeys(i))) {
                System.out.println("Missing map: " + i);
            }
        }

        System.out.println(verifyMaps(newMaps, regionId, getKeys(regionId)));
    }

    public static boolean verifyMaps(Store maps, int regionId, int[] keys) {
        int regionX = (regionId >> 8) * 64;
        int regionY = (regionId & 255) * 64;
        int landArchiveId = maps.getIndexes()[5].getArchiveId("l" + (regionX >> 3) / 8 + "_" + (regionY >> 3) / 8);
        byte[] landContainerData = maps.getIndexes()[5].getFile(landArchiveId, 0, keys);
        return (landContainerData != null || landArchiveId == -1) && (keys != null || landContainerData != null);
    }

    public static boolean packOldMap(Store oldMaps, Store newMaps, int regionId, int[] oldKeys) {
        int regionX = (regionId >> 8) * 64;
        int regionY = (regionId & 255) * 64;
        int landArchiveId = oldMaps.getIndexes()[5].getArchiveId("l" + (regionX >> 3) / 8 + "_" + (regionY >> 3) / 8);
        byte[] landContainerData = oldMaps.getIndexes()[5].getFile(landArchiveId, 0, oldKeys);
        landArchiveId = newMaps.getIndexes()[5].getArchiveId("l" + (regionX >> 3) / 8 + "_" + (regionY >> 3) / 8);
        return newMaps.getIndexes()[5].putFile(landArchiveId, 0, landContainerData);
    }

    public static int[] getKeys(int regionId) {
        return (int[])keys.get(regionId);
    }

    public static final void loadUnpackedKeys(String xteaPath) {
        try {
            File unpacked = new File(xteaPath);
            File[] xteasFiles = unpacked.listFiles();
            File[] var6 = xteasFiles;
            int var5 = xteasFiles.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                File region = var6[var4];
                String name = region.getName();
                if (!name.contains(".txt")) {
                    region.delete();
                } else {
                    int regionId = Short.parseShort(name.replace(".txt", ""));
                    if (regionId <= 0) {
                        region.delete();
                    } else {
                        BufferedReader in = new BufferedReader(new FileReader(region));
                        int[] xteas = new int[4];

                        for(int index = 0; index < 4; ++index) {
                            xteas[index] = Integer.parseInt(in.readLine());
                        }

                        keys.put(Integer.valueOf(regionId), xteas);
                        in.close();
                    }
                }
            }
        } catch (IOException var12) {
            IOException e = var12;
            e.printStackTrace();
        }

    }
}
