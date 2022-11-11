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
import ru.pazdrin.store.resources.model.entitys.Basket;
import ru.pazdrin.store.resources.model.entitys.User;

/**
 *
 * @author nikit
 */
public class UserRepository {
    
    @Transactional
    public User create(User user){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        em.persist(user);
        em.flush();
        Basket basket = new Basket();
        int id = this.getUserByPhone(user.getPhone());
        basket.setUserId(id);
        em.persist(basket);
        em.flush();
        em.close();
        emf.close();
        user.setId(id);
        return user;
    }

    public Integer getUserByPhone(String phone){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT u.id FROM User u WHERE u.phone = '"+phone+"'");

        List<Integer> id;
        Integer result = 0;
        try{
            id = q.getResultList();
            result = id.get(0);
            
        }
        catch(Exception e){
            result = 0;
        }
        finally{
            em.close();
            emf.close();
        }   
        return result;
    }

    public User getUser(String phone,String pass){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT u FROM User u WHERE u.phone = "+phone+" AND u.password = "+pass+"");
        List<User> users;
        User result;        
        try{
            users = q.getResultList();
            result = users.get(0);
        }
        catch(Exception e){
            System.out.println("Error get user by phone and password");
            result = null;
        }   
        finally{
            em.close();
            emf.close();
        }
        return result;
    }

    public User getUserById(Integer id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        User result = null;
        try{
            result = em.find(User.class, id);
            
        }
        catch(Exception e){
        
            result =  null;
        }
        finally{
            em.close();
            emf.close();
        }
        return result;
    }
}
