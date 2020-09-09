package com.huawei.java;

/**
 * @author fpystart
 * @create 2020-09-08 20:32
 */
public class FamilyAccount {

    public static void main(String[] args) {

        boolean isFlag = true;
        String details = "";
        int balance = 10000;

        while (isFlag) {

            System.out.println("-----------------家庭账户管理系统-----------------\n");
            System.out.println("                  1. 收支明细");
            System.out.println("                  2. 登记收入");
            System.out.println("                  3. 登记支出");
            System.out.println("                  4. 退  出\n");
            System.out.print("                  请选择（1-4）：");

            char selection = Utility.readMenuSelection();

            switch (selection) {
                case '1':
//                    System.out.println("1. 收支明细");
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println("收支\t账户金额\t\t收支金额\t\t说 明");
                    System.out.println(details);
                    System.out.println("-------------------------------------------------\n");
                    break;
                case '2':
//                    System.out.println("2. 登记收入");
                    System.out.print("本次收入金额：");
                    int incomeAmount = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String incomeInfo = Utility.readString();

                    balance += incomeAmount;
                    details += ("收入\t" + balance + "\t\t" + incomeAmount + "\t\t\t" + incomeInfo + "\n");
                    System.out.println("---------------------登记完成---------------------\n");
                    break;
                case '3':
//                    System.out.println("3. 登记支出");
                    System.out.print("本次支出金额：");
                    int expenditureAmount = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String expenditureInfo = Utility.readString();

                    balance -= expenditureAmount;
                    details += ("支出\t" + balance + "\t\t" + expenditureAmount + "\t\t\t" + expenditureInfo + "\n");
                    System.out.println("---------------------登记完成---------------------\n");
                    break;
                case '4':
//                    System.out.println("4. 退  出");
                    System.out.print("请确认是否退出（Y/N）：");
                    char confirm = Utility.readConfirmSelection();
                    if (confirm == 'Y') {
                        isFlag = false;
                    }
                    break;
            }

        }
    }
}
