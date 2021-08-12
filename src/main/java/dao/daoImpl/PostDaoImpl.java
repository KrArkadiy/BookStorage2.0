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
        Post recievedPost = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Post.class, integer);
        recievedPost.getLabels();
        return recievedPost;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = (List<Post>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM posts").list();
        posts.stream().forEach(x->x.getLabels());
        return posts;
    }

    @Override
    public Post update(Post post) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(post);
        tx1.commit();
        session.close();
        return getById(post.getId());
    }

    @Override
    public Post save(Post post) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(post);
        tx1.commit();
        session.close();
        return post;
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
