package objects;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objects.Beneficiario;
import objects.Trabajador;
import objects.Transaccion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T17:44:34")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripcion;
    public static volatile ListAttribute<Proyecto, Beneficiario> beneficiarios;
    public static volatile ListAttribute<Proyecto, Transaccion> transacciones;
    public static volatile SingularAttribute<Proyecto, Date> fechadecreacion;
    public static volatile ListAttribute<Proyecto, Trabajador> personal;
    public static volatile SingularAttribute<Proyecto, Integer> id;
    public static volatile SingularAttribute<Proyecto, String> nombre;

}