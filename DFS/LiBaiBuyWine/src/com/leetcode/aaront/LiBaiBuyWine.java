package com.leetcode.aaront;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonyhui
 * @since 17/2/8
 */
public class LiBaiBuyWine {

    private int count = 0;
    private List<List<Character>> lines = new ArrayList<>();

    public static void main(String[] args) {
        LiBaiBuyWine liBaiBuyWine = new LiBaiBuyWine();
        List<Character> aLine = new ArrayList<>();
        List<Character> bLine = new ArrayList<>();
        liBaiBuyWine.buyWine(1, 1, 0, 2, 'a', aLine);
        liBaiBuyWine.buyWine(1, 0, 1, 2, 'b', bLine);
        System.out.println(liBaiBuyWine.lines.size());
        liBaiBuyWine.lines.forEach(System.out::println);
    }

    public void buyWine(int total, int hotel, int flower, int wine, char dest, List<Character> line) {
        line.add(dest);
        if (dest == 'a') wine *= 2;
        if (dest == 'b') wine -= 1;
        if (hotel == 6 || flower == 10) {
            line.remove(line.size() - 1);
            return;
        }
        if (total == 14) {
            if (wine == 1) {
                count++;
                List<Character> list = new ArrayList<>(line);
                lines.add(list);
            }
            line.remove(line.size() - 1);
            return;
        }

        buyWine(total + 1, hotel + 1, flower, wine, 'a', line);
        buyWine(total + 1, hotel, flower + 1, wine, 'b', line);
        line.remove(line.size() - 1);
    }
}
