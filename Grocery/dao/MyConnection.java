package com.gms.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyConnection 
{

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	
	public static EntityManager getEntitymanager()
	{
		if(emf == null) 
		{
			emf = Persistence.createEntityManagerFactory("keerthi");
			em = emf.createEntityManager();
		 }
		return em;
	 }

}
