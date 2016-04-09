package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/2/5
 */
public class ZigZag {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        // 需要优化，能不能不创建这么大的数组用于保存数据
        String[][] arr = new String[numRows][1000];
        String[] cs = s.split("");
        int x = 0, y = 0;
        //int index = 0;
        boolean flag = true;
        for (int i = 0; i < cs.length; i++) {
            if(flag){
                arr[x][y] = cs[i];
                x++;
                if(x == numRows){
                    x--;
                    flag = false;
                }
            }else{
                arr[--x][++y] = cs[i];
                if(x==0){
                    x++;
                    flag = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<1000;j++){
                if(arr[i][j]!=null)
                    sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }
}
