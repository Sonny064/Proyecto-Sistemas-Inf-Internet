package Entidades;

import Entidades.Centro;
import Entidades.Proyecto;
import Entidades.Socio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-31T00:45:46")
@StaticMetamodel(Ingresosegresos.class)
public class Ingresosegresos_ { 

    public static volatile SingularAttribute<Ingresosegresos, String> descripcion;
    public static volatile SingularAttribute<Ingresosegresos, Date> fecha;
    public static volatile SingularAttribute<Ingresosegresos, Socio> ingresos_socio;
    public static volatile SingularAttribute<Ingresosegresos, String> tipo;
    public static volatile SingularAttribute<Ingresosegresos, Boolean> fechadepago;
    public static volatile SingularAttribute<Ingresosegresos, String> id;
    public static volatile SingularAttribute<Ingresosegresos, String> cantidad;
    public static volatile SingularAttribute<Ingresosegresos, Proyecto> ingresos_proyecto;
    public static volatile SingularAttribute<Ingresosegresos, Centro> ingresos_centro;

}