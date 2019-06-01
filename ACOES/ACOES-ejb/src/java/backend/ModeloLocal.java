package backend;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ModeloLocal {
    public <T> T find(Class<T> entityClass, Object pk);
    public <T> List<T> findAll(Class<T> entityClass);
    public void add(Object o) throws Exception;
    public void update(Object o) throws Exception;
    public void delete(Object o) throws Exception;
}
