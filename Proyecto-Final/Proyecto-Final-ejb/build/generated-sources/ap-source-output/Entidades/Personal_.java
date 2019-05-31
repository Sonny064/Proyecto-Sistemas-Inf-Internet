package Entidades;

import Entidades.Centro;
import Entidades.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-31T00:45:46")
@StaticMetamodel(Personal.class)
public class Personal_ { 

    public static volatile SingularAttribute<Personal, String> apellidos;
    public static volatile SingularAttribute<Personal, String> descripcion;
    public static volatile SingularAttribute<Personal, String> password;
    public static volatile SingularAttribute<Personal, Date> fechanacimiento;
    public static volatile SingularAttribute<Personal, String> foto;
    public static volatile SingularAttribute<Personal, String> experiencia;
    public static volatile SingularAttribute<Personal, String> id;
    public static volatile ListAttribute<Personal, Proyecto> proyectos;
    public static volatile SingularAttribute<Personal, Date> fechaentradaacoes;
    public static volatile SingularAttribute<Personal, String> cargo;
    public static volatile SingularAttribute<Personal, String> nombre;
    public static volatile ListAttribute<Personal, Centro> listadoCentros;

}