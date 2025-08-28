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
    public void solution() throws IOException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\data.txt"));
        String[] strs= new String[50];
        File file = new File("output.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter("C:\\Users\\user\\Documents\\GitHub\\Learn\\output.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        int difmed = Integer.parseInt(sc.nextLine());
        int medium = 0;
        int cnt = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            strs[cnt] = line;
            medium+=line.length();
            cnt+=1;
        }
        bw.write(Integer.toString(difmed+medium/3));
        for(String str : strs){
            if(!(str==null)){
                if((medium/3-difmed)<= str.length() && str.length()<=(medium/3+difmed)){
                    bw.newLine();
                    bw.write(str);
                }
            }
        }
        bw.close();
        sc.close();
    }
    public void dance() throws IOException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\dance.txt"));
        File file = new File("rhythm.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        int movements = Integer.parseInt(sc.nextLine());
        while(sc.hasNextLine()){
            int line = Integer.parseInt(sc.nextLine());
            String str = String.valueOf(line/movements)+" "+String.valueOf(line%movements);
            bw.write(str);
            bw.newLine();
        }
        bw.close();
        sc.close();
    }
    public void EGE(double passed) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\EGE.txt"));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(";");
            if(Double.parseDouble(line[2])>=passed){
                System.out.println(line[0]);
            }
        }
    }
    public void findSquare() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\points.txt"));
        String[] parts = sc.nextLine().split(" ");
        int[] previous = new int[parts.length];
        double square=0;
        for (int i = 0; i < parts.length; i++) {
            previous[i] = Integer.parseInt(parts[i]);
        }
        int[] curr;
        while (sc.hasNextLine()) {
            String[] currparts = sc.nextLine().split(" ");
            curr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                curr[i] = Integer.parseInt(currparts[i]);
            }
            if(curr[1]>previous[1]){
                square+=((Math.sqrt(Math.pow(curr[0]-previous[0],2)+Math.pow(curr[1]-previous[1],2))+(curr[0]-previous[0]))*(curr[1]-previous[1]))/2;
            }else{
                square+=((Math.sqrt(Math.pow(curr[0]-previous[0],2)+Math.pow(previous[1]-curr[1],2))+(curr[0]-previous[0]))*(previous[1]-curr[1]))/2;
            }
        }
        System.out.println(square);
    }
    public void solve() throws IOException {
        Scanner sc=new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\arithmetic.txt"));
        File file = new File("answer.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        while(sc.hasNextLine()){
            String lines = sc.nextLine();
            String[] line = lines.split(" ");
            String answer = lines;
            switch (line[1].charAt(0)){
                case '-':
                    answer +=" = "+String.valueOf(Integer.parseInt(line[0])-Integer.parseInt(line[2]));
                    bw.write(answer);
                    bw.newLine();
                    continue;
                case '+':
                    answer +=" = "+String.valueOf(Integer.parseInt(line[0])+Integer.parseInt(line[2]));
                    bw.write(answer);
                    bw.newLine();
                    continue;
                case '/':
                    answer +=" = "+String.valueOf(Integer.parseInt(line[0])/Integer.parseInt(line[2]));
                    bw.write(answer);
                    bw.newLine();
                    continue;
                case '*':
                    answer +=" = "+String.valueOf(Integer.parseInt(line[0])*Integer.parseInt(line[2]));
                    bw.write(answer);
                    bw.newLine();
                    continue;
            }
        }
        bw.close();
        sc.close();
    }
    public String translate() throws FileNotFoundException {
        Scanner sc=new Scanner(new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\Learn\\message.txt"));
        StringBuilder ans= new StringBuilder();
        String[] binLetters = "1000001;1000010;1000011;1000100;1000101;1000110;1000111;1001000;1001001;1001010;1001011;1001100;1001101;1001110;1001111;1010000;1010001;1010010;1010011;1010100;1010101;1010110;1010111;1011000;1011001;1011010".split(";");
        String englishLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str = sc.nextLine();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int idx = englishLetters.indexOf(c);
            if (idx != -1) { // если это буква A-Z
                ans.append(binLetters[idx]);
            }else{
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
