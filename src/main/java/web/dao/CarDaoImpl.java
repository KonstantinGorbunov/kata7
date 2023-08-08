package web.dao;

import web.model.Car;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{
    private SessionFactory sessionFactory;

    @Override
    public List<Car> getCarList(Integer count) {
        Query<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        if (count != null && count < 5) {
            query.setMaxResults(count);
        }
        return query.getResultList();
    }

    @Override
    public void addCar(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.save(car);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
