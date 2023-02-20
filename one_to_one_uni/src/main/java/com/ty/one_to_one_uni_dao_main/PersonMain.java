package com.ty.one_to_one_uni_dao_main;

import java.util.Scanner;

import com.ty.one_to_one_uni_dao.PersonDao;

import one_to_one_uni_dto.AdharCard;
import one_to_one_uni_dto.Person;

public class PersonMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		AdharCard adharCard=new AdharCard();
		PersonDao dao = new PersonDao();
		boolean flag = true;

		do {
			System.out.println(
					"choose the option \n 1.SavePerson \n 2.update Person \n 3.remove Person \n"
					+ " 4.getOne person 5.get all person details \n 6.exit");
			int choose=scanner.nextInt();

			switch (choose) {
			case 1:{
					System.out.println("enter the id");
					int id=scanner.nextInt();
					
					System.out.println("enter the name");
					String name=scanner.next();
					
					System.out.println("enter the phone number");
					long phone=scanner.nextLong();
					
					System.out.println("enter the address");
					String address=scanner.next();
					
					person.setId(id);
					person.setName(name);
					person.setPhone(phone);
					person.setAddress(address);
					
					System.out.println("enter the adhar id");
					int adhar_id=scanner.nextInt();
					
					System.out.println("enter the name");
					String adhar_name=scanner.next();
					
					System.out.println("enter the address");
					String adhar_address=scanner.next();
					
					adharCard.setAdhar_id(adhar_id);
					adharCard.setName(adhar_name);
					adharCard.setAddress(adhar_address);
					
					person.setAdharCard(adharCard);
					dao.savePerson(person);
				
			}break;
			case 2:{
				System.out.println("enter the id to be updated");
				int id=scanner.nextInt();
				
				System.out.println("enter the name to be updated");
				String name=scanner.next();
				
				person.setName(name);
				person.setId(id);
				dao.updatePerson(id,name);
				System.out.println("update succesfully");
				
			}break;
			case 3:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				
				person.setId(id);
				dao.removePerson(id);
			}break;
			case 4:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				
				person.setId(id);
				System.out.println(dao.getPerson(id));
				
				
			}break;
			case 5:{
				  System.out.println(dao.getAllPerson());
			}break;
			case 6:{
				System.out.println("Thank you ");
				flag=false;
			}break;
			default:
				flag=false;
				break;
			}

		} while (flag);

	}
}
