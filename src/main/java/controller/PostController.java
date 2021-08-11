package controller;

import dao.daoImpl.PostDaoImpl;
import model.Post;
import service.PostService;

import java.util.List;

public class PostController {

    private PostService postService;

    private PostDaoImpl postDao;

    public PostController(PostDaoImpl postDao) {
        this.postDao = postDao;
    }

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public Post getPostById(int id){
        return postService.getById(id);
    }

    public List<Post> getAll(){
        return postService.getAll();
    }

    public void savePost(Post post){
        postService.savePost(post);
    }

    public void updatePost(Post post){
        postService.updatePost(post);
    }

    public void deletePostById(int id){
        postService.deletePost(id);
    }
}
