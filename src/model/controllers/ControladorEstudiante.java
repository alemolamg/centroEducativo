package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Tipologiasexo;

public class ControladorEstudiante {
	private static ControladorEstudiante instance = null;
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("centroEducativo");
	
	public ControladorEstudiante() {
		super();
	}
	
	public static ControladorEstudiante getInstance() {
		if (instance == null)
			instance = new ControladorEstudiante();
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public Estudiante findUltimo() {
		Estudiante estudiante = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.Estudiante order by id desc limit 1",Estudiante.class);
		estudiante = (Estudiante) q.getSingleResult();
		em.close();
		return estudiante;
	}
	
	
	public Estudiante findPrimero() {
		Estudiante estudiante = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.Estudiante order by id limit 1",Estudiante.class);
		estudiante = (Estudiante) q.getSingleResult();
		em.close();
		return estudiante;
	}
	
	/**
	 * @return
	 */
	public Estudiante findSiguiente(int idActual) {
		if (idActual != findUltimo().getId()) {
			Estudiante estudiante = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.Estudiante"
					+ " where id > ? order by id limit 1", Estudiante.class);
			q.setParameter(1, idActual);
			estudiante = (Estudiante) q.getSingleResult();
			em.close();

			return estudiante;
		} else
			return findUltimo();
	}
	
	/**
	 * @return
	 */
	public Estudiante findAnterior(int idActual) {
		if (idActual != findPrimero().getId()) {
			Estudiante estudiante = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.Estudiante"
					+ " where id < ? order by id desc limit 1",Estudiante.class);
			q.setParameter(1, idActual);
			estudiante = (Estudiante) q.getSingleResult();
			em.close();

			return estudiante;
		} else
			return findPrimero();
	}
	
	
	public boolean guardar(Estudiante estudiante) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (estudiante.getId() == 0) {
				em.persist(estudiante);
			} else {
				em.merge(estudiante);
			}
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al guardar un Fabricante");
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param estudiante
	 * @return
	 */
	public boolean borrar(Estudiante estudiante) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if(!em.contains(estudiante))
				estudiante= em.merge(estudiante);
			em.remove(estudiante);
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
	
	public List<Estudiante> findAll() {
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
		estudiantes = q.getResultList();
		em.close();
		return estudiantes;
	}
	
	
}
