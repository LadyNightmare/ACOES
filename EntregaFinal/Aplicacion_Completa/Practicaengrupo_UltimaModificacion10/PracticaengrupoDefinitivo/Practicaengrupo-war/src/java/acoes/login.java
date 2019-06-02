/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import Negocio.AcoesException;
import Negocio.Negocio;
import entidades.Usuario;
import entidades.Usuario.Rol;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sofia
 */
@Named(value = "login")
@RequestScoped
public class login {

    
    
    @Inject
    private Negocio negocio;
    
    private Usuario usuario = new Usuario();
    
    @Inject
    private controlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

     public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String autenticar() {
        try {
            // Implementar este método
            //FacesContext ctx = FacesContext.getCurrentInstance();
            //ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El método autenticar() no está implementado", "El método autenticar() no está implementado"));

            negocio.compruebaLogin(usuario);
            ctrl.setUsuario(negocio.refrescarUsuario(usuario));
            return ctrl.home();
        } catch (AcoesException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
}
