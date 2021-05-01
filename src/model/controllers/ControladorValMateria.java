package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Tipologiasexo;
import model.entities.ValoracionMateria;

public class ControladorValMateria {
	private static ControladorValMateria instance = null;
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("centroEducativo");
	
	public static ControladorValMateria getInstance() {
		if (instance == null)
			instance = new ControladorValMateria();
		return instance;
	}
	
	public List<ValoracionMateria> findAll(){
		List<ValoracionMateria> listaVals = new ArrayList<ValoracionMateria>();
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria", ValoracionMateria.class);
		listaVals = q.getResultList();
		em.close();
		return listaVals;
	}
	
	public boolean guardar(ValoracionMateria valMat) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (valMat.getId() == 0) {
				em.persist(valMat);
			} else {
				em.merge(valMat);
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
	
}
