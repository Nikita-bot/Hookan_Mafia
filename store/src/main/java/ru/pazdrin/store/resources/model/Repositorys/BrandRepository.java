/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.model.Repositorys;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ru.pazdrin.store.resources.model.entitys.Brand;

/**
 *
 * @author nikit
 */
public class BrandRepository {
    @Transactional
    public void create(Brand brand){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        em.persist(brand);
        em.flush();
        em.close();
        emf.close();
    }

    public List<String> getAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT b.id, b.name FROM Brand b");
        List<String> res = q.getResultList();
        em.close();
        emf.close();
        return res;
    }
}
