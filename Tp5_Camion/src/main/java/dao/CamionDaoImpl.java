package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Camion;
import util.JpaUtil;
public class CamionDaoImpl implements ICamionDao {
	private EntityManager entityManager=JpaUtil.getEntityManager("TP5_Camion");
@Override
public Camion save(Camion p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(p);
	tx.commit();
	return p;
	}
@Override
public List<Camion> camionsParMC(String mc) {
	List<Camion> prods = entityManager.createQuery("select p from Camion p where p.nomCamion like :mc").setParameter("mc", "%"+mc+"%").getResultList();

			return prods;
			}
@Override
public Camion getCamion(Long id) {
	return entityManager.find(Camion.class, id);
	}

@Override
public Camion updateCamion(Camion p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(p);
	tx.commit();
	return p;
	}
@Override
public void deleteCamion(Long id) {

	Camion camion = entityManager.find(Camion.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(camion);
	entityManager.getTransaction().commit();
	}

}