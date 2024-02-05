/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.model.Repositorys;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;
import ru.pazdrin.store.resources.model.entitys.Type;

/**
 *
 * @author nikit
 */
public class TypeRepository {

    @Transactional
    public void create(Type type){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        em.persist(type);
        em.flush();
        em.close();
        emf.close();
    }

    public List<Type> getAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT t.id, t.name FROM Type t");
        List<Type> res = q.getResultList();
        em.close();
        emf.close();
        return res;
    }
}   
