//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.alex.tools.clientCacheUpdater;

import com.alex.store.Archive;
import com.alex.store.ArchiveReference;
import com.alex.store.Index;
import com.alex.store.Store;
import java.io.IOException;
import java.util.Random;

public class ArchiveValidation {
    public ArchiveValidation() {
    }

    public static void main(String[] args) throws IOException {
        Store rscache = new Store("data/cache/");

        for(int i = 0; i < rscache.getIndexes().length; ++i) {
            if (i != 5) {
                Index index = rscache.getIndexes()[i];
                System.out.println("checking index: " + i);
                int[] var7;
                int var6 = (var7 = index.getTable().getValidArchiveIds()).length;

                for(int var5 = 0; var5 < var6; ++var5) {
                    int archiveId = var7[var5];
                    Archive archive = index.getArchive(archiveId);
                    if (archive == null) {
                        System.out.println("Missing:: " + i + ", " + archiveId);
                    } else {
                        ArchiveReference reference = index.getTable().getArchives()[archiveId];
                        if (archive.getRevision() != reference.getRevision()) {
                            System.out.println("corrupted: " + i + ", " + archiveId);
                        }
                    }
                }
            }
        }

    }

    public static int[] generateKeys() {
        int[] keys = new int[4];

        for(int index = 0; index < keys.length; ++index) {
            keys[index] = (new Random()).nextInt();
        }

        return keys;
    }
}
