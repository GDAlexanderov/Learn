package org.example;

class Solution {
    String s ="IX";
    public static int romanToInt(String s) {
        int[]value={1,5,10,50,100,500,1000};
        String alph="IVXLCDM";
        int result=0;
        for(int i=0;i<s.length();i++){
            int curr = value[alph.indexOf(s.charAt(i))];
            if(i+1<s.length()){
                int next=value[alph.indexOf(s.charAt(i+1))];
                if(curr<next){
                    result-=curr;
                    continue;
                }
            }
            result+=curr;
        }
        return result;
    }
}
