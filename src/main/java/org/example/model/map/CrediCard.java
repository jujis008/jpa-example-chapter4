package org.example.model.map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CrediCard {
    
    @Id
    private int id;
    
    private double saldo;

}
