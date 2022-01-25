package departament.task.web.test.controller;

import departament.task.web.test.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(method = RequestMethod.GET, value = "/updateEmployee")
    public String updateEmployee(@RequestParam(value = "empId") long id,
                               Model model) {
        model.addAttribute("departments", crudService.findDepartments());
        model.addAttribute("employee", crudService.findEmployeeById(id));
        return "employeeEditPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateEmployee")
    public String updateEmployee(@RequestParam(value = "empId") long empId,
                                 @RequestParam(value = "last-name") String lastName,
                                 @RequestParam(value = "first-name") String firstName,
                                 @RequestParam(value = "middle-name") String middleName,
                                 @RequestParam(value = "depId") long depId) {
        crudService.updateEmployee(empId, lastName, firstName, middleName, depId);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("departments", crudService.findDepartments());
        return "employeeAddPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
    public String addEmployee(@RequestParam(value = "last-name") String lastName,
                              @RequestParam(value = "first-name") String firstName,
                              @RequestParam(value = "middle-name") String middleName,
                              @RequestParam(value = "depId") Long depId) {
        crudService.addEmployee(lastName, firstName, middleName, depId);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(Model model, @RequestParam(name = "empId") Long empId) {
        crudService.deleteEmployee(empId);
        return "redirect:/";
    }

}
