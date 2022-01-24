package departament.task.web.test.service;

import departament.task.web.test.entities.Department;
import departament.task.web.test.entities.Employee;
import departament.task.web.test.repo.DepartmentRepository;
import departament.task.web.test.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudServiceImpl implements CrudService {
    /**
     * Инъекции зависимости от репозиториев таблиц
     */
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> readEmployeesByListOfDepartment(List<Long> deps) {
        return null;
    }

    @Override
    public List<Employee> readEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Department> readDepartments() {
        return departmentRepository.findAll();
    }
}
