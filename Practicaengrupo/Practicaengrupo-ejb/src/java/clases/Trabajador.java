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
public class Trabajador {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellidos;
    @Column(nullable=false)
    private String cargo;
    @Column(nullable=false)
    private String experiencia;
    private String descripcion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEntr;
    @Column(nullable=false)
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getCargo() {
        return cargo;
    }
    public void setEstado(String car) {
        this.cargo = car;
    }
    public String getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(String exp) {
        this.experiencia= exp;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setEmail(String des) {
        this.descripcion= des;
    }
    public Date getFecha_Nac() {
        return fechaNac;
    }
    public void setFecha_Nac(Date nac) {
        this.fechaNac = nac;
    }
    public Date getFecha_Entrada() {
        return fechaEntr;
    }
    public void setFecha_Entrada(Date ent) {
        this.fechaEntr = ent;
    }
}
