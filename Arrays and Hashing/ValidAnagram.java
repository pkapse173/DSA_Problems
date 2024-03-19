//Problem: Valid Anagram
/*
 * INPUT: s:["anagram"]
 *        t:["nagaram"]
 * OUTPUT: True
 */
/*
 * Approach 1 - Using an Array with occurences
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */

import java.util.HashMap;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
    //checking length of two strings
    if(s.length() != t.length()){
        return false;
    }

    int[] chCount = new int[26];

    //Count of occurences in s
    for(char ch: s.toCharArray()){
        chCount[ch - 'a']++;
    } 
    
    //Decrement occurences in t
    for(char ch: t.toCharArray()){
        chCount[ch - 'a']--;
            if(chCount[ch - 'a'] < 0){
            return false;
        }
    }
    
    return true;
    }
}

/*
 * Approach 2 - Using HashMap
 * Time Complexity - O(n + m): n is length of string s and m is the length of string t
 * Space Complexity - O(n): for HashMap
 */

 class ValidAnagram {
    public boolean isAnagram(String s, String t) {
    
    if(s.length() != t.length()){
            return false;
    }
    HashMap<Character, Integer> map = new HashMap<>();

    //Adding character with occurences in map
    for(int i = 0; i < s.length(); i++){
        char ch = s.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    
    //Checking each character with map
    for(int j = 0; j < t.length(); j++){
        char ch = t.charAt(j);
        if(!map.containsKey(ch) || map.get(ch) == 0){
            return false;
        }
        map.put(ch, map.get(ch) - 1);
    }
    return true;
    }
}