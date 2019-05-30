package Entidades;

import Entidades.Beneficiario;
import Entidades.Ingresosegresos;
import Entidades.Personal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-30T20:21:37")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripciondelproyecto;
    public static volatile SingularAttribute<Proyecto, String> nombreproyecto;
    public static volatile ListAttribute<Proyecto, Beneficiario> propietario_proyecto;
    public static volatile ListAttribute<Proyecto, Personal> personalProyecto;
    public static volatile ListAttribute<Proyecto, Ingresosegresos> listaIngresos;
    public static volatile SingularAttribute<Proyecto, Date> fechadecreacion;
    public static volatile SingularAttribute<Proyecto, String> id;

}