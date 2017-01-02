package org.example.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.example.model.identification.PeopleIdentification;

@Entity(name = "employee")
@Access(AccessType.FIELD)
public class Employee {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cpf", column = @Column(name = "registration"))})
    private PeopleIdentification identification;

    @ManyToMany
    @JoinTable(name = "employee_role", 
        joinColumns = @JoinColumn(name = "employee"),
        inverseJoinColumns=@JoinColumn(name="role"))
    private List<Role> role;

   /* 
    * Cria um tabela para fazer o mapeamento entre funcionario e deparmento.
    * Nesse tipo de relacionamento, essa tabela nao é necessaria pois o funcionario poderia ter
    * em sua tabela o id do departmento a qual pertence.
    * 
    * @JoinTable( name="employee_department",
                joinColumns=@JoinColumn(name="employee_id", nullable=false),
                inverseJoinColumns=@JoinColumn(name="dept_id"))*/
    
    @JoinColumn(name="depto_id")
    @ManyToOne
    private Department department;

    @JoinColumn(name="parking_space_id")
    @OneToOne
    private ParkingSpace parkingSpace;
    
    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PeopleIdentification getIdentification() {
        return identification;
    }

    public void setIdentification(PeopleIdentification identification) {
        this.identification = identification;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }
    
}
