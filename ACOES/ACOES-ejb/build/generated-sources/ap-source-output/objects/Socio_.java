package objects;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objects.Beneficiario;
import objects.Envio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T17:44:34")
@StaticMetamodel(Socio.class)
public class Socio_ { 

    public static volatile SingularAttribute<Socio, String> apellidos;
    public static volatile SingularAttribute<Socio, String> salt;
    public static volatile SingularAttribute<Socio, String> direccion;
    public static volatile SingularAttribute<Socio, String> nif;
    public static volatile SingularAttribute<Socio, String> provincia;
    public static volatile SingularAttribute<Socio, String> nombre;
    public static volatile SingularAttribute<Socio, String> password;
    public static volatile ListAttribute<Socio, Beneficiario> apadrinados;
    public static volatile SingularAttribute<Socio, String> observaciones;
    public static volatile SingularAttribute<Socio, String> poblacion;
    public static volatile SingularAttribute<Socio, String> telefono;
    public static volatile SingularAttribute<Socio, Date> fechadebaja;
    public static volatile SingularAttribute<Socio, Date> fechadenacimiento;
    public static volatile SingularAttribute<Socio, String> sector;
    public static volatile SingularAttribute<Socio, String> email;
    public static volatile SingularAttribute<Socio, Date> fechadealta;
    public static volatile ListAttribute<Socio, Envio> envios;
    public static volatile SingularAttribute<Socio, String> codigopostal;

}