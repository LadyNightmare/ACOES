/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author reque
 */
@Entity
public class Datos_academicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nif_beneficiario;
   
    @Column (nullable = false)
    private String curso;
    @Column (nullable = false)
    private String centro;
    @Column (nullable = false)
    private long nota;
    
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Beneficiario beneficiario;
    
    public Usuario getusuario() {
        return usuario;
    }

    public void setusuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Beneficiario getbeneficiario() {
        return beneficiario;
    }

    public void setbeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public long getNota() {
        return nota;
    }

    public void setNota(long nota) {
        this.nota = nota;
    }

    public String getNif_beneficiario() {
        return nif_beneficiario;
    }

    public void setNif_beneficiario(String nif) {
        this.nif_beneficiario = nif;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nif_beneficiario == null) ? 0 : nif_beneficiario.hashCode());
        return result;
    }
        
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Datos_academicos other = (Datos_academicos) obj;
       
        if (nif_beneficiario == null) {
            if (other.nif_beneficiario != null)
            return false;
        } else if (!nif_beneficiario.equals(other.nif_beneficiario))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "acoes.datos_academicos[ identificador=" + nif_beneficiario + "]";
    }
    
}
