package me.mepv;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s1 = "nameless";
        String s2 = "salesmen";
        System.out.println(isValidAnagramMap(s1, s2));
        System.out.println(isValidAnagramSorted(s1, s2));
    }


    private static Boolean isValidAnagramMap(String s, String anotherS) {
        char[] s1 = s.toCharArray();
        char[] s2 = anotherS.toCharArray();
        if (s.length() != anotherS.length()) return false;
        Map<Character, Integer> freqS1 = new Hashtable<>();
        Map<Character, Integer> freqS2 = new Hashtable<>();
        for (Character character: s1) {
            if (!freqS1.containsKey(character)) {
                freqS1.put(character, 1);
            } else {
                freqS1.put(character, freqS1.get(character) + 1);
            }
        }

        for (Character character: s2) {
            if (!freqS2.containsKey(character)) {
                freqS2.put(character, 1);
            } else {
                freqS2.put(character, freqS2.get(character) + 1);
            }
        }

        return freqS1.equals(freqS2);
    }

    private static Boolean isValidAnagramSorted(String s, String anotherS) {
        if (s.length() != anotherS.length()) return false;
        s = s.toLowerCase();
        anotherS = anotherS.toLowerCase();
        char[] s1 = s.toCharArray();
        char[] s2 = anotherS.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        String aSorted = new String(s1);
        String bSorted = new String(s2);

        return aSorted.equals(bSorted);
    }
}
