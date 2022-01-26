package departament.task.web.test.controller;

import departament.task.web.test.entities.Employee;
import departament.task.web.test.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {
    private final CrudService crudService;

    @Autowired
    public DepartmentController(CrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping(value = "/")
    public String showEmployeeDepartment(@RequestParam(value = "depIds", required = false) List<Long> depIds,
                                        Model model) {
        model.addAttribute("employees", crudService.findEmployeesByListOfDepartmentId(depIds));
        model.addAttribute("departments", crudService.findDepartments());
        return "departmentPage";
    }

    @GetMapping(value = "/editEmployee/{id}")
    public String editEmployee(@PathVariable Long id,
                               Model model) {
        model.addAttribute("departments", crudService.findDepartments());
        model.addAttribute("employee", crudService.findEmployeeById(id));
        return "employeeEditPage";
    }

    @GetMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id,
                                 Model model) {
        crudService.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping(value = "/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", crudService.findDepartments());
        return "employeeAddPage";
    }

    @PostMapping(value = "/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        crudService.saveEmployee(employee);
        return "redirect:/";
    }

}
