package jpa_sii;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Municipio.class)
public abstract class Municipio_ {

	public static volatile SingularAttribute<Municipio, Short> codigoPostal;
	public static volatile SingularAttribute<Municipio, String> poblacion;
	public static volatile ListAttribute<Municipio, Socios> socios;

}

