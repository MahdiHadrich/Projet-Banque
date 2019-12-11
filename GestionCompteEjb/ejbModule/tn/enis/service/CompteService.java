package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.enis.dao.CompteDao;
import tn.enis.entity.CompteBancaire;

/**
 * Session Bean implementation class CompteService
 */
@Stateless
@LocalBean
public class CompteService {
	@EJB
    private CompteDao compteDao;
    public CompteService() {
        // TODO Auto-generated constructor stub
    }
    public void save(CompteBancaire compte) {
    	compteDao.save(compte);
    }
    public void delete(Long rib) {
    	compteDao.delete(rib);}
    
    public void update(CompteBancaire compte) {
    	compteDao.update(compte);}
    
    
    public List <CompteBancaire> getAll(){
 	 return compteDao.getAll();
    }
	
    public CompteBancaire getById(Long rib) {
		 CompteBancaire c=compteDao.getById(rib);
		return c;
	}
    
	

}
