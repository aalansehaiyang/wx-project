package com.weiguanjishu.demo.trycatch;

/**
 * @Author Tom哥
 */
public class TryT1 {

    public static void main(String[] args) {

        try {
            int i = 1 / 0;
            System.out.println("一些输出");
        } finally {
            System.out.println("执行 finally 中的方法");
        }


    }
}
