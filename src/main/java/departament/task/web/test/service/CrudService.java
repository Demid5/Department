package departament.task.web.test.service;

import departament.task.web.test.entities.Department;
import departament.task.web.test.entities.Employee;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CrudService {
    /**
     * Вернуть список сотрудников из заданных отделов
     * @param deps
     * @return
     */
    List<Employee> findEmployeesByListOfDepartmentId(int[] deps);

    List<Employee> findEmployees();

    /**
     * Добавить нового сотрудника в бд по заданным параметрам
     * @param lastName - фамилия
     * @param firstName - имя
     * @param middleName - отчество(необязательно)
     * @param depId - id отдела
     */
    void addEmployee(String lastName, String firstName, @Nullable String middleName, Long depId);

    /**
     * Редактировать текущего сотрудника в бд по заданным параметрам
     * @param empId - id сотрудника
     * @param lastName - фамилия
     * @param firstName - имя
     * @param middleName - отчество(необязательно)
     * @param depId - id отдела
     */
    void updateEmployee(Long empId, String lastName, String firstName, @Nullable String middleName, Long depId);

    Employee findEmployeeById(long id);

    List<Department> findDepartments();

    void deleteEmployee(Long empId);
}
