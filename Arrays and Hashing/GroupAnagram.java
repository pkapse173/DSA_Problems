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