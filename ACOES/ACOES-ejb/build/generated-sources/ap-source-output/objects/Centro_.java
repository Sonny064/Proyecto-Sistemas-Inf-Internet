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
@StaticMetamodel(Centro.class)
public class Centro_ { 

    public static volatile ListAttribute<Centro, Transaccion> ingresos;
    public static volatile SingularAttribute<Centro, Date> fechacreacion;
    public static volatile SingularAttribute<Centro, Beneficiario> propietario;
    public static volatile SingularAttribute<Centro, String> localizacion;
    public static volatile ListAttribute<Centro, Trabajador> personal;
    public static volatile SingularAttribute<Centro, Integer> id;
    public static volatile SingularAttribute<Centro, String> nombre;
    public static volatile ListAttribute<Centro, Beneficiario> residentes;

}