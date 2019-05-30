package backend;

import javax.ejb.Local;

import entidades.*;

@Local
public interface ModeloLocal {
    public <T> T find(Class<T> entityClass, Object pk);
    public void add(Object o);
    public void update(Object o);
    public void delete(Object o);
    
    public void registrar(Trabajador socio) throws Exception;
}
