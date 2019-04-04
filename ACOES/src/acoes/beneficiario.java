/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

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
public class beneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nombre;
    private String apellidos;
    private String sexo;
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    private String comunidad_procedencia;
    private String comunidad_residencia;
    private String beca;
    private String grado_curso;
    @Temporal(TemporalType.DATE)
    private Date fecha_entrada_acoes;
    @Temporal(TemporalType.DATE)
    private Date fecha_salida_acoes;
    private String foto;
    private String estado;
    private String observaciones;
    private String tipo_beneficiarios;
    private boolean habilitado;

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
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getComunidad_procedencia() {
        return comunidad_procedencia;
    }

    public void setComunidad_procedencia(String comunidad_procedencia) {
        this.comunidad_procedencia = comunidad_procedencia;
    }

    public String getComunidad_residencia() {
        return comunidad_residencia;
    }

    public void setComunidad_residencia(String comunidad_residencia) {
        this.comunidad_residencia = comunidad_residencia;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getGrado_curso() {
        return grado_curso;
    }

    public void setGrado_curso(String grado_curso) {
        this.grado_curso = grado_curso;
    }

    public Date getFecha_entrada_acoes() {
        return fecha_entrada_acoes;
    }

    public void setFecha_entrada_acoes(Date fecha_entrada_acoes) {
        this.fecha_entrada_acoes = fecha_entrada_acoes;
    }

    public Date getFecha_salida_acoes() {
        return fecha_salida_acoes;
    }

    public void setFecha_salida_acoes(Date fecha_salida_acoes) {
        this.fecha_salida_acoes = fecha_salida_acoes;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipo_beneficiarios() {
        return tipo_beneficiarios;
    }

    public void setTipo_beneficiarios(String tipo_beneficiarios) {
        this.tipo_beneficiarios = tipo_beneficiarios;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Long getId() {
        return codigo;
    }

    public void setId(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof beneficiario)) {
            return false;
        }
        beneficiario other = (beneficiario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoes.beneficiario[ codigo=" + codigo + " ]";
    }
    
}
