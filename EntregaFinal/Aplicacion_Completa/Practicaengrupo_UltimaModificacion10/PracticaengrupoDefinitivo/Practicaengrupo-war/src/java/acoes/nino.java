/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import Negocio.AcoesException;
import Negocio.BeneficiarioInexistenteException;
import Negocio.CuentaRepetidaException;
import Negocio.Negocio;
import entidades.Beneficiario;
import entidades.Datos_academicos;
import entidades.Ingresos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;


@Named(value = "nino")
@RequestScoped
public class nino {

    @EJB
    private Negocio negocio;
    private Beneficiario nino;
    private Long nifBuscar;
    private Datos_academicos da;

    public nino()  {
        
    }
    
    public Beneficiario beneficiario(){
        try {
            Beneficiario b = negocio.buscarNino(nifBuscar);
            nino=b;
            return b;
        } catch (AcoesException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Datos_academicos datosAcademicos(){
        try {
            Datos_academicos d = negocio.buscarDA(nifBuscar);
            da=d;
            return da;
        } catch (AcoesException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Datos_academicos getDA(){
        return da;
    }
    
    public void setDA(Datos_academicos da){
        this.da=da;
    }
    
    
    public Long getNifBuscar(){
        return nifBuscar;
    }
    
    public void setNifBuscar(Long nif){
        nifBuscar=nif;
    }
    
    public Beneficiario getBeneficiario(){
        return nino;
    }
    
    public void setBeneficiario(Beneficiario n){
        nino=n;
    }

    public String registrar() throws AcoesException {
        
        negocio.regisNino(nino);
        return "VerAlumDesdeProf.xhtml";
        
    }
    
     public String mostrarDatos() throws AcoesException{
        
        Beneficiario b = negocio.buscarNino(nifBuscar);
        setBeneficiario(negocio.refrescarNino(b));
        return "datosPersonalesNino.xhtml";
    }
    
    
    public String mostrarCalificacion() throws AcoesException{
        Datos_academicos d = negocio.buscarDA(nifBuscar);
        setDA(d);
        return "verCalificacion.xhtml";
    }
    
    
}