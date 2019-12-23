package com.uniyaz.dao;

import com.uniyaz.domain.Place;
import com.uniyaz.domain.User;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {

    public User saveUser(User user){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            user = (User) session.merge(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    public List<User> getAllUsers(){
        List<User> userList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select user From User user";
            Query query = session.createQuery(hql);
            userList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    public User checkExistUser(String userName, String password){
        User user = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select user From User user where user.name = :name and user.password= :password";

            Query query = session.createQuery(hql);
            query.setParameter("name",userName);
            query.setParameter("password",password);

            user =(User)query.getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }



}
