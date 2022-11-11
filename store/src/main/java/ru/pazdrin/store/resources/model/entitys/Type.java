package ru.pazdrin.store.resources.model.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "type", schema = "public")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "type_id_gen")
    @SequenceGenerator(name = "type_id_gen",sequenceName = "type_id_seq",initialValue = 1,allocationSize = 1)
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

    @Override
    public String toString() {
        
        return super.toString();
    }
}
