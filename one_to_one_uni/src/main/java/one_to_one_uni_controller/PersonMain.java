package one_to_one_uni_controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_uni_dto.AdharCard;
import one_to_one_uni_dto.Person;

public class PersonMain {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		AdharCard adharCard=new AdharCard();
		adharCard.setAdhar_id(121);
		adharCard.setName("Shobhitha");
		adharCard.setAddress("HAssan");
		
		Person person=new Person();
		person.setId(1);
		person.setName("Shobhitha");
		person.setPhone(8296279297l);
		person.setAdharCard(adharCard);
		person.setAddress("Hassan");
		
		entityTransaction.begin();
		entityManager.persist(adharCard);
		entityManager.persist(person);
		entityTransaction.commit();
		
	}
}
