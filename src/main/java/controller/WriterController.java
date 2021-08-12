package controller;

import dao.daoImpl.WriterDaoImpl;
import model.Writer;
import service.WriterService;

import java.util.List;

public class WriterController {

    private WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    public Writer getWriterById(int id){
        return writerService.getById(id);
    }

    public List<Writer> getAll(){
        return writerService.getAll();
    }

    public void saveWriter(Writer writer){
        writerService.saveWriter(writer);
    }

    public void updateWriter(Writer writer){
        writerService.updateWriter(writer);
    }

    public void deleteWriterById(int id){
        writerService.deleteById(id);
    }
}
