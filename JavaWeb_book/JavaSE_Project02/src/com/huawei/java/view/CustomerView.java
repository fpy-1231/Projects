package com.huawei.java.view;

import com.huawei.java.model.Customer;
import com.huawei.java.service.CustomerList;
import com.huawei.java.util.CMUtility;

/**
 * @author fpystart
 * @create 2020-09-16 22:36
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("李白", '男', 18, "13012341234", "lb@126.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                  1 添 加 客 户");
            System.out.println("                  2 修 改 客 户");
            System.out.println("                  3 删 除 客 户");
            System.out.println("                  4 客 户 列 表");
            System.out.println("                  5 退       出\n");
            System.out.print("                  请选择(1-5)：");

            char menuSelection = CMUtility.readMenuSelection();
            switch (menuSelection) {
                case '1':
//                    System.out.println("1 添 加 客 户");
                    addNewCustomer();
                    break;
                case '2':
//                    System.out.println("2 修 改 客 户");
                    modifyCustomer();
                    break;
                case '3':
//                    System.out.println("3 删 除 客 户");
                    deleteCustomer();
                    break;
                case '4':
//                    System.out.println("4 客 户 列 表");
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("5 退       出");
                    System.out.print("请确认是否退出(Y/N)：");
                    char selection = CMUtility.readConfirmSelection();
                    if (selection == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        }
    }

    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name, gender, age, phone, email);

        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("-------------客户列表已满，添加失败---------------------");
        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        Customer cust;
        int number;
        for (; ; ) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            }
            cust = customerList.getCustomer(number - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        System.out.print("姓名(" + cust.getName() + ")：");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("性别(" + cust.getGender() + ")：");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄(" + cust.getAge() + ")：");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话(" + cust.getPhone() + ")：");
        String phone = CMUtility.readString(13, cust.getPhone());
        System.out.print("邮箱(" + cust.getEmail() + ")：");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);

        boolean isSuccess = customerList.replaceCustomer(number - 1, newCust);
        if (isSuccess) {
            System.out.println("---------------------修改完成---------------------");
        } else {
            System.out.println("---------------------修改失败---------------------");
        }
    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        Customer customer;
        int number;
        for (; ; ) {

            System.out.print("请选择待删除客户编号(-1退出)：");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            }
            customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
                continue;
            } else {
                break;
            }
        }
        System.out.print("确认是否删除(Y/N)：");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            boolean isSuccess = customerList.deleteCustomer(number - 1);
            if (isSuccess) {
                System.out.println("---------------------删除完成---------------------");
            } else {
                System.out.println("---------------------删除失败---------------------");
            }
        }
    }

    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        Customer[] customers = customerList.getAllCustomers();
        if (customers.length == 0) {
            System.out.println("没有客户信息.");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            for (int i = 0; i < customers.length; i++) {
                System.out.println((i + 1) + "\t\t" + customers[i].getName() + "\t" +
                        customers[i].getGender() + "\t\t" + customers[i].getAge() + "\t\t" +
                        customers[i].getPhone() + "\t" + customers[i].getEmail());
            }
        }

        System.out.println("-------------------------客户列表完成-------------------------\n");
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
