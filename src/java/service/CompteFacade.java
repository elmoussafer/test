/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marouane elmoussafer
 */
@Stateless
public class CompteFacade extends AbstractFacade<Compte> {

    @PersistenceContext(unitName = "testJEE_comptePU")
    private EntityManager em;
public int debiter(String idCompte ,Double montant){
    Compte compte = find(idCompte);
    if (compte.getSolde()<montant){
        return -1;
    }
    compte.setSolde(compte.getSolde()-montant);
    edit(compte);
    return 1;
    
}
public int crediter(String idCompte ,Double montant){
    Compte compte = find(idCompte);
    if (montant == null){
        return -1;
    }
    compte.setSolde(compte.getSolde()+montant);
    edit(compte);
    return 1;
    
}
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteFacade() {
        super(Compte.class);
    }
    
}
