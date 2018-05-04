/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Charana
 */
@Local
public interface TestRecipeFacadeLocal {

    void create(TestRecipe testRecipe);

    void edit(TestRecipe testRecipe);

    void remove(TestRecipe testRecipe);

    TestRecipe find(Object id);

    List<TestRecipe> findAll();
    
    List<TestRecipe> findRange(int[] range);

    int count();
    
    List<TestRecipe> findbyid(String id);

    void addRecipe(String ID, String NAME);
    
}
