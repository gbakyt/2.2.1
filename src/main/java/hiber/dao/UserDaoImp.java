package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

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
    public void deleteAllUsers() {
        List<User> userList = listUsers();
        for (User user : userList) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public User findOwner(String car_name, String car_series) {
        TypedQuery<User> findUserQuery = sessionFactory.getCurrentSession()
                .createQuery("select user from User user where " +
                        "user.car.name = :car_name and user.car.series = :car_series")
                .setParameter("car_name", car_name)
                .setParameter("car_series", car_series);
        return findUserQuery.getSingleResult();
    }

}
