package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Entity(name="parking_space")
public class ParkingSpace {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    //Sem isso, tambem será criado uma chave estrangeira na tabela parking_space 
    @OneToOne(mappedBy="parkingSpace")
    private Employee owner;

}
