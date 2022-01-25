package departament.task.web.test.service;

import departament.task.web.test.entities.Department;
import departament.task.web.test.entities.Employee;
import departament.task.web.test.repo.DepartmentRepository;
import departament.task.web.test.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Employee> findEmployeesByListOfDepartmentId(int[] deps) {
        if (deps == null) {
            return Collections.emptyList();
        }
        return employeeRepository.findAll().stream()
                .filter(x -> Arrays.stream(deps).anyMatch(depId -> depId == x.getDepartment().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(String lastName, String firstName, String middleName, Long depId) {
        employeeRepository.save(new Employee(firstName, lastName, middleName,
                departmentRepository.getById(depId)));
    }

    @Transactional
    @Override
    public void updateEmployee(Long empId, String lastName, String firstName,
                               String middleName, Long depId) {
        employeeRepository.deleteById(empId);
        addEmployee(lastName, firstName, middleName, depId);
    }

    @Override
    public Employee findEmployeeById(long id) {
        Optional<Employee> emp;
        return (emp = employeeRepository.findById(id)).isEmpty() ? null : emp.get();
    }

    @Override
    public List<Department> findDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
