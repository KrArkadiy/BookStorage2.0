package dao.daoImpl;

import dao.PostDao;
import model.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PostDaoImpl implements PostDao {
    @Override
    public Post getById(Integer integer) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Post.class, integer);
    }

    @Override
    public List<Post> getAll() {
        return (List<Post>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM posts").list();
    }

    @Override
    public void update(Post post) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(post);
        tx1.commit();
        session.close();
    }

    @Override
    public void save(Post post) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(post);
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
