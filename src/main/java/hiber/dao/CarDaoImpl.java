package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Gaziz Bakyt
 */
@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> typedQuery = sessionFactory.getCurrentSession().createQuery("from Car");
        return typedQuery.getResultList();
    }
}
