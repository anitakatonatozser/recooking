package com.example.demo;

import java.util.Scanner;

public class TestClass {

        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            StringBuilder sb = new StringBuilder();
            sb.append(A.toLowerCase());
            if (sb.toString().equals((sb.reverse()).toString())){
                System.out.println("Yes");
            }
            System.out.println("No");
        }

}
