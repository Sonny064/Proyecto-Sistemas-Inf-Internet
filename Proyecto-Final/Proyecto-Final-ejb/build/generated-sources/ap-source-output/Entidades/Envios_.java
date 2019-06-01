package Entidades;

import Entidades.Beneficiario;
import Entidades.Socio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-01T08:17:35")
@StaticMetamodel(Envios.class)
public class Envios_ { 

    public static volatile SingularAttribute<Envios, String> tipodeenvio;
    public static volatile SingularAttribute<Envios, Date> fecha;
    public static volatile SingularAttribute<Envios, String> contenido;
    public static volatile SingularAttribute<Envios, Beneficiario> receptor;
    public static volatile SingularAttribute<Envios, Socio> emisor;

}