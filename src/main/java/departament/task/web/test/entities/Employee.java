package departament.task.web.test.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column
    private String middle_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_depatrment")
    private Department department;

    public void setId(Long id) {
        this.id = id;
    }

    public Employee() {}

    public Employee(String first_name, String last_name, String middle_name, Department department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.department = department;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public Department getDepartment() {
        return department;
    }

    public Long getId() {
        return id;
    }
}
