package controller;

import dao.daoImpl.LabelDaoImpl;
import model.Label;
import service.LabelService;

import java.util.List;

public class LabelController {

    private LabelService labelService;

    private LabelDaoImpl labelDao;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    public LabelController(LabelDaoImpl labelDao) {
        this.labelDao = labelDao;
    }

    public Label getById(int id){
        return labelService.getLabelById(id);
    }

    public List<Label> getAll(){
        return labelService.getAll();
    }

    public void saveLabel(Label label){
        labelService.saveLabel(label);
    }

    public void updateLabel(Label label){
        labelService.updateLabel(label);
    }

    public void deleteLabelById(int id){
        labelService.deleteLabel(id);
    }
}
