package service;

import dao.WriterDao;
import dao.daoImpl.WriterDaoImpl;
import model.Writer;

import java.util.List;

public class WriterService {

    private WriterDao writerDao = new WriterDaoImpl();

    public WriterService() {
    }

    public WriterService(WriterDao writerDao) {
        this.writerDao = writerDao;
    }

    public Writer getById(int id) {
        return writerDao.getById(id);
    }

    public List<Writer> getAll(){
        return writerDao.getAll();
    }

    public void saveWriter(Writer writer){
        writerDao.save(writer);
    }

    public void updateWriter(Writer writer){
        writerDao.update(writer);
    }

    public void deleteById(int id){
        writerDao.deleteById(id);
    }
}
