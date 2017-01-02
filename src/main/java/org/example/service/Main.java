package org.example.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.identification.PeopleIdentification;

public class Main {
    
    public static void main(String[] args) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chapter4");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        
        PeopleIdentification identification = new PeopleIdentification();
        identification.setName("Thiago");
        identification.setBirthDate(new Date());
        identification.setCpf("111.111.111.111");
        
        Department it = new Department();
        
        Employee employee = new Employee();
        employee.setIdentification(identification);
        
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        
        entityManager.getTransaction().begin();
        it.setName("Magic Department");
        it.getStaff().add(employee);
        it.setManager(employee);
        employee.setDepartment(it);
        entityManager.persist(it);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
        
    }

}
