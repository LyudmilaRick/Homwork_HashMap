package pro.sky.java.course27.homework_map;

import java.util.Collection;

public interface EmployeeService {
    Collection<Employee> getAllEmployee();

    Employee addEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    Employee removeEmployee(String lastName, String firstName);
}
