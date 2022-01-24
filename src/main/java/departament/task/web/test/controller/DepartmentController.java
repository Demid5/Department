package departament.task.web.test.controller;

import departament.task.web.test.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {
    @Autowired
    private CrudService crudService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String mainPage(Model model) {
        model.addAttribute("departments", crudService.readDepartments());
        model.addAttribute("employees", crudService.readEmployees());
        return "departmentPage";
    }
}
