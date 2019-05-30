package backend;

import javax.ejb.Local;
import java.util.List;

import objects.*;

@Local
public interface ModeloLocal {
    public <T> T find(Class<T> entityClass, Object pk);
    public <T> List<T> findAll(Class<T> entityClass);
    public void add(Object o);
    public void update(Object o);
    public void delete(Object o);
    
    public void registrar(Socio socio) throws Exception;
}
