package entidades;

import entidades.Beneficiario;
import entidades.Socio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-30T02:30:31")
@StaticMetamodel(Envio.class)
public class Envio_ { 

    public static volatile SingularAttribute<Envio, String> tipodeenvio;
    public static volatile SingularAttribute<Envio, Date> fecha;
    public static volatile SingularAttribute<Envio, String> contenido;
    public static volatile SingularAttribute<Envio, Beneficiario> receptor;
    public static volatile SingularAttribute<Envio, Integer> id;
    public static volatile SingularAttribute<Envio, Socio> emisor;

}