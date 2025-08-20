package org.example;

class Solution2 {
    public static String longestCommonPrefix(String[] strs) {
        String result="";
        for(int i=0; i<strs[0].length(); i++){
            String curr=strs[0].substring(0,i+1);
            boolean flag=true;
            for(int j=1; j<strs.length; j++){
                if(!strs[j].startsWith(curr)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                result=curr;
            }
        }
        return result;
    }
}
