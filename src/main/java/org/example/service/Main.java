package org.example.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Phone;
import org.example.model.identification.PeopleIdentification;
import org.example.model.map.VacationEntry;
import org.example.model.ordercolumn.PrintJob;
import org.example.model.ordercolumn.PrintQueue;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chapter4");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        PeopleIdentification identification = new PeopleIdentification();
        identification.setName("Thiago");
        identification.setBirthDate(new Date());
        identification.setCpf("111.111.111.111");

        Phone phone = new Phone();
        phone.setPhone("12313132");

        Employee employee = new Employee();
        employee.setPhones(new ArrayList<Phone>());
        employee.getPhones().add(phone);

        employee.setVacationBookings(new ArrayList<VacationEntry>());

        VacationEntry vacationEntry = new VacationEntry();
        vacationEntry.setDaysTaken(10);
        vacationEntry.setStartDate(Calendar.getInstance());
        employee.getVacationBookings().add(vacationEntry);

        vacationEntry = new VacationEntry();
        vacationEntry.setDaysTaken(13);
        vacationEntry.setStartDate(Calendar.getInstance());
        employee.getVacationBookings().add(vacationEntry);


        vacationEntry = new VacationEntry();
        vacationEntry.setDaysTaken(15);
        vacationEntry.setStartDate(Calendar.getInstance());
        employee.getVacationBookings().add(vacationEntry);

        vacationEntry = new VacationEntry();
        vacationEntry.setDaysTaken(18);
        vacationEntry.setStartDate(Calendar.getInstance());
        employee.getVacationBookings().add(vacationEntry);

        phone.setEmployee(employee);

        employee.setIdentification(identification);
        entityManager.persist(employee);


        Department it = new Department();

        it.setName("Magic Department");
        it.getStaff().add(employee);
        it.setManager(employee);
        employee.setDepartment(it);

        entityManager.persist(it);


        PrintQueue queue = new PrintQueue();
        queue.getJobs().add(new PrintJob());
        queue.getJobs().add(new PrintJob());
        queue.getJobs().add(new PrintJob());
        queue.getJobs().add(new PrintJob());
        queue.getJobs().add(new PrintJob());


        entityManager.getTransaction().commit();

        System.out.println(queue);

        entityManager.getTransaction().begin();
        queue = entityManager.merge(queue);
        PrintJob printJob = queue.getJobs().remove(0);
        queue.getJobs().add(queue.getJobs().size(), printJob);
        System.out.println(queue);

        entityManager.getTransaction().commit();





        entityManager.close();
        entityManagerFactory.close();

    }

    private static void persist(EntityManager entityManager){

    	 PeopleIdentification identification = new PeopleIdentification();
         identification.setName("Thiago");
         identification.setBirthDate(new Date());
         identification.setCpf("111.111.111.111");

    	 Department it = new Department();

         Employee employee = new Employee();
         employee.setIdentification(identification);

         entityManager.persist(employee);

         it.setName("Magic Department");
         it.getStaff().add(employee);
         it.setManager(employee);
         employee.setDepartment(it);
         entityManager.persist(it);

    }

}
