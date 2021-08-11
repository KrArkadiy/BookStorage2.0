package controller;

import dao.PostDao;
import model.Post;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.PostService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PostControllerTest {

    private final PostDao postDaoMock = Mockito.mock(PostDao.class);
    private final PostService postService = new PostService(postDaoMock);
    private final PostController postController = new PostController(postService);

    @Test
    void givenListOfPosts_whenRun_thenEqualListOfPostsReturned() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("First Content", 1L, 1L));
        posts.add(new Post("Second Content", 1L, 1L));

        when(postController.getAll()).thenReturn(posts);

        List<Post> testPosts = postDaoMock.getAll();

        assertEquals(posts, testPosts);
    }

    @Test
    void givenId_whenRun_thenPostWithThatIdReturned() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("First Content", 1L, 1L));
        posts.add(new Post("Second Content", 1L, 1L));

        when(postController.getPostById(1)).thenReturn(posts.get(0));
        when(postController.getPostById(2)).thenReturn(posts.get(1));

        Post testPost = postController.getPostById(1);
        Post testPost2 = postController.getPostById(2);

        assertEquals("First Content", testPost.getContent());
        assertEquals("Second Content", testPost2.getContent());
    }

    @Test
    void givenNewPost_whenSave_thenReturnNewPost() {
        PostController postController = Mockito.mock(PostController.class);
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("First Content", 1L, 1L));
        posts.add(new Post("Second Content", 1L, 1L));
        Post newPost = new Post("Third Content", 1L, 1L);

        doNothing().when(postController).savePost(isA(Post.class));

        postController.savePost(newPost);

        verify(postController,times(1)).savePost(newPost);
    }

    @Test
    void givenUpdate_whenUpdate_thenReturnUpdatedLabel() {
        PostController postController = Mockito.mock(PostController.class);
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("First Content", 1L, 1L));
        posts.add(new Post("Second Content", 1L, 1L));
        Post newPost = new Post("Third Content", 1L, 1L);

        doNothing().when(postController).updatePost(newPost);

        postController.updatePost(newPost);

        verify(postController,times(1)).updatePost(newPost);
    }

    @Test
    void givenId_whenRun_thenVerifyTimesOfInvocations() {
        PostController postController = Mockito.mock(PostController.class);
        doNothing().when(postController).deletePostById(isA(Integer.class));

        postController.deletePostById(1);

        verify(postController, times(1)).deletePostById(1);
    }
}