/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import bean.Compte;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import service.CompteFacade;

/**
 *
 * @author Marouane elmoussafer
 */
@Named(value = "compteControler")
@SessionScoped
public class CompteControler implements Serializable {

    private Compte selected ;
    private List<Compte> items;
    @EJB
    private CompteFacade ejbFacade;
    private Double montant;
    public String create(){
        initParam();
        ejbFacade.create(selected);
        return null;
        
    }
    private void initParam(){
        selected= new Compte();
    }
public String  debiter(){
    int res = ejbFacade.debiter(selected.getId(),montant);
    if (res>0){
        initParam();
        return "/compte/List";
    }
    else{
    return null;
    }
}
    public Compte getSelected() {
        if(selected==null){
            selected = new Compte();
        }
        return selected;
    }

    public void setSelected(Compte selected) {
        this.selected = selected;
    }

    public List<Compte> getItems() {
        items= ejbFacade.findAll();
        return items;
    }

    public void setItems(List<Compte> items) {
        this.items = items;
    }

    public CompteFacade getEjbFacade() {
        return ejbFacade;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public void setEjbFacade(CompteFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
    
    
    
    /**
     * Creates a new instance of CompteControler
     */
    public CompteControler() {
    }
    
}
