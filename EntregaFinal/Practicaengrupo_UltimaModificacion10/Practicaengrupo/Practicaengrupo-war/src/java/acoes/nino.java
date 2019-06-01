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
    private Beneficiario ver;
    private Negocio aux;

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
    public Beneficiario getVer(){
        return ver;
    }
    public void setVer(Beneficiario b){
        ver=b;
    }
    public Long getNifBuscar(){
        return nifBuscar;
    }
    
    public void setBeneficiario(Long nif){
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
    public String verNino(Long nif) throws BeneficiarioInexistenteException{
        ver=aux.getninio(nif);
        return "datosPersonalesNino.xhtml";
    }
    
    
}