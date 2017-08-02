package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    private static String s;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s = reader.readLine();
        while (!s.equals("exit")) {
            System.out.println("into while");
            ReadThread readThread = new ReadThread(s);
            readThread.start();
            s = reader.readLine();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                Map<Byte, Integer> map = new HashMap<>();
                FileInputStream stream = new FileInputStream(fileName);

                byte[] buffer = new byte[stream.available()];
                stream.read(buffer);
                for (byte b: buffer) {
                    if (map.containsKey(b))
                        map.put(b, map.get(b) + 1);
                    else map.put(b, 1);
                }
                int maxCount = map.entrySet().iterator().next().getValue();
                byte maxByte = map.entrySet().iterator().next().getKey();
                for (Map.Entry<Byte, Integer> entry: map.entrySet()) {
                    if (maxCount < entry.getValue()) {
                        maxCount = entry.getValue();
                        maxByte = entry.getKey();
                    }
                }
                resultMap.put(fileName, (int) maxByte);
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
