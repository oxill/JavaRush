package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
        consoleReader.close();
        while (fileReader.ready()) {
            int count = 0;
            String line = fileReader.readLine();
            for (String word : words) {
                if (line.contains(word))
                    count++;
            }
            if (count == 2)
                System.out.println(line);
        }
        fileReader.close();
    }
}
