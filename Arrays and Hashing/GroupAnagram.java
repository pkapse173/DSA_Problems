//Problem: Group Anagram
/*
 * INPUT: ["eat","tea","tan","ate","nat","bat"]
 *       
 * OUTPUT: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
/*
 * Approach 1 - Brute force approach
 * Time Complexity - O(n * klogk) - n is number of string and k is max length of string
 * Space Complexity - O(n * m) - n is number of Strings and m is the number of unique anagram groups
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        
    List<List<String>> result = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    //iterating through each string
    for(String str: strs){
        char[] chr = str.toCharArray();
        Arrays.sort(chr);
        String key = new String(chr);

        //Checking for matching condition
        if(map.containsKey(key)){
            map.get(key).add(str);
        }else{
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(key, list);
        }
    }
    //adding map values to result
    result.addAll(map.values());
    return result;
    }
}