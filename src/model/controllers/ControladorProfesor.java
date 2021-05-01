package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Materia;
import model.entities.Profesor;
import model.entities.Tipologiasexo;

public class ControladorProfesor {
	private static ControladorProfesor instance = null;
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("centroEducativo");
	
	public ControladorProfesor() {
		super();
	}
	
	public static ControladorProfesor getInstance() {
		if (instance == null)
			instance = new ControladorProfesor();
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public Profesor findUltimo() {
		Profesor profe = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id desc limit 1",Profesor.class);
		profe = (Profesor) q.getSingleResult();
		em.close();
		return profe;
	}
	
	
	public Profesor findPrimero() {
		Profesor profe = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id limit 1",Profesor.class);
		profe = (Profesor) q.getSingleResult();
		em.close();
		return profe;
	}
	
	/**
	 * @return
	 */
	public Profesor findSiguiente(int idActual) {
		if (idActual != findUltimo().getId()) {
			Profesor profe = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.profesor"
					+ " where id > ? order by id limit 1", Profesor.class);
			q.setParameter(1, idActual);
			profe = (Profesor) q.getSingleResult();
			em.close();

			return profe;
		} else
			return findUltimo();
	}
	
	/**
	 * @return
	 */
	public Profesor findAnterior(int idActual) {
		if (idActual != findPrimero().getId()) {
			Profesor profe = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.profesor"
					+ " where id < ? order by id desc limit 1",Profesor.class);
			q.setParameter(1, idActual);
			profe = (Profesor) q.getSingleResult();
			em.close();

			return profe;
		} else
			return findPrimero();
	}
	
	
	public boolean guardar(Profesor profe) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (profe.getId() == 0) {
				em.persist(profe);
			} else {
				em.merge(profe);
			}
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al guardar Profesor");
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param profe
	 * @return
	 */
	public boolean borrar(Profesor profe) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if(!em.contains(profe))
				profe = em.merge(profe);
			em.remove(profe);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	public List<Tipologiasexo> findAllSexo() {
		List<Tipologiasexo> sexos = new ArrayList<Tipologiasexo>();
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM tipologiasexo", Tipologiasexo.class);
		sexos = q.getResultList();
		em.close();
		return sexos;
	}
	
	public List<Profesor> findAll() {
		List<Profesor> profesores = new ArrayList<Profesor>();
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
		profesores = q.getResultList();
		em.close();
		return profesores;
	}
	

	
}
