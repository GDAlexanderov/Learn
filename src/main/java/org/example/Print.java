package org.example;

public class Print {
    public void print(int a) {
        System.out.println(a);
    }
    public void print(String a) {
        System.out.println(a);
    }
    public void print(int[] a) {
        for (int v : a)
            System.out.print(v+" ");
    }
    public void print(String[] a) {
        for (String v : a)
            System.out.print(v+" ");
    }
}
