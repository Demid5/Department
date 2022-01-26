package departament.task.web.test.controller;

import departament.task.web.test.entities.Employee;
import departament.task.web.test.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DepartmentController {
    @Autowired
    private CrudService crudService;

    @GetMapping(value = "/")
    public String showEmployeeDepartment(@RequestParam(value = "deps", required = false) long[] deps,
                                        Model model) {
        model.addAttribute("employees", crudService.findEmployeesByListOfDepartmentId(deps));
        model.addAttribute("departments", crudService.findDepartments());
        return "departmentPage";
    }

    @GetMapping(value = "/editEmployee/{id}")
    public String editEmployee(@PathVariable long id,
                               Model model) {
        model.addAttribute("departments", crudService.findDepartments());
        model.addAttribute("employee", crudService.findEmployeeById(id));
        return "employeeEditPage";
    }

    @GetMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable long id,
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
