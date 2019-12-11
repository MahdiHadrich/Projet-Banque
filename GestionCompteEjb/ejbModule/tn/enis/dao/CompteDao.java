package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.CompteBancaire;

/**
 * Session Bean implementation class CompteDao
 */
@Singleton
@LocalBean
public class CompteDao {
	@PersistenceContext
	private EntityManager entityManager;

   public void save(CompteBancaire compte) {
	   entityManager.persist(compte);	   
   }
   public void delete(Long rib) {
	  // entityManager.get
	  // entityManager.remove(compte);
	   entityManager.remove(getById(rib));
	   
   }
   public CompteBancaire getById(Long rib) {
	
	return (entityManager.find(CompteBancaire.class, rib));
}
   public void update(CompteBancaire compte) {
	   entityManager.merge(compte);
   }
public List <CompteBancaire> getAll(){
	   return entityManager.createQuery("from CompteBancaire",CompteBancaire.class).getResultList();
   }

   
}
