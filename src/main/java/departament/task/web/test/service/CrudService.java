package departament.task.web.test.service;

import departament.task.web.test.entities.Department;
import departament.task.web.test.entities.Employee;

import java.util.List;

public interface CrudService {
    /**
     * Вернуть список сотрудников из заданных отделов
     * @param deps
     * @return
     */
    List<Employee> readEmployeesByListOfDepartment(List<Long> deps);

    List<Employee> readEmployees();

    List<Department> readDepartments();


}
