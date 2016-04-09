package com.leetcode.aaront;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author tonyhui
 * @since 16/2/4
 */
public class LongestSubstring {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("hello"));
    }

    public static int lengthOfLongestSubstring(String s) {
        //List<String> subString = new ArrayList<>();
        System.out.println(System.currentTimeMillis());
        Map<String, Integer> map = new HashMap<>();
        int max=1;
        int len = s.length();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                String key = s.substring(i, j);
                Integer temp = map.get(key);
                if(temp!=null) {
                    map.put(key, temp + 1);
                    max = max > (temp + 1)?max:temp + 1;
                }
                else map.put(key, 1);
            }
        }

        System.out.println(System.currentTimeMillis());

        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {

        int max=0;
        int count=0;
        int low=0;
        int start=0;
        HashSet<Character> myhash=new HashSet<>();

        for(low=0;low<s.length();)
        {
            while(start<s.length())
            {
                if(!myhash.contains(s.charAt(start)))
                {
                    count++;
                    myhash.add(s.charAt(start));
                    start++;
                    // System.out.println(count);
                }
                else
                {
                    if(count>max)
                        max=count;
                    while(s.charAt(low)!=s.charAt(start)) //Bringing the low pointer to the location of the repeated element+1.
                    {
                        myhash.remove(s.charAt(low));
                        low++;
                    }
                    myhash.remove(s.charAt(low));
                    low++;

                    count=start-low;
                    break;
                }

            }
            if(start>=s.length())
                break;

        }
        if(count>max)
            max=count;
        return max;
    }
}
