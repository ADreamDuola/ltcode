package com.sap.code;

/**最长公共前缀*/

public class LongestCommonPrefix {
  public String solution(String[] strs){
    if(strs.length==0){
      return "";
    }
    String result = strs[0];
    for(int i=0;i<strs.length;i++){
      int a = strs[i].indexOf(result);
      Boolean b = strs[i].startsWith(result);
//      while (!strs[i].startsWith(result)){//上面的也可以
      while (strs[i].indexOf(result)!=0){
        result = result.substring(0,result.length()-1);
        if(result.length()==0){
          return "";
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String[] str = new String[]{"abcd","ab","abcdmg"};
    LongestCommonPrefix test = new LongestCommonPrefix();
   String aa =  test.solution(str);
    System.out.println(aa);

  }

}
