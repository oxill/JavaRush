package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        Map<Byte, Integer> map = new TreeMap<>();


        byte[] buffer = new byte[fis.available()];

        while (fis.available() > 0)
            fis.read(buffer);

        for (byte b :
                buffer) {
            if (map.containsKey(b))
                map.put(b, map.get(b) + 1);
            else map.put(b, 1);
        }

        fis.close();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            System.out.println((char)((byte)(entry.getKey())) + " " + entry.getValue());
        }
    }
}
