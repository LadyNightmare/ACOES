/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import entidades.Usuario;
import static entidades.Usuario.Rol.SOCIO;
import static entidades.Usuario.Rol.TRABAJADOR;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sofia
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class controlAutorizacion implements Serializable{
    private Usuario usuario;
   
 
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        // Implementar el método
        // Devuelve la página Home dependiendo del rol del usuario
        // Si no hay usuario debe devolver la página de login
        // Si el usuario es el administrador debe devolver la página admin.xhtml
        // Si el usuario es un usuario normal debe devolver la página normal.xhtml
        if(this.getUsuario()==null){
            return "registroUsuario.xhtml";
        }   else if(this.getUsuario().getRol().equals(TRABAJADOR)){
            return "inicioTrabajadores.xhtml";
        }else if(this.getUsuario().getRol().equals(SOCIO)){
            return "inicioSocios.xhtml";
        }else{
            return "index.xhtml";
        }
       
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "index.xhtml";
    }
    
    public String Inicio(){
        // Devuelve a las pagina de inicio de los usuarios
        if(usuario.getRol().equals(TRABAJADOR)){
            return "inicioTrabajadores.xhtml";
        }else if(usuario.getRol().equals(SOCIO)){
            return "inicioSocios.xhtml";
        }else{
            return "index.xhtml";
        }
       
    }
    

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public controlAutorizacion() {
     
    }
    
}
