package entidades;

import entidades.Centro;
import entidades.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-30T02:30:31")
@StaticMetamodel(Trabajador.class)
public class Trabajador_ { 

    public static volatile SingularAttribute<Trabajador, String> apellidos;
    public static volatile SingularAttribute<Trabajador, String> descripcion;
    public static volatile SingularAttribute<Trabajador, Boolean> administrador;
    public static volatile SingularAttribute<Trabajador, String> salt;
    public static volatile SingularAttribute<Trabajador, Proyecto> proyecto;
    public static volatile SingularAttribute<Trabajador, String> nif;
    public static volatile SingularAttribute<Trabajador, String> nombre;
    public static volatile SingularAttribute<Trabajador, String> password;
    public static volatile SingularAttribute<Trabajador, Date> fechanacimiento;
    public static volatile SingularAttribute<Trabajador, String> foto;
    public static volatile SingularAttribute<Trabajador, String> experiencia;
    public static volatile SingularAttribute<Trabajador, Centro> centro;
    public static volatile SingularAttribute<Trabajador, Date> fechaentradaacoes;
    public static volatile SingularAttribute<Trabajador, String> cargo;

}