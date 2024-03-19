package ru.pazdrin.store.resources.model.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "brand", schema = "public")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "brand_id_gen")
    @SequenceGenerator(name = "brand_id_gen",sequenceName = "brand_id_seq",initialValue = 1,allocationSize = 1)
    
    int id;
    @Column(name = "name")
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
