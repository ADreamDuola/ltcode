package com.sap.code;

public class AllSort {

  public void permutation(char[] c , int begin , int end){
    if(begin == end){
      for(int i = 0 ; i < c.length ; i++){
        System.out.print(c[i]);
      }
      System.out.println();
    }else{
      char temp;
      for(int i = begin ; i <= end ; i++){
        temp = c[begin];
        c[begin] = c[i];
        c[i] = temp;

        permutation(c , begin + 1 , end);

        temp = c[begin];
        c[begin] = c[i];
        c[i] = temp;
      }
    }
  }
  public static void main(String[] args) {
    AllSort a = new AllSort();
    char[] c = {'a', 'b', 'c', 'd'};
    a.permutation(c, 0, c.length - 1);
  }
  }
