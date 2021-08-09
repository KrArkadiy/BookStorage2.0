package view;

import controller.PostController;
import liquibase.pro.packaged.L;
import model.Label;
import model.Post;

import java.util.Scanner;

public class PostView extends BasicView{

    private final Scanner SCANNER = new Scanner(System.in);

    private final PostController POST_CONTROLLER;

    public PostView(PostController post_controller) {
        this.POST_CONTROLLER = post_controller;
    }

    @Override
    void getById() {
        System.out.println("Enter id of the necessary post");
        int id = SCANNER.nextInt();
        Post post = POST_CONTROLLER.getPostById(id);
        System.out.println(post.getContent());
    }

    @Override
    void getAll() {
        POST_CONTROLLER.getAll().forEach(x-> System.out.println(x.getContent()));
    }

    @Override
    void save() {
        System.out.println("Enter content of the post");
        String content = SCANNER.nextLine();
        System.out.println("Enter number of creation");
        long created = SCANNER.nextInt();
        System.out.println("Enter number of update");
        long updated = SCANNER.nextInt();
        System.out.println("Enter label name of this post");
        String name = SCANNER.nextLine();
        Post createdPost = new Post(content, created, updated);
        createdPost.addLabel(new Label(name));
        POST_CONTROLLER.savePost(createdPost);
    }

    @Override
    void update() {
        System.out.println("Enter id of the necessary post");
        int id = SCANNER.nextInt();
        Post updatedPost = POST_CONTROLLER.getPostById(id);
        System.out.println("Enter new content of the post");
        String content = SCANNER.nextLine();
        updatedPost.setContent(content);
        POST_CONTROLLER.updatePost(updatedPost);
    }

    @Override
    void deleteById() {
        System.out.println("Enter id of the necessary post");
        int id = SCANNER.nextInt();
        POST_CONTROLLER.deletePostById(id);
        System.out.println("Operation ended successfully");
    }
}
