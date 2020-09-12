package com.sap.code;
/*
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理
 */

public class multiply {
    public static void main(String[] args) {
        String n = multiply.multi("456","123");
        System.out.println(n);

    }
    public static String multi(String num1, String num2) {
        /*https://blog.csdn.net/yonghu14587007/article/details/107437668
        例: 456 * 123

                        4 5 6
                    *   1 2 3
                    ---------                          0 0 0 0 0 0
                      1 3 6 8  0 0 1 3 6 8                     1 8             0 0 1 3 6 8
                               -----------                   1 5                     1 2
                      9 1 2    0 1 0 4 8 8                 1 2                  -----------
                      0 0 1 0 0 0                                              0 0 1 4 8 8
                               -----------             -----------                   10
                    4 5 6      0 5 6 0 8 8             0 0 1 3 6 8             -----------
                    ---------                                                  0 0 2 4 8 8
                  0 5 6 0 8 8                                                    0 8
                                                                               ---------
                                                                               0 1 0 4 8 8
         */
        if(num1.equals("0")||num2.equals("0"))return "0";
        int len1=num1.length();
        int len2=num2.length();
        int []res=new int[len1+len2];
        int start=0;
        for(int i=len2-1;i>=0;i--){
            start=(len2-1)-i;
            for(int j=len1-1;j>=0;j--){
                int a=num2.charAt(i)-48;
                int b=num1.charAt(j)-48;
//                res[start]+=a*b%10;//开始位,加本身即上一次计算后的本位值
                res[start] = res[start] + a*b%10;
//                res[start+1]+=(a*b)/10+(res[start])/10;//影响下一位，一定要分别除以10
                res[start+1] = res[start+1] + (a*b)/10+(res[start])/10;//影响下一位，一定要分别除以10
                res[start]=res[start]%10;//本身可能有进位
                start++;
            }
        }
        StringBuilder s=new StringBuilder("");
        for(int i=len1+len2-1;i>=0;i--){
            s.append(res[i]);
        }
        //结果为len1+len2-1或len1+len2位
        return (s.charAt(0)=='0')?s.toString().substring(1,len1+len2):s.toString();

    }
    

    }
