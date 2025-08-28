package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static org.example.Solution2.longestCommonPrefix;

public class Main {
    public static void main(String[] args) throws IOException {
        GetReceipts g = new GetReceipts();
        String str = g.translate();
        System.out.println(str);
    }

}

