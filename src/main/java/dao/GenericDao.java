package dao;

import java.util.List;

public interface GenericDao<T, ID> {

    T getById(ID id);

    List<T> getAll();

    void update(T t);

    void save(T t);

    void deleteById(ID id);

}
