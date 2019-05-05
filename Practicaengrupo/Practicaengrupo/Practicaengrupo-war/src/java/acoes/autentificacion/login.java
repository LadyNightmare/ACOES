/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.autentificacion;

import acoes.autentificacion.modelo.Usuario;
import acoes.autentificacion.modelo.Usuario.Rol;
import java.util.ArrayList;
import java.util.List;
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

    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    @Inject
    private controlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public login() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("pepe", "asdf", Rol.NINO));
        usuarios.add(new Usuario("manolo", "qwer", Rol.TRABAJADORES));
        usuarios.add(new Usuario("rosa", "1234", Rol.SOCIOS));
        
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() {
        // Implementar este método
        //FacesContext ctx = FacesContext.getCurrentInstance();
        //ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El método autenticar() no está implementado", "El método autenticar() no está implementado"));
       
        for(int i=0;i<usuarios.size();i++){
            if(usuario.equals(usuarios.get(i).getUsuario()) && contrasenia.equals(usuarios.get(i).getContrasenia())){
                Usuario u = new Usuario(usuario,contrasenia, usuarios.get(i).getRol());
                ctrl.setUsuario(u);
                
            }
        }
        
        return ctrl.home();
    }
}
