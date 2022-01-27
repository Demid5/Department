package departament.task.web.test;

import departament.task.web.test.entities.Department;
import departament.task.web.test.entities.Employee;
import departament.task.web.test.repo.DepartmentRepository;
import departament.task.web.test.repo.EmployeeRepository;
import departament.task.web.test.service.CrudServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CrudServiceTest {

    @InjectMocks
    private CrudServiceImpl crudServiceImpl;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindEmployeeById() {
        Employee e = new Employee();
        e.setId(1L);
        when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.of(e));
        Employee employee = crudServiceImpl.findEmployeeById(1L);

        verify(employeeRepository).findById(1L);
        assertEquals(1L, employee.getId().longValue());
    }

    @Test
    public void testFindEmployeesByListOfDepartmentId() {
        // check on null
        List<Long> depIds = null;
        List<Employee> resultList = crudServiceImpl.findEmployeesByListOfDepartmentId(depIds);
        assertEquals(Collections.emptyList(), resultList);

        // prepare
        Employee e1 = new Employee();
        Department department1 = new Department();
        department1.setId(1L);
        e1.setDepartment(department1);
        Employee e2 = new Employee();
        Department department2 = new Department();
        department2.setId(2L);
        e2.setDepartment(department2);
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(e1, e2));

        // test 1 - all departments
        depIds = Arrays.asList(1L, 2L);
        resultList = crudServiceImpl.findEmployeesByListOfDepartmentId(depIds);
        assertEquals(Arrays.asList(e1, e2), resultList);

        // test 2 - one department
        depIds = Collections.singletonList(1L);
        resultList = crudServiceImpl.findEmployeesByListOfDepartmentId(depIds);
        assertEquals(Collections.singletonList(e1), resultList);
    }
}
