package com.huawei.java;

import java.util.Scanner;

/**
 * @author fpystart
 * @create 2020-09-08 20:33
 */
public class Utility {

    private static Scanner scanner = new Scanner(System.in);

    private static String readKeyBoard(int length) {
        String str;
        while (true) {
            str = scanner.next();
            if (str.length() > length) {
                System.out.print("输入的长度有误，请重新输入：");
            } else {
                return str;
            }
        }
    }

    public static char readMenuSelection() {
        char select;
        while (true) {
            select = readKeyBoard(1).charAt(0);
            if (select == '1' || select == '2' || select == '3' || select == '4') {
                return select;
            } else {
                System.out.print("选择有误，请重新选择：");
            }
        }
    }

    public static char readConfirmSelection() {
        char confirm;
        while (true) {
            confirm = readKeyBoard(1).toUpperCase().charAt(0);
            if (confirm == 'Y' || confirm == 'N') {
                return confirm;
            } else {
                System.out.print("选择有误，请重新选择：");
            }
        }
    }

    public static int readNumber() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(readKeyBoard(10));
                return number;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
    }

    public static String readString(){
        return readKeyBoard(10);
    }
}
