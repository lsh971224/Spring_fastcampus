package com.fastcampus.ch3.aop;

import org.springframework.stereotype.Component;

@Component
public class MyMath {
    public int add(int a, int b){
        int rs = a+b;
        return rs;
    }
    public int add(int a, int b,int c){
        int rs = a+b+c;
        return rs;
    }
    public int subtract(int a, int b){
        int rs = a-b;
        return rs;
    }
    public int multply(int a, int b){
        int rs = a*b;
        return rs;
    }
}
