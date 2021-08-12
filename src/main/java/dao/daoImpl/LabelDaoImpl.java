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
    public Label update(Label label) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(label);
        tx1.commit();
        session.close();
        return getById(label.getId());
    }

    @Override
    public Label save(Label label) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(label);
        tx1.commit();
        session.close();
        return label;
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
