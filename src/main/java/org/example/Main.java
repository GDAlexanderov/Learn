package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.Solution2.longestCommonPrefix;

public class Main {
    public static void main(String[] args) {
        String[] prefix = {"flower","flow","flowight"};
        System.out.println(longestCommonPrefix(prefix));
        System.out.println("Перемога");
    }
}

