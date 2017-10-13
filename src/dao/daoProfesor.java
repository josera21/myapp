package dao;

import modelo.Profesor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import SessionHibernate.Sesion;

public class daoProfesor {
	private Sesion sesion;
	
	public void guardarProfesor(Profesor prof) throws Exception {
		@SuppressWarnings("static-access")
		Session em = sesion.getSession();
		Transaction tx = null;
		try {
			tx = em.beginTransaction();
			em.save(prof);
			tx.commit();
		} catch (Exception ex){
			tx.rollback();
			ex.printStackTrace();
			throw ex;
		} finally {
			em.close();
		}
	}
}
