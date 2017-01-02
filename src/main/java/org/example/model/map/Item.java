package org.example.model.map;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

@Entity
public class Item {

    @Id
    int id;

    @ElementCollection
    @MapKeyColumn(name = "IMAGE_NAME")
    @Column(name = "IMAGE_FILENAME")
    @CollectionTable(name = "IMAGE_MAPPING", joinColumns = @JoinColumn(name = "id_do_item"))
    private Map<String, String> images; // map
    
    
    
    
    
}