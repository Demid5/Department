package departament.task.web.test.service;

import departament.task.web.test.entities.Department;
import departament.task.web.test.entities.Employee;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CrudService {
    /**
     * Вернуть список сотрудников из заданных отделов
     * @param depIds - список id отделов
     * @return список сотрудников из заданных отделов
     */
    List<Employee> findEmployeesByListOfDepartmentId(@Nullable List<Long> depIds);

    /**
     * Сохранить сотрудника(нового/текущего) в бд
     * @param employee - сотрудник
     */
    void saveEmployee(Employee employee);

    /**
     * Найти сотрудника по первичному ключу
     * @param id - первичный ключ сотрудника
     * @return - найденный сотрудник
     */
    Employee findEmployeeById(Long id);

    /**
     * Вернуть все отделы
     * @return все отделы
     */
    List<Department> findDepartments();

    /**
     * Удалить сотрудника по первичному ключу
     * @param id - первичный ключ сотрудника
     */
    void deleteEmployee(Long id);
}
