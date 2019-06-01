package Entidades;

import Entidades.Beneficiario;
import Entidades.Envios;
import Entidades.Ingresosegresos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T17:56:19")
@StaticMetamodel(Socio.class)
public class Socio_ { 

    public static volatile SingularAttribute<Socio, String> apellidos;
    public static volatile SingularAttribute<Socio, String> relacion;
    public static volatile SingularAttribute<Socio, String> estado;
    public static volatile ListAttribute<Socio, Beneficiario> beneficiarios;
    public static volatile SingularAttribute<Socio, String> direccion;
    public static volatile SingularAttribute<Socio, String> nif;
    public static volatile SingularAttribute<Socio, String> provincia;
    public static volatile SingularAttribute<Socio, String> nombre;
    public static volatile SingularAttribute<Socio, Boolean> certificado;
    public static volatile SingularAttribute<Socio, String> password;
    public static volatile ListAttribute<Socio, Ingresosegresos> ingresos_egresos;
    public static volatile SingularAttribute<Socio, String> observaciones;
    public static volatile SingularAttribute<Socio, String> poblacion;
    public static volatile SingularAttribute<Socio, Date> fechadebaja;
    public static volatile SingularAttribute<Socio, Date> fechadenacimiento;
    public static volatile SingularAttribute<Socio, String> telefonofijo;
    public static volatile SingularAttribute<Socio, String> sector;
    public static volatile SingularAttribute<Socio, String> email;
    public static volatile SingularAttribute<Socio, Date> fechadealta;
    public static volatile ListAttribute<Socio, Envios> envios;
    public static volatile SingularAttribute<Socio, String> codigopostal;
    public static volatile SingularAttribute<Socio, String> telefonomovil;

}