//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.utilities.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileUtilities {
    public static final int BUFFER = 1024;

    public FileUtilities() {
    }

    public static boolean exists(String name) {
        File file = new File(name);
        return file.exists();
    }

    public static ByteBuffer fileBuffer(String name) throws IOException {
        File file = new File(name);
        if (!file.exists()) {
            return null;
        } else {
            FileInputStream in = new FileInputStream(name);
            byte[] data = new byte[1024];

            try {
                ByteBuffer buffer = ByteBuffer.allocate(in.available() + 1);

                int read;
                while((read = in.read(data, 0, 1024)) != -1) {
                    buffer.put(data, 0, read);
                }

                buffer.flip();
                ByteBuffer var7 = buffer;
                return var7;
            } finally {
                if (in != null) {
                    in.close();
                }

                in = null;
            }
        }
    }

    public static void writeBufferToFile(String name, ByteBuffer buffer) throws IOException {
        File file = new File(name);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(name);
        out.write(buffer.array(), 0, buffer.remaining());
        out.flush();
        out.close();
    }

    public static List<String> getFileText(String file) {
        List<String> text = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while(true) {
                String line;
                do {
                    do {
                        do {
                            if ((line = reader.readLine()) == null) {
                                reader.close();
                                return text;
                            }
                        } while(line.equals(""));
                    } while(line.equals(" "));
                } while(line.length() >= 2 && line.toCharArray()[0] == '/' && line.toCharArray()[1] == '/');

                text.add(line);
            }
        } catch (Exception var4) {
            Exception e = var4;
            e.printStackTrace();
            return text;
        }
    }

    public static ArrayList<String> getPageSource(String page) throws IOException {
        ArrayList<String> text = new ArrayList();
        URL url = new URL(page);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla Firefox");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        InputStream input;
        if (connection.getResponseCode() >= 400) {
            input = connection.getErrorStream();
        } else {
            input = connection.getInputStream();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String line;
        while((line = reader.readLine()) != null) {
            text.add(line);
        }

        reader.close();
        return text;
    }

    public static LinkedList<String> readFile(String directory) throws IOException {
        LinkedList<String> fileLines = new LinkedList();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(directory));

            String string;
            while((string = reader.readLine()) != null) {
                fileLines.add(string);
            }
        } finally {
            if (reader != null) {
                reader.close();
                reader = null;
            }

        }

        return fileLines;
    }
}
