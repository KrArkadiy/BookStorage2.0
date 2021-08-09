package view;

import controller.LabelController;
import model.Label;

import java.util.Scanner;

public class LabelView extends BasicView{

    private final LabelController LABEL_CONTROLLER;

    private final Scanner SCANNER = new Scanner(System.in);

    public LabelView(LabelController label_controller) {
        this.LABEL_CONTROLLER = label_controller;
    }

    @Override
    void getById() {
        System.out.println("Enter id of necessary label");
        int id = SCANNER.nextInt();
        Label label = LABEL_CONTROLLER.getById(id);
        System.out.println(label.getName());
    }

    @Override
    void getAll() {
        LABEL_CONTROLLER.getAll().forEach(x-> System.out.println(x.getName()));
        System.out.println("Operation ended successfully");
    }

    @Override
    void save() {
        System.out.println("Enter name of the label");
        String name = SCANNER.nextLine();
        LABEL_CONTROLLER.saveLabel(new Label(name));
    }

    @Override
    void update() {
        System.out.println("Enter id of the necessary label");
        int id = SCANNER.nextInt();
        Label label = LABEL_CONTROLLER.getById(id);
        System.out.println("Enter name of the label");
        String name = SCANNER.nextLine();
        label.setName(name);
        LABEL_CONTROLLER.updateLabel(label);
        System.out.println(label.getName());
    }

    @Override
    void deleteById() {
        System.out.println("Enter id of the necessary label");
        int id = SCANNER.nextInt();
        LABEL_CONTROLLER.deleteLabelById(id);
        System.out.println("Label successfully deleted");
    }
}
