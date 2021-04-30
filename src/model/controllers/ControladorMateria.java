package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Materia;

public class ControladorMateria {
	private static ControladorMateria instance = null;
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("centroEducativo");
	
	public static ControladorMateria getInstance() {
		if (instance == null)
			instance = new ControladorMateria();
		return instance;
	}
	
	public List<Materia> findAll() {
		List<Materia> materias = new ArrayList<Materia>();
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);
		materias = q.getResultList();
		em.close();
		return materias;
	}
	
	
}
