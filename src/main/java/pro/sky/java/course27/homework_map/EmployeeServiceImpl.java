package pro.sky.java.course27.homework_map;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * имплементация
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    // Массив, выполняющий роль хранилища для записей о сотрудниках.
    /**
     * Converts the whole ArrayList to a single string
     */
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Collection<Employee> getAllEmployee() {
        //  Возвращать следует копию, а не оригинальную коллекцию.
        // Нас это избавляет от потенциального изменения коллекции вне ответственного сервиса.
        //return (Collection<Employee>) Map.copyOf(employees);
        return new ArrayList<>(employees.values());
    }

    /**
     * метод добавления сотрудника
     *
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться добавленный объект
     */
    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        // ключ - полное имя. Допущение - полных тезок нет
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeExistException("Employee exist!");
        } else {
            employees.put(employee.getFullName(), employee);
            return employee;
        }
    }

    /**
     * поиск сотрудника по имени и фвмилии
     *
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться объект !!! ( согласно ДЗ )
     * @throws EmployeeNotFoundException не найден сотрудник
     */
    @Override
    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found...today");
    }

    /**
     * @param lastName  фамилия
     * @param firstName имя
     * @return должен вернуться объект, которого удалили
     * @throws EmployeeNotFoundException если такой сотрудник отсутствует
     */
    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found for deleting");
    }
}

