package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findUserByCarId(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                """
                        SELECT u
                          FROM User u
                         WHERE u.car.model=:carModel
                           AND u.car.series=:carSeries
                        """, User.class);
        query.setParameter("carModel", model);
        query.setParameter("carSeries", series);
        return query.getSingleResult();
    }
}
