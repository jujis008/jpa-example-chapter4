package org.example.model.map;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;

import org.example.model.Employee;

@Entity
public class Customer {

    @Id
    private int id;

    @ElementCollection(targetClass = Double.class)
    @CollectionTable(name = "cliente_cartao", 
        joinColumns = {@JoinColumn(name = "id_cliente") })
    @MapKeyJoinColumn(name = "id_cartao")
    @MapKeyClass(CrediCard.class)
    @Column(name = "saldo")
    private Map<CrediCard, Double> cards;

    @OneToMany
    @MapKeyColumn(name = "id_item_compra")
    @JoinTable(name = "cliente_itens_comprados", 
        joinColumns = {@JoinColumn(name = "id_cliente") }, 
        inverseJoinColumns = {@JoinColumn(name = "id_da_compra") })
    @JoinColumn(name = "item_da_compra")
    private Map<Double, Item> compras;

    @ElementCollection
    @Column(name = "apelidos")
    @CollectionTable(name = "cliente_jocosidades", 
            joinColumns = {
                    @JoinColumn(name = "id_cliente") 
                    })
    private List<String> nickname;

    @OneToMany
    @JoinTable(name = "tudo_entidade", 
        joinColumns = @JoinColumn(name = "id_cliente"),
        inverseJoinColumns=@JoinColumn(name="id_item"))
    @MapKeyJoinColumn(name="id_empregado")
    private Map<Employee, Item> seila;
    
    
    @ElementCollection
    @CollectionTable(name="EMP_PHONE", joinColumns=@JoinColumn(name="id_customer"))
    @MapKeyColumn(name="PHONE_TYPE")
    @Column(name="PHONE_NUM")
    private Map<String, String> phoneNumbers;
    
    @ElementCollection
    @CollectionTable(name="EMP_PHONE_ENUM", joinColumns=@JoinColumn(name="id_customer"))
    @MapKeyColumn(name="PHONE_TYPE")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name="PHONE_NUM")
    private Map<PhoneType, String> phones;

}
