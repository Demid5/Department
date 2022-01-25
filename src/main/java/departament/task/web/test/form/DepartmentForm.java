package departament.task.web.test.form;

import java.util.List;

public class DepartmentForm {
    private List<String> checkedDepartments;

    public List<String> getDepartments() {
        return checkedDepartments;
    }

    public void setDepartments(List<String> checkedDepartments) {
        this.checkedDepartments = checkedDepartments;
    }
}
