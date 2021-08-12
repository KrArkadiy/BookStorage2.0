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
        Writer receivedWriter = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Writer.class, integer);
        receivedWriter.getPosts();
        return receivedWriter;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers = (List<Writer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM writers").list();
        writers.stream().forEach(x-> x.getPosts());
        return writers;
    }

    @Override
    public Writer update(Writer writer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(writer);
        tx1.commit();
        session.close();
        return getById(writer.getId());
    }

    @Override
    public Writer save(Writer writer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(writer);
        tx1.commit();
        session.close();
        return writer;
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
