package com.homework.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homework.entity.Offer;

@Repository
public class OfferDaoImpl implements OfferDao {
	@Autowired
	SessionFactory sessionFactory;

	// add row
	@Override

	public void addOffer(Offer offer) {
		Session session = sessionFactory.openSession();
		System.out.println("object of addoffer method " + session);
		session.beginTransaction();
		session.save(offer);
		session.getTransaction().commit();
		session.close();
	}

	// get all row
	@Override

	public List<Offer> getAllOffer() {
		Session session = sessionFactory.openSession();

		System.out.println("object of getAllOffer method" + session);
		//List<Offer> all = session.createQuery("from Offer").getResultList();
		List<Offer> all =session.createNamedQuery("findBy", Offer.class).list();
		return all;
	}

	// get particular offer
	@Override

	public Offer getSingleOffer(int id) {
		Session session = sessionFactory.openSession();
		System.out.println("object of getSingleOffer method " + session);
		Offer offer = session.get(Offer.class, id);
		return offer;
	}

	// delete particular offer
	@Override

	public void deleteOffer(int id) {

		Session session = sessionFactory.openSession();
		Offer offer = session.get(Offer.class, id);
		session.beginTransaction();

		session.delete(offer);
		session.getTransaction().commit();
		session.close();
	}

	// get update
	@Override

	public void update(Offer offer) {
		Session session = sessionFactory.openSession();
		System.out.println("object of update method " + session);
		session.beginTransaction();
		session.update(offer);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Offer> getSearchByName(String companyName) {
		Session session = sessionFactory.openSession();
		Query<Offer> query = session.createNamedQuery("findBy.app", Offer.class);
		query.setParameter("offerDetails", companyName);
		List<Offer> offerResult = query.list();
		return offerResult;
	}

	@Override
	public List<Offer> findPaginated(int pageNo, int pageSize) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        Criteria criteria = session.createCriteria(Offer.class);
        criteria.setFirstResult(pageNo * pageSize);
        criteria.setMaxResults(pageSize);
        List<Offer> list = criteria.list();
		return list;
	}
}