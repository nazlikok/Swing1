package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class CountChars {
    private final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public CountResult countInFile(String fileName) throws IOException {
        CountResult countResult = new CountResult();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        readLines(br, countResult);
        return countResult;
    }

    public void readLines(BufferedReader reader, CountResult countResult) throws IOException {
        String line;
        int vowelCount=0;
        int consonantsCount=0;
        while ((line = reader.readLine()) != null) {
            char [] chars = line.toCharArray();
            vowelCount= vowelCount+countVowels(chars);
            consonantsCount = consonantsCount + countConsonants(chars);
        }
        countResult.vowelsCount = vowelCount;
        countResult.consonantsCount = consonantsCount;
    }

    private int countConsonants(char[] chars) {
        int result = 0;
        for (int i = 0; i <chars.length; i++) {
            char temp =  chars[i];
            if(!vowels.contains(temp) && Character.isLetter(temp)){
                result++;
            }
        }
        return result;
    }

    private int countVowels(char[] chars) {

        int result = 0;
        for (int i = 0; i <chars.length; i++) {
            char temp =  chars[i];
            if(vowels.contains(temp)){
                result++;
            }
        }
        return result;
    }

}

