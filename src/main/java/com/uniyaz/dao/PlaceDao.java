package com.uniyaz.dao;

import com.uniyaz.domain.Place;
import com.uniyaz.domain.User;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PlaceDao {

    public Place savePlace(Place place){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            place = (Place) session.merge(place);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return place;
    }
    public List<Place> getAllPlaces(){
        List<Place> placeList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select place From Place place left  join fetch place.user user";
            Query query = session.createQuery(hql);
            placeList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return placeList;
    }

    public List<Place> getPlacesByName(String placename){
        List<Place> placeList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select distinct place From Place place left  join fetch place.user user where place.name = :name";

            Query query = session.createQuery(hql);
            query.setParameter("name",placename);

            placeList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return placeList;
    }

    public List<Place> getTreePlacesOrderByMaxPoint(){
        List<Place> placeList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select place From Place place left  join fetch place.user user order by place.puan desc";

            Query query = session.createQuery(hql).setMaxResults(3);
            placeList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return placeList;
    }
  }
