package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));

        while (reader1.ready()) {
            String s = reader1.readLine();
            String[] ss = s.split(" ");
            if (ss[0].equals(args[0]))
                System.out.println(s);
        }
        reader.close();
        reader1.close();
    }
}
