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
@Entity
public class Nino {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellidos;
    @Column(nullable=false)
    private String sexo;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    @Column(nullable=false)
    private String comProc;
    @Column(nullable=false)
    private String comVive;
    @Column(nullable=false)
    private String beca;
    private String gradCurso;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEntr;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaSal;
    private String estado;
    private String observ;
    private String tipoBen;
    @Column(nullable=false)
    private String habilitado;
    
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
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Date getFecha_nacimiento() {
        return fechaNac;
    }
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fechaNac = fecha_nacimiento;
    }
    public String getComProc() {
        return comProc;
    }
    public void setComProc(String procedencia) {
        this.comProc = procedencia;
    }
    public String getComVive() {
        return comVive;
    }
    public void setComVive(String vive) {
        this.comVive = vive;
    }
    public String getBeca() {
        return beca;
    }
    public void setBeca(String bec) {
        this.beca = bec;
    }
    public String getCurso() {
        return gradCurso;
    }
    public void setCurso(String curso) {
        this.gradCurso = curso;
    }
    public Date getFecha_entrada() {
        return fechaEntr;
    }
    public void setFecha_entrada(Date entrada) {
        this.fechaEntr = entrada;
    }
    public Date getFecha_salida() {
        return fechaSal;
    }
    public void setFecha_salida(Date salida) {
        this.fechaSal = salida;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String est) {
        this.estado = est;
    }
    public String getObservacion() {
        return observ;
    }
    public void setObservacion(String obs) {
        this.observ = obs;
    }
    public String getTipBenf() {
        return tipoBen;
    }
    public void setTipBenf(String ben) {
        this.tipoBen = ben;
    }
    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String hab) {
        this.habilitado = hab;
    }
}
