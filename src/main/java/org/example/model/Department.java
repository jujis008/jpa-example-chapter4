package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.example.model.identification.DepartmentId;

@Entity(name = "department")
@IdClass(DepartmentId.class)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;

    private String name;

    @OneToOne
    private Employee manager;

    // @JoinColumns({@JoinColumn, @JoinColumn})
    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "department")
    private List<Employee> staff;

    @ElementCollection
    @CollectionTable(name = "department_employee_cubiculo",
    	joinColumns = {
    		@JoinColumn(name = "id_departament", referencedColumnName="id"),
    		@JoinColumn(name = "number_departament", referencedColumnName="number")})
    @Column(name="cubiculo")
    @MapKeyJoinColumn(name="id_employee")
    private Map<Employee, String> cubiculo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department() {
        setStaff(new ArrayList<>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public void setStaff(List<Employee> staff) {
        this.staff = staff;
    }

}
