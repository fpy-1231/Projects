package com.huawei.team.view;

import java.util.Scanner;

/**
 * @author fpystart
 * @create 2020-09-21 8:11
 */
public class TSUtility {

    private static Scanner scanner = new Scanner(System.in);

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String str;

        for (; ; ) {
            str = scanner.nextLine();
            if (str.length() == 0) {
                if (blankReturn) {
                    return str;
                } else {
                    continue;
                }
            }
            if (str.length() > limit) {
                System.out.print("输入的长度有误(不大于" + limit + "个字符)，请重新输入：");
                continue;
            }
            return str;
        }
    }

    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            c = readKeyBoard(1, false).charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.print("输入有误，请重新输入：");
                continue;
            }
            return c;
        }
    }

    public static void readReturn() {
        System.out.print("请按回车键继续。。。");
        readKeyBoard(100, true);
    }

    public static int readInt() {
        int n;
        for (; ; ) {
            String s = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(s);
                return n;
            } catch (NumberFormatException e) {
                System.out.print("输入错误，请输入正确的数字：");
            }
        }
    }

    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            c = readKeyBoard(1, false).toUpperCase().charAt(0);
            if (c != 'Y' && c != 'N') {
                System.out.print("输入错误，请重新输入：");
                continue;
            }
            return c;
        }
    }
}
