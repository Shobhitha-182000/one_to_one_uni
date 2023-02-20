package com.ty.one_to_one_uni_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	//to save
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(person.getAdharCard());
		entityTransaction.commit();
	}
	
	//to update
	public void updatePerson(int id,String name) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person1=entityManager.find(Person.class, id);
		person1.setName(name);
		entityTransaction.begin();
		entityManager.merge(person1);
		entityManager.merge(person1.getAdharCard());
		entityTransaction.commit();
	}
	
	//to remove
	public void removePerson(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		 
		Person person=entityManager.find(Person.class, id);
		if(person!=null) {
			entityTransaction.begin();
			
			entityManager.remove(person);
			entityManager.remove(person.getAdharCard());
			entityTransaction.commit();	
		}
		else
			System.out.println("invalid");
		 
	}
	
	//to select 
	public Person getPerson(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);
		 
		return person;
	}
	
	//to select all
	public List<Person> getAllPerson(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Person e");
		List<Person> list=query.getResultList();
		return list;
	}
}
