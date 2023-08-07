package neetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() == t.length()) {
            Map<Character, Integer> frequency = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if(frequency.containsKey(s.charAt(i))) {
                    frequency.put(s.charAt(i), 1 + frequency.get(s.charAt(i)));
                } else {
                    frequency.put(s.charAt(i), 1);
                }
                if (frequency.containsKey(t.charAt(i))) {
                    frequency.put(t.charAt(i), frequency.get(t.charAt(i)) - 1);
                } else {
                    frequency.put(t.charAt(i), -1);
                }
            }
            System.out.println(frequency);
            for (Map.Entry row : frequency.entrySet()) {
                if(!row.getValue().equals(0)) return false;
            }
            return true;
        }
        return false;
    }
}
