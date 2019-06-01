package Entidades;

import Entidades.Centro;
import Entidades.Envios;
import Entidades.Proyecto;
import Entidades.Socio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T17:56:19")
@StaticMetamodel(Beneficiario.class)
public class Beneficiario_ { 

    public static volatile SingularAttribute<Beneficiario, String> apellidos;
    public static volatile SingularAttribute<Beneficiario, String> estado;
    public static volatile SingularAttribute<Beneficiario, String> gradodelcurso;
    public static volatile SingularAttribute<Beneficiario, Socio> socio;
    public static volatile SingularAttribute<Beneficiario, Date> fechadeentradaacoes;
    public static volatile SingularAttribute<Beneficiario, String> comunidadderesidencia;
    public static volatile ListAttribute<Beneficiario, Proyecto> proyecto;
    public static volatile SingularAttribute<Beneficiario, String> nombre;
    public static volatile SingularAttribute<Beneficiario, String> beca;
    public static volatile SingularAttribute<Beneficiario, Date> fechadesalidaacoes;
    public static volatile SingularAttribute<Beneficiario, String> foto;
    public static volatile SingularAttribute<Beneficiario, String> comunidaddeprocedencia;
    public static volatile ListAttribute<Beneficiario, Envios> envian;
    public static volatile ListAttribute<Beneficiario, Centro> centro;
    public static volatile SingularAttribute<Beneficiario, String> observaciones;
    public static volatile SingularAttribute<Beneficiario, String> id;
    public static volatile SingularAttribute<Beneficiario, String> sexo;
    public static volatile SingularAttribute<Beneficiario, Date> fechadenacimiento;

}