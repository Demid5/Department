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
    List<Employee> findEmployeesByListOfDepartmentId(long[] deps);

    void saveEmployee(Employee employee);

    Employee findEmployeeById(long id);

    List<Department> findDepartments();

    void deleteEmployee(Long empId);
}
