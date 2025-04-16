//Problem 1
// We count the frequency of each character for every string and use it as a key to group anagrams.
// Since anagrams have the same character counts, they will share the same key (i.e., character frequency array).
// We store these groups in a hashmap and return the grouped values as a list of lists.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ans = new HashMap<>();

        for(String str: strs){
            int[] count = new int[26];
            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<>());
            }

            ans.get(key).add(str);

        }

        return new ArrayList<>(ans.values());

    }
}

//Problem 2
// We map each character from `s` to `t` and vice versa to ensure a one-to-one mapping between characters.
// If a previously mapped character conflicts with a new mapping, we return false.
// If no conflicts are found throughout the string, the strings are isomorphic.
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for(int i = 0; i< s.length(); i++){

            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(sToT.containsKey(cs)){
                if(sToT.get(cs) != ct) return false;
            }else{
                sToT.put(cs, ct);
            }

            if(tToS.containsKey(ct)){
                if(tToS.get(ct) != cs) return false;
            }else{
                tToS.put(ct, cs);
            }
        }
        return true;
    }
}

//Problem 3
// This is same as above mapping problem between pattern characters and words from the input string.
// We ensure that each character maps to exactly one word and vice versa using two hashmaps.
// If a mismatch is detected or the pattern and words count differ, we return false.
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charToStr = new HashMap<>();
        HashMap<String, Character> strToChar = new HashMap<>();

        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){
            if(charToStr.containsKey(pattern.charAt(i))){
                if(!charToStr.get(pattern.charAt(i)).equals(words[i])) return false;
            }else{
                if(strToChar.containsKey(words[i])){
                    if(strToChar.get(words[i]) != pattern.charAt(i)) return false;
                }else{
                    charToStr.put(pattern.charAt(i),words[i]);
                    strToChar.put(words[i],pattern.charAt(i));
                }

            }
        }
        return true;
    }
}