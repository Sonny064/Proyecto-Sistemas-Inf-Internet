package Entidades;

import Entidades.Beneficiario;
import Entidades.Ingresosegresos;
import Entidades.Personal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T19:59:30")
@StaticMetamodel(Centro.class)
public class Centro_ { 

    public static volatile ListAttribute<Centro, Ingresosegresos> ingresos;
    public static volatile SingularAttribute<Centro, Date> fechacreacion;
    public static volatile SingularAttribute<Centro, String> localizacion;
    public static volatile ListAttribute<Centro, Beneficiario> propietario_centro;
    public static volatile ListAttribute<Centro, Personal> personal;
    public static volatile SingularAttribute<Centro, String> id;
    public static volatile SingularAttribute<Centro, String> nombre;

}