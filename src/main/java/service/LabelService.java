package service;

import dao.LabelDao;
import dao.daoImpl.LabelDaoImpl;
import model.Label;

import java.util.List;

public class LabelService {

    private LabelDao labelDao = new LabelDaoImpl();

    public LabelService() {

    }

    public LabelService(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    public Label getLabelById(int id){
        return labelDao.getById(id);
    }

    public void saveLabel(Label label){
        labelDao.save(label);
    }

    public void deleteLabel(int id){
        labelDao.deleteById(id);
    }

    public void updateLabel(Label label){
        labelDao.update(label);
    }

    public List<Label> getAll(){
        return labelDao.getAll();
    }
}
