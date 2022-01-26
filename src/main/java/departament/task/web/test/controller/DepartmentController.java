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

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String processDepartmentForm(@RequestParam(value = "deps", required = false) int[] deps,
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

    @RequestMapping(method = RequestMethod.POST, value = "/updateEmployee")
    public String editEmployee(@RequestParam(value = "empId") long empId,
                                 @RequestParam(value = "last-name") String lastName,
                                 @RequestParam(value = "first-name") String firstName,
                                 @RequestParam(value = "middle-name") String middleName,
                                 @RequestParam(value = "depId") long depId) {
        crudService.updateEmployee(empId, lastName, firstName, middleName, depId);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("departments", crudService.findDepartments());
        model.addAttribute("employee", employee);
        return "employeeAddPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        crudService.addEmployee(employee);
        return "redirect:/";
    }

}
