package com.skss.web.springmvc_login.dao.impl;

	import java.util.ArrayList;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.persistence.Query;

	import org.springframework.stereotype.Repository;

import com.skss.web.springmvc_login.dto.model.UserModel;


	@Repository
	public class UserDaoimpl {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Login");
		EntityManager entityManager=emf.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		
		public UserModel getUser(int id) {
			
			return entityManager.find(UserModel.class, id);
			
			
		}
		
      public String updateteUser(UserModel userModel ) {
			
			
			entityTransaction.begin();
			entityManager.merge(userModel);
			entityTransaction.commit();
			
			return "updated";
		
			//return null;
			
		}
		
		

		
		
		
		
		public String deleteUser(int id) {
			
			UserModel user=entityManager.find(UserModel.class,id);
			
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			
			return "Deleted";
		
			//return null;
			
		}
		

		
		public String saveUser(UserModel userModel) {
			
			
			entityTransaction.begin();
			entityManager.persist(userModel);
			entityTransaction.commit();
			return userModel.getName()+"is saved";
			
			
		}
		
		public ArrayList<UserModel> getAllUsers(){
			
			Query q=entityManager.createQuery("select u from UserModel u");
													//jpql query alias is mandatory
			
			
			
			return (ArrayList<UserModel>) q.getResultList();
			
			
		}
		
		

	}

	
	
	



