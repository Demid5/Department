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
import java.util.stream.Collectors;

@Service
@Transactional
public class CrudServiceImpl implements CrudService {
    /**
     * Инъекции зависимости от репозиториев таблиц
     */
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Department> findDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> findEmployeesByListOfDepartmentId(long[] deps) {
        if (deps == null) {
            return Collections.emptyList();
        }
        return employeeRepository.findAll().stream()
                .filter(x -> Arrays.stream(deps).anyMatch(depId -> depId == x.getDepartment().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
