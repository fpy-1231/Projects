package com.huawei.java.util;

import java.util.Scanner;

/**
 * @author fpystart
 * @create 2020-09-16 22:37
 */
public class CMUtility {

    private static Scanner scanner = new Scanner(System.in);

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String str = "";
        for (; ; ) {
            str = scanner.nextLine();

            if (str.length() == 0 && blankReturn) {
                return str;
            }
            if (str.length() < 1 || str.length() > limit) {
                System.out.print("输入的长度有误，请重新输入：");
            } else {
                return str;
            }
        }
    }

    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            c = readKeyBoard(1, false).charAt(0);
            if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5') {
                return c;
            }
            System.out.print("输入有误，请重新输入：");
        }
    }

    public static char readChar() {
        return readKeyBoard(1, false).charAt(0);
    }

    public static char readChar(char defaultValue) {
        String s = readKeyBoard(1, true);
        return s.length() == 0 ? defaultValue : s.charAt(0);
    }

    public static int readInt() {
        int num;
        for (; ; ) {
            try {
                String s = readKeyBoard(2, false);
                num = Integer.parseInt(s);
                return num;
            } catch (NumberFormatException e) {
                System.out.print("输入的数字有误，请重新输入：");
            }
        }
    }

    public static int readInt(int defaultValue) {
        int num;
        for (; ; ) {
            try {
                String s = readKeyBoard(2, true);
                if (s.length() == 0) return defaultValue;
                num = Integer.parseInt(s);
                return num;
            } catch (NumberFormatException e) {
                System.out.print("输入的数字有误，请重新输入：");
            }
        }
    }

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    public static String readString(int limit, String defaultValue) {
        String s = readKeyBoard(limit, true);
        return s.length() == 0 ? defaultValue : s;
    }

    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            c = readKeyBoard(1, false).toUpperCase().charAt(0);

            if (c == 'Y' || c == 'N') {
                return c;
            }
            System.out.print("输入有误，请重新输入：");
        }
    }

}
