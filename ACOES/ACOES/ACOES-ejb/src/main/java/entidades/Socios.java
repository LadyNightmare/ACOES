/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author reque
 */
@Entity
public class Socios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_socio;
    private Long nif;
    private String nombre;
    private String apellidos;
    private String estado;
    private String provincia;
    private Long codigo_postal;
    private String direccion;
    private Long telefono_fijo;
    private Long telefono_movil;
    private String email;
    private String relacion;
    private String sector;
    private String certificado;
    @Temporal(TemporalType.DATE)
    private Date fecha_alta;
    @Temporal(TemporalType.DATE)
    private Date fecha_baja;
    private String observaciones;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Long getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(Long codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(Long telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public Long getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(Long telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id_socio;
    }

    public void setId(Long id_socio) {
        this.id_socio = id_socio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_socio != null ? id_socio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.id_socio == null && other.id_socio != null) || (this.id_socio != null && !this.id_socio.equals(other.id_socio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.socios[ id_socio=" + id_socio + " ]";
    }
    
}
