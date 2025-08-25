package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static org.example.Solution2.longestCommonPrefix;

public class Main {
    public static void main(String[] args) {
        CoolPrinter.add("Own, two,");
        CoolPrinter.add("I love you.");
        CoolPrinter.add("Three, four,");
        CoolPrinter.add("Touch the floor.");
        CoolPrinter.print(new Formatter() {
            @Override
            public String format(String line) {
                return "** "+line+" **";
            }
        });

    }
}

