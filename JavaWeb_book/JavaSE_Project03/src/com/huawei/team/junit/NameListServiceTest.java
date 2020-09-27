package com.huawei.team.junit;

import com.huawei.team.domain.Employee;
import com.huawei.team.service.NameListService;
import com.huawei.team.service.TeamException;
import org.junit.jupiter.api.Test;

/**
 * @author fpystart
 * @create 2020-09-25 19:43
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void getEmployee() {
        NameListService service = new NameListService();
        int id = 12;

        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }
}
