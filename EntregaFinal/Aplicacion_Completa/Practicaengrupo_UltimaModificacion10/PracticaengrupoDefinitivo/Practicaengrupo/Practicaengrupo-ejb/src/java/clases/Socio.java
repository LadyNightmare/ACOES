/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
/**
 *
 * @author Simon
 */
public class Socio {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String NIF;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellidos;
    @Column(nullable=false)
    private String estado;
    @Column(nullable=false)
    private String provincia;
    @Column(nullable=false)
    private Long CP;
    @Column(nullable=false)
    private Long tFijo;
    @Column(nullable=false)
    private Long tMovil;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String relacion;
    @Column(nullable=false)
    private String sector;
    @Column(nullable=false)
    private String certificado;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAlta;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaBaja;
    private String observ;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNIF() {
        return NIF;
    }
    public void setNIF(String DNI) {
        this.NIF = DNI;
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
    public void setEstado(String est) {
        this.estado = est;
    }
    
    public String getProv() {
        return provincia;
    }
    public void setProv(String prov) {
        this.provincia= prov;
    }
    public Long getComVive() {
        return CP;
    }
    public void setComVive(Long cpostal) {
        this.CP = cpostal;
    }
    public Long getFijo() {
        return tFijo;
    }
    public void setFijo(Long fijo) {
        this.tFijo = fijo;
    }
    public Long getMovil() {
        return tMovil;
    }
    public void setMovil(Long movil) {
        this.tMovil = movil;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String mail) {
        this.email= mail;
    }
    public String getRelacion() {
        return relacion;
    }
    public void setRelacion(String r) {
        this.relacion= r;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sec) {
        this.sector= sec;
    }
    public String getCertificado() {
        return certificado;
    }
    public void setCertificado(String cert) {
        this.certificado= cert;
    }
    public Date getFecha_alta() {
        return fechaAlta;
    }
    public void setFecha_alta(Date entrada) {
        this.fechaAlta = entrada;
    }
    public Date getFecha_baja() {
        return fechaBaja;
    }
    public void setFecha_baja(Date salida) {
        this.fechaBaja = salida;
    }
  
    public String getObservacion() {
        return observ;
    }
    public void setObservacion(String obs) {
        this.observ = obs;
    }
}
