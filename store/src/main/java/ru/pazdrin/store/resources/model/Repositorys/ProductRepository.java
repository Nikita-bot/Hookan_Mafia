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
import ru.pazdrin.store.resources.model.entitys.Product;

/**
 *
 * @author nikit
 */
public class ProductRepository {
    
    @Transactional
    public void create(Product p){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        em.persist(p);
        em.flush();
        em.close();
        emf.close();

    }

    public List<Product> getAll(Integer type_id,Integer brand_id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        if(type_id == null && brand_id==null){
            Query q = em.createQuery("SELECT p.id, p.name,p.price,p.img,b.name,t.name,p.strength, p.description FROM Product p, Brand b, Type t WHERE p.brand_id = b.id AND p.type_id = t.id");
            List<Product> res = q.getResultList();
            em.close();
            emf.close();
            return res;
        }
        else if (type_id != null && brand_id==null){
            Query q = em.createQuery("SELECT p.id, p.name,p.price,p.img,b.name,t.name,p.strength, p.description FROM Product p, Brand b, Type t WHERE p.brand_id = b.id AND p.type_id = t.id AND t.id="+type_id+"");
            List<Product> res = q.getResultList();
            em.close();
            emf.close();
            return res;
        }
        else if(type_id == null && brand_id!=null){
            Query q = em.createQuery("SELECT p.id, p.name,p.price,p.img,b.name,t.name,p.strength, p.description FROM Product p, Brand b, Type t WHERE p.brand_id = b.id AND p.type_id = t.id AND b.id="+brand_id+"");
            List<Product> res = q.getResultList();
            em.close();
            emf.close();
            return res;
        }
        else{
            Query q = em.createQuery("SELECT p.id, p.name,p.price,p.img,b.name,t.name,p.strength, p.description FROM Product p, Brand b, Type t WHERE p.brand_id = b.id AND p.type_id = t.id AND t.id="+type_id+" AND b.id="+brand_id+"");
            List<Product> res = q.getResultList();
            em.close();
            emf.close();
            return res;
        }
        
    }

    public Product getOne(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Product p WHERE p.id = "+id+"");
        List<Product> res = q.getResultList();
        em.close();
        emf.close();
        return res.get(0);
    }
}
