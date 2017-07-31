package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);
        FileOutputStream fos = new FileOutputStream(file1);
        byte[] buffer1 = new byte[fis1.available()];
        byte[] buffer2 = new byte[fis2.available()];
        while (fis1.available() > 0)
            fis1.read(buffer1);
        while (fis2.available() > 0)
            fis2.read(buffer2);
        fos.write(buffer2);
        fos.write(buffer1);

        reader.close();
        fis1.close();
        fis2.close();
        fos.close();
    }
}