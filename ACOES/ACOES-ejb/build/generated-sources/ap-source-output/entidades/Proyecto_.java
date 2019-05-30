package entidades;

import entidades.Beneficiario;
import entidades.Trabajador;
import entidades.Transaccion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-30T02:30:31")
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