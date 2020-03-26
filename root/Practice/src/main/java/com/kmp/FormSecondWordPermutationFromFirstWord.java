package com.kmp;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;

public class FormSecondWordPermutationFromFirstWord {
    static String input1="abcaadf", input2 = "bafc";

    public static void main(String args[]){
        System.out.println(canSecondWordFormedFromFirtWord(input1,input2));
    }
    static boolean canSecondWordFormedFromFirtWord(String input1, String input2){
        boolean flag = false;
        if(input1.length()<input2.length()){
            return false;
        }
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i<input1.length();i++){
            char c = input1.charAt(i);
            String key = String.valueOf(c);
            if(null != map1.get(key)){
                map1.put(key,map1.get(key)+1);
            }else{
                map1.put(key,1);
            }
        }

        for(int j = 0; j<input2.length();j++){
            char c = input2.charAt(j);
            String key = String.valueOf(c);
            if(null != map2.get(key)){
                map2.put(key,map2.get(key)+1);
            }else{
                map2.put(key,1);
            }
        }

        for(String key:map2.keySet()){
            if(null != map1.get(key)){
                if(map2.get(key)<=map1.get(key)){
                    flag = true;
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }else{
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }
        return false;
    }
}
