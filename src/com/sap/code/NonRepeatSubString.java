package com.sap.code;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatSubString {
  public int noRepeat(String str){
    Map<Character,Integer> m = new HashMap<>();
    int res = 0;
    for(int start =0,end =0;end <str.length()&&start<str.length();end++){
      if(m.containsKey(str.charAt(end)))
      {


        start = Math.max(start,m.get(str.charAt(end)));
      }
      m.put(str.charAt(end),end+1);
      res=Math.max(res,end+1-start);
    }
    return res;
  }

  public static void main(String[] args) {
    String str = "abcdejbcade";
    NonRepeatSubString res = new NonRepeatSubString();
    int result = res.noRepeat(str);
    System.out.println(result);

  }

}
