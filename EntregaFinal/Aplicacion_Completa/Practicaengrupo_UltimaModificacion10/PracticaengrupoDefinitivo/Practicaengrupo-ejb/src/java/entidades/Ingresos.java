package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Ingresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    
    
    @Column (nullable = false)
    private Integer numCuentaBancaria;
    @Column (nullable = false)
    private Integer numIngreso;
    @Column (nullable = true)
    private String tipo;
    @Temporal(TemporalType.DATE)
    @Column (nullable = true)
    private Date fecha;
    @Column (nullable = false)
    private String fechaPago;
    @Column (nullable = false)
    private Integer cantidad;
    
    private String descripcion;
    
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Beneficiario beneficiario;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getNumCuentaBancaria() {
        return numCuentaBancaria;
    }

    public void setNumCuentaBancaria(Integer numCuentaBancaria) {
        this.numCuentaBancaria = numCuentaBancaria;
    }

    public Integer getNumIngreso() {
        return numIngreso;
    }

    public void setNumIngreso(Integer numIngreso) {
        this.numIngreso = numIngreso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingresos other = (Ingresos) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingresos{" + "codigo=" + codigo + '}';
    }
    
    
    
}
