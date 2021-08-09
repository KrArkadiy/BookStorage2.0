package dao.daoImpl;

import dao.LabelDao;
import model.Label;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class LabelDaoImpl implements LabelDao {

    @Override
    public Label getById(Integer integer) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Label.class, integer);
    }

    @Override
    public List<Label> getAll() {
        return (List<Label>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From labels").list();
    }

    @Override
    public void update(Label label) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(label);
        tx1.commit();
        session.close();
    }

    @Override
    public void save(Label label) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(label);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteById(Integer integer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(getById(integer));
        tx1.commit();
        session.close();
    }
}
