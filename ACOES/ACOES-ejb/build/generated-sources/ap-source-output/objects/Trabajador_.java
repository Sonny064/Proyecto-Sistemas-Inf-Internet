package objects;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objects.Centro;
import objects.Proyecto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T17:44:34")
@StaticMetamodel(Trabajador.class)
public class Trabajador_ { 

    public static volatile SingularAttribute<Trabajador, String> apellidos;
    public static volatile SingularAttribute<Trabajador, String> descripcion;
    public static volatile SingularAttribute<Trabajador, Boolean> administrador;
    public static volatile SingularAttribute<Trabajador, String> salt;
    public static volatile SingularAttribute<Trabajador, String> direccion;
    public static volatile SingularAttribute<Trabajador, Proyecto> proyecto;
    public static volatile SingularAttribute<Trabajador, String> nif;
    public static volatile SingularAttribute<Trabajador, String> provincia;
    public static volatile SingularAttribute<Trabajador, String> nombre;
    public static volatile SingularAttribute<Trabajador, String> password;
    public static volatile SingularAttribute<Trabajador, Date> fechanacimiento;
    public static volatile SingularAttribute<Trabajador, String> foto;
    public static volatile SingularAttribute<Trabajador, String> experiencia;
    public static volatile SingularAttribute<Trabajador, Centro> centro;
    public static volatile SingularAttribute<Trabajador, String> poblacion;
    public static volatile SingularAttribute<Trabajador, Date> fechaentradaacoes;
    public static volatile SingularAttribute<Trabajador, String> telefono;
    public static volatile SingularAttribute<Trabajador, String> cargo;
    public static volatile SingularAttribute<Trabajador, String> email;
    public static volatile SingularAttribute<Trabajador, String> codigopostal;

}