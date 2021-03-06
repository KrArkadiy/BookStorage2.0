package service;

import dao.PostDao;
import dao.daoImpl.PostDaoImpl;
import lombok.NoArgsConstructor;
import model.Post;

import java.util.List;

public class PostService {

    private PostDao postDao = new PostDaoImpl();

    public PostService() {

    }

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post getById(int id){
        return postDao.getById(id);
    }

    public List<Post> getAll(){
        return postDao.getAll();
    }

    public void savePost(Post post){
        postDao.save(post);
    }

    public void updatePost(Post post){
        postDao.update(post);
    }

    public void deletePost(int id){
        postDao.deleteById(id);
    }
}
