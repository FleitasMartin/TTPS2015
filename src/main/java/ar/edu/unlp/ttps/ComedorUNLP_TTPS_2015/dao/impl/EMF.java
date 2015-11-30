package ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.dao.impl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	
	private static final EntityManagerFactory em = Persistence
			//.createEntityManagerFactory("ar.edu.unlp.ttps.ComedorUNLP_TTPS_2015.model");
					.createEntityManagerFactory("ComedorUNLP_TTPS_2015");

	public static EntityManagerFactory getEMF() {
		System.out.println(em);
		return em;
	}
}
