package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
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
			System.out.println("Error al Guardar");
			return false;
		}
		return true;
	}
	
	public boolean buscarPorAlumno(Profesor pro,Estudiante est, Materia mat, int nota) {
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM valoracionmateria"
					+ "WHERE idProfesor = ? AND idEstudiante = ? AND idMateria = ? AND ROUND(valoracion) = ? ;", ValoracionMateria.class);
			q.setParameter(1, pro.getId());
			q.setParameter(2, est.getId());
			q.setParameter(3, mat.getId());
			q.setParameter(4, nota);
			
			if (q.getSingleResult() != null)
				return true;
			else
				return false;
		
		
	}
	
}
