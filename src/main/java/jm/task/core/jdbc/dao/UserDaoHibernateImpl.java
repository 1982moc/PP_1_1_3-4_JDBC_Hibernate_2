package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
private final SessionFactory sessionFactory;
    public UserDaoHibernateImpl() {
this.sessionFactory = Util.getSessionFactory();
    }


    @Override
    public void createUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaDelete<User> delete = criteriaBuilder.createCriteriaDelete(User.class);
            Root<User> root = delete.from(User.class);

            session.createQuery(delete).executeUpdate();

            transaction.commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);

            session.save(user);

            transaction.commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }

            transaction.commit();
        }
    }

    @Override
    public List<User> getAllUsers()
    {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }



    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery("DELETE FROM User").executeUpdate();

            transaction.commit();
        }
    }
}
