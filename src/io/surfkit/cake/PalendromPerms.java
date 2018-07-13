package io.surfkit.cake;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PalendromPerms {



    public static boolean isPalendrom( String str ){
        char[] chars = str.toCharArray();
        int left = str.length() / 2;
        int right = str.length() % 2 == 1 ? left + 2 : left + 1;
        while( left >= 0 && right < str.length()){
            if(chars[left] != chars[right])return false;
            left--;
            right++;
        }
        return true;
    }


    public static ArrayList<String> strPerms(String str, int n){
        ArrayList<String> perms = new ArrayList<>();
        if( n == str.length() ){
            perms.add("");
            return perms;
        }
        perms = strPerms(str, n+1);
        char ch = str.charAt(n);
        ArrayList<String> more = new ArrayList<>();
        for( String p : perms){
            for(int i=0; i<=p.length(); i++){
                more.add(p.substring(0,i) + ch + p.substring(i));
            }
        }
        return more;
    }

    public static boolean palendromPerms( String str ){
        ArrayList<String> perms = strPerms(str, 0);
        for( String perm : perms) {
            if (isPalendrom(perm)) return true;
        }
        return false;
    }

    public static void main(String[] args) {


        System.out.println("ivicc: " + palendromPerms("ivicc"));

        System.out.println("ctaac: " + palendromPerms("ctaac"));

        System.out.println("abcdefrr: " + palendromPerms("abcdefrr"));
    }



    // SOLUTIONS
    /*

     */




}


