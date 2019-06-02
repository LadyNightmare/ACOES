/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;



import Negocio.AcoesException;
import Negocio.BeneficiarioRepetido;
import Negocio.CuentaRepetidaException;
import Negocio.Negocio;
import entidades.Beneficiario;
import entidades.Datos_academicos;
import entidades.Historial;
import entidades.Ingresos;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import entidades.Usuario;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.inject.Inject;
import javax.management.Query;



/**
 *
 * @author francis
 */
@Named(value = "registro")
@RequestScoped
public class registro {

    //@Inject
    @EJB
    private Negocio negocio;
    
    private Usuario usuario;
    private Usuario modificado;
    private String repass;
    private String cuenta;
    private Ingresos ing;
    private Beneficiario nino;
    private Datos_academicos academico;
    private Integer codigo=0;
    private List<Ingresos> listaIn;
    private Historial h;
    
    @Inject
    private nino claseNino;
   
    public void setHistorial(Historial i){
        this.h=i;
    }
    
    public Historial getH(){
        return h;
    }
    
    
    public List<Ingresos> getLista(){
        return listaIn;
    }
    
    public void setListaIn(List<Ingresos> in){
        this.listaIn=in;
    }
    public Datos_academicos getDatos_academicos(){
        return academico;
    }
    
    public void setDatos_academicos(Datos_academicos datos){
        this.academico=datos;
    }
    
    public Integer getCodigo(){
        Crearcodigo();
        return codigo;
    }
    
    public void setCodigo(Integer c){
        this.codigo=c;
    }
    
    public Beneficiario getBeneficiario(){
        return nino;
    }
    
    public void setBeneficiario(Beneficiario n){
        nino=n;
    }
    public void setIng(Ingresos in){
        this.ing=in;   
    }
    
    public Ingresos getIng(){
        return ing;
    }
    

    private boolean registroOK;

    public boolean isRegistroOK() {
        return registroOK;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    

    public registro() {
        usuario = new Usuario();
        ing = new Ingresos();
        nino = new Beneficiario();
        academico = new Datos_academicos();
        modificado= new Usuario();
        h= new Historial();
    }

    public String getRepass() {
        return repass;
    }

   
    public void setRepass(String repass) {
        this.repass = repass;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario getModificado() {
        return modificado;
    }

    public void setModificado(Usuario m) {
        this.modificado = m;
    }

    public String registrarUsuario() throws AcoesException {
        try {
            if (!usuario.getContrasenia().equals(repass)) {
                FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
                FacesContext.getCurrentInstance().addMessage("registro:repass", fm);
                return null;
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            usuario.setFechaAlta(dtf.format(localDate));
            negocio.registrarUsuario(usuario);
            registroOK = true;
            return "Login2.xhtml";
            
        } catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);
            
        } 
        return "index.xhtml";
    }
    
    public String registrarDonacion() throws AcoesException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        ing.setFechaPago(dtf.format(localDate));
        negocio.registrarDonacion(ing);
        return "Donaciones.xhtml";
    }
    
    public String registrarNino() throws AcoesException {
       
            negocio.regisNino(nino);
            return "inicioTrabajadores.xhtml";
        
    }
    
    public void Crearcodigo(){
        codigo = codigo +1;
       
    }
    
    public String Apadrinar() throws AcoesException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        LocalDate localDates = localDate.plusMonths(6);
        h.setFechaInicio(dtf.format(localDate));
        h.setFechaFin(dtf.format(localDates));
        h.setNifPadrino(usuario.getNIF());
        h.setNifApadrinado(nino.getNif());
        negocio.registrarNinoHisto(h);
        return "darNifApadrinado.xhtml";
    }
    
    public String anadirCalificacion() throws AcoesException{
        negocio.registrarCalificacion(academico);
        return "inicioTrabajadores.xhtml";
    }
    public String modificarDatosUsuario() throws AcoesException{
        negocio.modificarDatosUsuario(usuario);
        return "datosPersonalesUsuario.xhtml";
    }
    
}
