package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Beneficiario implements Serializable {
    
    @XmlTransient
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nif;
    
    @Column (nullable = false)
    private String nombre; 
    @Column (nullable = false)
    private String apellidos;
    @Column (nullable = false)
    private String sexo;
    @Column (nullable = false)
    private String comunidadProcedencia;
    @Column (nullable = false)
    private String comunidadResidencia;
    @Column (nullable = false)
    private Integer numIngreso;
    @Column (nullable = false)
    private String grado;
    @Column (nullable = false)
    private String estado;
    
    @OneToMany(mappedBy="beneficiario")
    private List<Historial> historiales;
    @OneToMany(mappedBy="beneficiario")
    private List<Ingresos> Ingresos;
    @OneToMany(mappedBy="beneficiario")
    private List<Datos_academicos> Datos_academicos;

    public Long getNif() {
        return nif;
    }

    public void setNif(Long nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getComunidadProcedencia() {
        return comunidadProcedencia;
    }

    public void setComunidadProcedencia(String comunidadProcedencia) {
        this.comunidadProcedencia = comunidadProcedencia;
    }

    public String getComunidadResidencia() {
        return comunidadResidencia;
    }

    public void setComunidadResidencia(String comunidadResidencia) {
        this.comunidadResidencia = comunidadResidencia;
    }

    public Integer getNumIngreso() {
        return numIngreso;
    }

    public void setNumIngreso(Integer num_ingreso) {
        this.numIngreso = num_ingreso;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<Historial> historiales) {
        this.historiales = historiales;
    }

    public List<Ingresos> getIngresos() {
        return Ingresos;
    }

    public void setIngresos(List<Ingresos> Ingresos) {
        this.Ingresos = Ingresos;
    }

    public List<Datos_academicos> getDatos_academicos() {
        return Datos_academicos;
    }

    public void setDatos_academicos(List<Datos_academicos> Datos_academicos) {
        this.Datos_academicos = Datos_academicos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.nif);
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
        final Beneficiario other = (Beneficiario) obj;
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beneficiario{" + "nif=" + nif + '}';
    }
    
    
}