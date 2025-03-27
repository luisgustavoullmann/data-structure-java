package strings;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("batata", "attaba"));
        System.out.println(isAnagram("rat", "car"));

        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("batata", "attaba"));
        System.out.println(isAnagram2("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

    public static boolean isAnagram2(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if(c != 0) {
                return false;
            }
        }

        return true;
    }
}
