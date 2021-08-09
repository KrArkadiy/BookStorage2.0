package dao.daoImpl;

import dao.WriterDao;
import model.Writer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class WriterDaoImpl implements WriterDao {
    @Override
    public Writer getById(Integer integer) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Writer.class, integer);
    }

    @Override
    public List<Writer> getAll() {
        return (List<Writer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM writers").list();
    }

    @Override
    public void update(Writer writer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(writer);
        tx1.commit();
        session.close();
    }

    @Override
    public void save(Writer writer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(writer);
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
