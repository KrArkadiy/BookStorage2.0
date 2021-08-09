package service;

import dao.WriterDao;
import dao.daoImpl.WriterDaoImpl;
import lombok.NoArgsConstructor;
import model.Writer;

import java.util.List;

@NoArgsConstructor
public class WriterService {

    private WriterDao writerDao = new WriterDaoImpl();

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
