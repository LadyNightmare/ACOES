/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.autentificacion;

import acoes.autentificacion.modelo.Usuario;
import acoes.autentificacion.modelo.Usuario.Rol;
import static acoes.autentificacion.modelo.Usuario.Rol.NINO;
import static acoes.autentificacion.modelo.Usuario.Rol.SOCIOS;
import static acoes.autentificacion.modelo.Usuario.Rol.TRABAJADORES;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
        if(usuario==null){
            return "index.xhtml";
        }   else if(usuario.getRol().equals(TRABAJADORES)){
            return "inicioTrabajadores.xhtml";
        }else if(usuario.getRol().equals(SOCIOS)){
            return "inicioSocios.xhtml";
        }else if(usuario.getRol().equals(NINO)){
            return "inicioNino.xhtml";
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
        if(usuario.getRol().equals(TRABAJADORES)){
            return "inicioTrabajadores.xhtml";
        }else if(usuario.getRol().equals(SOCIOS)){
            return "inicioSocios.xhtml";
        }else if(usuario.getRol().equals(NINO)){
            return "inicioNino.xhtml";
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
