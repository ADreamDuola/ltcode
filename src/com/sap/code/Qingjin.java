package com.sap.code;

public class Qingjin {

  public static void main(String[] args) {
    int i,j,n,s;
    for(i=100;i<=999;i++)
    {
      n=i;
      j=n/11;
      s=0;
      n=131;
      while (n>0){
        s+=(n%10)*(n%10);
        n/=10;
      }
      if(j==s){
        System.out.println(i);
      }
    }
  }

}
