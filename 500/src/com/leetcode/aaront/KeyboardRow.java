package com.leetcode.aaront;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author tonyhui
 * @since 17/2/23
 */
public class KeyboardRow {

    public static void main(String[] args) {
        KeyboardRow keyboardRow = new KeyboardRow();
        System.out.println(Arrays.toString(keyboardRow.findWords(new String[]{"Qwertyuiop" })));
    }

    public String[] findWords(String[] words) {
        Set<String> row1 = new HashSet<>();
        row1.add("q");
        row1.add("Q");
        row1.add("w");
        row1.add("W");
        row1.add("e");
        row1.add("E");
        row1.add("r");
        row1.add("R");
        row1.add("t");
        row1.add("T");
        row1.add("y");
        row1.add("Y");
        row1.add("u");
        row1.add("U");
        row1.add("i");
        row1.add("I");
        row1.add("o");
        row1.add("O");
        row1.add("p");
        row1.add("P");
        Set<String> row2 = new HashSet<>();
        row2.add("a");
        row2.add("s");
        row2.add("d");
        row2.add("f");
        row2.add("g");
        row2.add("h");
        row2.add("j");
        row2.add("k");
        row2.add("l");
        row2.add("A");
        row2.add("S");
        row2.add("D");
        row2.add("F");
        row2.add("G");
        row2.add("H");
        row2.add("J");
        row2.add("K");
        row2.add("L");
        Set<String> row3 = new HashSet<>();
        row3.add("z");
        row3.add("x");
        row3.add("c");
        row3.add("v");
        row3.add("b");
        row3.add("n");
        row3.add("m");
        row3.add("Z");
        row3.add("X");
        row3.add("C");
        row3.add("V");
        row3.add("B");
        row3.add("N");
        row3.add("M");

        List<String> conformStr = new ArrayList<>();
        for (int i = 0, len = words.length; i < len; i++) {
            String word = words[i];
            if (containedInSet(word, row1) || containedInSet(word, row2) || containedInSet(word, row3)) {
                conformStr.add(word);
            }
        }
        return conformStr.toArray(new String[0]);
    }

    private boolean containedInSet(String word, Set<String> set) {
        String[] letters = word.split("");
        return set.containsAll(Arrays.asList(letters));
    }

    /**
     * 思路: 正则表达式
     *
     * @return
     */
    public String[] betterMethod(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
