/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Charana
 */
@Entity
@Table(name = "TEST_RECIPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestRecipe.findAll", query = "SELECT t FROM TestRecipe t")
    , @NamedQuery(name = "TestRecipe.findByRecipeId", query = "SELECT t FROM TestRecipe t WHERE t.recipeId = :recipeId")
    , @NamedQuery(name = "TestRecipe.findByRecipeName", query = "SELECT t FROM TestRecipe t WHERE t.recipeName = :recipeName")})
public class TestRecipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RECIPE_ID")
    private String recipeId;
    @Size(max = 255)
    @Column(name = "RECIPE_NAME")
    private String recipeName;

    public TestRecipe() {
    }

    public TestRecipe(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeId != null ? recipeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestRecipe)) {
            return false;
        }
        TestRecipe other = (TestRecipe) object;
        if ((this.recipeId == null && other.recipeId != null) || (this.recipeId != null && !this.recipeId.equals(other.recipeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.TestRecipe[ recipeId=" + recipeId + " ]";
    }
    
}
