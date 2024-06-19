//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.utilities.misc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileClassLoader {
    public FileClassLoader() {
    }

    public static List<Object> getClassesInDirectory(String directory) {
        List<Object> classes = new ArrayList();
        File[] var5;
        int var4 = (var5 = (new File("./bin/" + directory.replace(".", "/"))).listFiles()).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            File file = var5[var3];
            if (!file.getName().contains("$") && !file.getName().contains("desktop.ini")) {
                try {
                    Object objectEvent = Class.forName(directory + "." + file.getName().replace(".class", "")).newInstance();
                    classes.add(objectEvent);
                } catch (IllegalAccessException | ClassNotFoundException | InstantiationException var7) {
                    ReflectiveOperationException e = var7;
                    e.printStackTrace();
                }
            }
        }

        return classes;
    }
}
