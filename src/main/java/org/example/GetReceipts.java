package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class GetReceipts {
    public double GetReceipt() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\receipt.txt"));
        double result = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(";");
            result += Double.parseDouble(parts[1])*Double.parseDouble(parts[2]);
        }
        return result;
    }
    public int GetCountWords() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\text.txt"));
        int count = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            count += parts.length;
        }
        return count;
    }
    public int GetMul() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\data.txt"));
        int res = 1;
        int mul = sc.nextInt();
        sc.nextLine();
        int cnt=0;
        String[] del = sc.nextLine().split(" ");

        for (int i = 1; i < mul; i++) {
            for(int j = 0; j < del.length; j++) {
                if(i%(Integer.parseInt(del[j]))==0) {
                    cnt = i;
                }else{
                    cnt=0;
                    break;
                }
            }
            res *= cnt;
            cnt=0;
        }
        return res;
    }
    public void writeOrder() throws IOException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\numbers.txt"));
        int cur = 0;
        do{
            int ints = Integer.parseInt(sc.nextLine());
            cur+=1;
            if(ints==cur){
                FileOutputStream fos = new FileOutputStream("output.txt");
                fos.write(ints);
            }
        }while (sc.hasNextLine());
    }
    public boolean arePalindromes() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\strings.txt"));
        boolean result = true;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().toLowerCase();
            line.replace(" ","");
            for (int i = 0; i < (line.length()%2==0? line.length()/2:line.length()/2-1); i++) {
                if (line.charAt(i) != line.charAt(line.length()-i-1)) {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }
}
