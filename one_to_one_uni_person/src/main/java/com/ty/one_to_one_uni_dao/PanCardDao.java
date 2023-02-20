package com.ty.one_to_one_uni_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_one_uni_dto.PanCard;

public class PanCardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	//to save
	public void savePanCard(PanCard panCard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(panCard);
		entityTransaction.commit();
	}
	
	//to update
	public void updatePanCard(String panNo,String holder) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		PanCard panCard=entityManager.find(PanCard.class, panNo);
		entityTransaction.begin();
		entityManager.merge(panCard);
		entityTransaction.commit();
		
	}
	
	//to delete
	public void deletePanCard(String panNo) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		PanCard panCard=entityManager.find(PanCard.class, panNo);
		
		if(panCard!=null) {
			entityTransaction.begin();
			entityManager.remove(panCard);
			entityTransaction.commit();
		}
		else
			System.out.println("incoorect pan number");	
	}
	
	//to get particular
	public PanCard getOnePanCard(String panNo) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		PanCard panCard=entityManager.find(PanCard.class, panNo);
		return panCard;
	}
	
	//to get all
	public List<PanCard> getAllPanCard(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select pan from PanCard pan");
		List<PanCard> list=query.getResultList();
		return list;
	}
	
	
}
