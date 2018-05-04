/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Charana
 */
@Stateless
public class TestRecipeFacade extends AbstractFacade<TestRecipe> implements TestRecipeFacadeLocal {

    @PersistenceContext(unitName = "recipeproject-ejbPU")
    private EntityManager em;

    private List<TestRecipe> recps;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestRecipeFacade() {
        super(TestRecipe.class);
    }
    
    
    @Override
    public void addRecipe(String ID, String NAME) {
        TestRecipe rcp = new TestRecipe();
        rcp.setRecipeId(ID);
        rcp.setRecipeName(NAME);
        em.persist(rcp);
    }
    
    public List<TestRecipe> findbyid(String id)
    {
        System.out.println("INSIDE FACADE");
        String iid = id;
        recps = em.createNamedQuery("TestRecipe.findByRecipeId").setParameter("recipeId", iid).getResultList();
        System.out.println(recps.get(0).getRecipeName());
        return recps;
    }
    
}
