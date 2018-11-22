package com.maxplus1.demo.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Const {
    /**
     * 定义常量
     */
    public final static String ONE = "1";

    /**
     * 定义枚举类
     */
    @AllArgsConstructor
    public enum ACT_TYPE{
        TYPE_ONE("1");
        @Getter
        private String val;
    }


    /**
     * 使用枚举类
     * @param args
     */
    public static void main(String[] args){
        System.out.println(Const.ACT_TYPE.TYPE_ONE.getVal());
    }
}
