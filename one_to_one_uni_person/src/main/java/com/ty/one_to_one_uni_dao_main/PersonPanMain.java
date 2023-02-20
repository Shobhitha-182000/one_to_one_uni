package com.ty.one_to_one_uni_dao_main;

import java.util.Scanner;

import com.ty.one_to_one_uni_dao.PanCardDao;
import com.ty.one_to_one_uni_dao.PersonDao;
import com.ty.one_to_one_uni_dto.PanCard;
import com.ty.one_to_one_uni_dto.Person;

public class PersonPanMain {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Person person =new Person();
		PersonDao personDao=new PersonDao();
		PanCard panCard=new PanCard();
		PanCardDao panDao=new PanCardDao();
		
		boolean flag=true;
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
				
				System.out.println("enter the age");
				int age=scanner.nextInt();
				
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setAge(age);
				
				System.out.println("enter the pan number");
				String panNo=scanner.next();
				
				System.out.println("enter the holder name");
				String holder_name=scanner.next();
				
				System.out.println("enter the address");
				String address1=scanner.next();
				
				panCard.setPanNo(panNo);
				panCard.setHolder_name(holder_name);
				panCard.setAddress(address1);
				
				person.setPanCard(panCard);
				personDao.savePerson(person);
			}break;
			case 2:{
				System.out.println("enter the id for the update");
				int id=scanner.nextInt();
				
				System.out.println("enter the name to be update");
				String name=scanner.next();
				
				person.setName(name);
				personDao.updatePerson(id, name);
				System.out.println("========UPDATED SUCCESFULLY=========");
				
				System.out.println("do you want to update pancard also click on \n 1.for yes \n 2.no");
				int select=scanner.nextInt();
				
				switch (select) {
				case 1:{
					System.out.println("enter the pan number");
					String panNo=scanner.next();
					
					System.out.println("enter the holder name");
					String holder_name=scanner.next();
					
					panCard.setHolder_name(holder_name);
					panDao.updatePanCard(panNo, holder_name);
					System.out.println("========UPDATED SUCCESFULLY=========");
					
				}break;
				case 2:{
					flag=false;
				}break;
				default:
					flag=false;
					break;
				}
				
			}break;
			case 3:{
				System.out.println("enter the id to be delete");
				int id=scanner.nextInt();
				personDao.removePerson(id);
				System.out.println("========DELETTED SUCCESFULLY=========");
				
				System.out.println("do you want to delete pancard also click on \n 1.for yes \n 2.no");
				int select=scanner.nextInt();
				
				switch (select) {
				case 1:{
					System.out.println("enter the pan number");
					String panNo=scanner.next();
					
					panDao.deletePanCard(panNo);;
					System.out.println("========DELETTED SUCCESFULLY=========");
					
				}break;
				case 2:{
					flag=false;
				}break;
				default:
					flag=false;
					break;
				}
				
			}break;
			case 4:{
				System.out.println("enter the id ");
				int id=scanner.nextInt();
				System.out.println(personDao.getPerson(id));
				
				System.out.println("do you want particular person pancard details also click on \n 1.for yes \n 2.no");
				int select=scanner.nextInt();
				
				switch (select) {
				case 1:{
					System.out.println("enter the pan number");
					String panNo=scanner.next();
					System.out.println( panDao.getOnePanCard(panNo));
					 
				}break;
				case 2:{
					flag=false;
				}break;
				default:
					flag=false;
					break;
				}
				
			}break;
			case 5:{
				System.out.println(personDao.getAllPerson());
				System.out.println("do you want only  pancard details also click on \n 1.for yes \n 2.no");
				int select=scanner.nextInt();
				
				switch (select) {
				case 1:{
					System.out.println( panDao.getAllPanCard());
				}break;
				case 2:{
					flag=false;
				}break;
				default:
					flag=false;
					break;
				}
				
			}break;
			case 6:{
					System.out.println("THANK YOU");
					flag=false;
			}break;
			default:
				break;
			}
			
		}while(flag);
	}
}
