package view;

import controller.WriterController;
import model.Label;
import model.Post;
import model.Writer;

import java.util.Scanner;

public class WriterView extends BasicView{

    private final Scanner SCANNER = new Scanner(System.in);

    private final WriterController WRITER_CONTROLLER;

    public WriterView(WriterController writer_controller) {
        this.WRITER_CONTROLLER = writer_controller;
    }


    @Override
    void getById() {
        System.out.println("Enter id of the necessary writer");
        int id = SCANNER.nextInt();
        WRITER_CONTROLLER.getWriterById(id);
    }

    @Override
    void getAll() {
        WRITER_CONTROLLER.getAll().forEach(x-> System.out.println(x.getName()));
    }

    @Override
    void save() {
        System.out.println("Enter name of the new writer");
        String name = SCANNER.nextLine();
        System.out.println("Enter content of the writer's post");
        String content = SCANNER.nextLine();
        System.out.println("Enter number of creation");
        long created = SCANNER.nextInt();
        System.out.println("Enter number of update");
        long updated = SCANNER.nextInt();
        System.out.println("Enter label name of this post");
        String labelName = SCANNER.nextLine();
        Post createdPost = new Post(content, created, updated);
        createdPost.addLabel(new Label(labelName));
        Writer createdWriter = new Writer(name);
        createdWriter.addPosts(createdPost);
        WRITER_CONTROLLER.saveWriter(createdWriter);
    }

    @Override
    void update() {
        System.out.println("Enter id of the necessary writer");
        int id = SCANNER.nextInt();
        System.out.println("Enter new name for the writer");
        String name = SCANNER.nextLine();
        Writer updatedWriter = WRITER_CONTROLLER.getWriterById(id);
        updatedWriter.setName(name);
        WRITER_CONTROLLER.updateWriter(updatedWriter);
        System.out.println("Operation ended successfully");
    }

    @Override
    void deleteById() {
        System.out.println("Enter id of the necessary writer");
        int id = SCANNER.nextInt();
        WRITER_CONTROLLER.deleteWriterById(id);
    }
}
