package objects;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objects.Centro;
import objects.Proyecto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T17:44:34")
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, String> descripcion;
    public static volatile SingularAttribute<Transaccion, Date> fecha;
    public static volatile SingularAttribute<Transaccion, Centro> centro;
    public static volatile SingularAttribute<Transaccion, Proyecto> proyecto;
    public static volatile SingularAttribute<Transaccion, Integer> id;
    public static volatile SingularAttribute<Transaccion, Float> cantidad;

}