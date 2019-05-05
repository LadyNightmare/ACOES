package acoes;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-01T11:40:56")
@StaticMetamodel(ingresos_regresos.class)
public class ingresos_regresos_ { 

    public static volatile SingularAttribute<ingresos_regresos, String> descripcion;
    public static volatile SingularAttribute<ingresos_regresos, Date> fecha;
    public static volatile SingularAttribute<ingresos_regresos, Long> codigo;
    public static volatile SingularAttribute<ingresos_regresos, String> tipo;
    public static volatile SingularAttribute<ingresos_regresos, Long> cantidad;
    public static volatile SingularAttribute<ingresos_regresos, Date> fecha_pago;

}