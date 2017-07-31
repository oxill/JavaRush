package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        FileInputStream fis = new FileInputStream(args[0]);
        while (fis.available() > 0) {
            int data = fis.read();
            if ((data >= 65 && data <= 90) || (data >= 97 && data <= 122))
                count++;
        }
        fis.close();
        System.out.println(count);
    }
}