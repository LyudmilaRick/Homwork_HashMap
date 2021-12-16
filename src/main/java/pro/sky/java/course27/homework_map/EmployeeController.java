package pro.sky.java.course27.homework_map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * контроллер
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get")
    public Collection<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        return getResult("#5511AA", employeeService.addEmployee(lastName, firstName), "успешно создан");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        return getResult("#FF00AA", employeeService.removeEmployee(lastName, firstName), "удален");
    }

    private String getResult(String color, Employee employee, String action) {
        return String.format("<B  style=\"color:%s\"> %s %s  %s  </b>", color, "Сотрудник ", employee.getFullName(), action);
    }
}

