package ru.pazdrin.store.resources.model.Repositorys;

import java.util.List;

import com.google.gson.JsonElement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ru.pazdrin.store.resources.model.entitys.Basket;
import ru.pazdrin.store.resources.model.entitys.BasketProduct;


public class BasketRepository {

    public List getAll(Integer user_id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        //"SELECT bp from BasckeProduct bp, Bascket b WHERE b.user_id = "+user_id+" AND b.id = bp.basket_id" 
        List<BasketProduct> res = null;
        try{
            Query q = em.createQuery("SELECT bp from BasketProduct bp, Basket b WHERE b.user_id = "+user_id+" AND b.id = bp.basket_id");
            res = q.getResultList();
        }
        catch(Exception e){
            res  = null;
        }
        finally{
            em.close();
            emf.close();
        }
        return res;   
    }

    @Transactional
    public String addNew(Integer user_id, Integer product_id, Integer count){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT b from Basket b WHERE b.user_id = "+user_id+"");
        List<Basket> baskets;
        String status = "";
        try{
            baskets = q.getResultList();
            Query query = em.createQuery("SELECT bp FROM BasketProduct bp WHERE bp.basket_id = "+baskets.get(0).getId()+"");
            List<BasketProduct> oldBasketProducts = query.getResultList();
            BasketProduct bp = null;
            for (BasketProduct bpi : oldBasketProducts){
                if(bpi.getProductId()==product_id){
                    bp = bpi;
                    break;
                }
            }
            if(bp != null){
                bp.setCount(bp.getCount()+count);
                if(bp.getCount()<=0){
                    em.createQuery("DELETE from BasketProduct bp WHERE bp.basket_id = "+baskets.get(0).getId()+" AND bp.product_id ="+product_id+"").executeUpdate();
                    em.flush();
                }
                else{
                    em.persist(bp);
                    em.flush();
                }  
            }
            else{
                
                bp = new BasketProduct();
                bp.setProductId(product_id);
                bp.setBascetId(baskets.get(0).getId());
                bp.setCount(count);
                em.persist(bp);
                em.flush();
            }
            status = "Ok";
        }
        catch(Exception e){
            status = "Error: Can't add product to basket";
        }
        finally{
            em.close();
            emf.close();
        }   
        return status;
    }

    @Transactional
    public String remove(Integer user_id, int product_id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HookahMafia_Unit");
        EntityManager em = emf.createEntityManager();
        Basket basket = (Basket)em.createQuery("SELECT b from Basket b WHERE b.user_id = "+user_id+"").getResultList().get(0);
        String status = "";
        try{
            em.createQuery("DELETE from BasketProduct bp WHERE bp.basket_id = "+basket.getId()+" AND bp.product_id ="+product_id+"").executeUpdate();
            em.flush();
            status = "Ok";
        }
        catch(Exception e){
           status = "Error: Can't Delete product from basket";
        }   
        finally{
            em.close();
            emf.close();
        }
        return status;
    }

}
