package objects;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objects.Beneficiario;
import objects.Socio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T17:44:34")
@StaticMetamodel(Envio.class)
public class Envio_ { 

    public static volatile SingularAttribute<Envio, String> tipodeenvio;
    public static volatile SingularAttribute<Envio, Date> fecha;
    public static volatile SingularAttribute<Envio, String> contenido;
    public static volatile SingularAttribute<Envio, Beneficiario> receptor;
    public static volatile SingularAttribute<Envio, Integer> id;
    public static volatile SingularAttribute<Envio, Socio> emisor;

}