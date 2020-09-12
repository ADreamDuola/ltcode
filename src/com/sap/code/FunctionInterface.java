package com.sap.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class FunctionInterface {
    public static void test(List<Integer> list, Predicate<Integer> predicate){
        for(Integer n:list){
            if(predicate.test(n)){
                System.out.println(n+" ");
            }
        }
    }

    public static BiFunction<Integer,Integer,Integer> bitest(Integer c){
        return (a,b)->{
            return  a + b + c;
        };
    }


    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println("输出所有偶数：");
        test(list,n->n%2 ==0);
        System.out.println("********************");
        int c = FunctionInterface.bitest(3).apply(1,2);
        System.out.println("bi输出" + c);
    }

}
