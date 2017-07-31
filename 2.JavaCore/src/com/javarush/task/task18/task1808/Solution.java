package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);
        FileOutputStream outputStream1 = new FileOutputStream(fileName3);

        int fileSize, halfSize;
        fileSize = inputStream.available();
        if (fileSize % 2 == 0)
            halfSize = fileSize / 2;
        else
            halfSize = fileSize / 2 + 1;

        while (inputStream.available() > 0) {
            byte[] buffer = new byte[halfSize];
            byte[] buffer1 = new byte[fileSize - halfSize];
            inputStream.read(buffer);
            inputStream.read(buffer1);
            outputStream.write(buffer);
            outputStream1.write(buffer1);
        }

        reader.close();
        inputStream.close();
        outputStream.close();
        outputStream1.close();
    }
}