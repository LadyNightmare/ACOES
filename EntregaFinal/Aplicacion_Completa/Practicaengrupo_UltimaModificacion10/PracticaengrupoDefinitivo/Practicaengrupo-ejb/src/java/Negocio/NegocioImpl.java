/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import entidades.Beneficiario;
import entidades.Datos_academicos;
import entidades.Historial;
import entidades.Ingresos;
import entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francis
 */
@Stateless
public class NegocioImpl implements Negocio {


    @PersistenceContext(unitName = "ACOESPU")
    private EntityManager em ;

    public void registrarUsuario(Usuario u) throws AcoesException {
        Usuario user = em.find(Usuario.class, u.getUsername());
        if (user != null) {
            // El usuario ya existe
            throw new CuentaRepetidaException();
        }
        em.persist(u);

    }
    

   @Override
    public void compruebaLogin(Usuario u)  throws AcoesException {
        // TODO
        Usuario user = em.find(Usuario.class, u.getUsername());
        if(user==null){
            throw new CuentaInexistenteException();
        }else if(!user.getContrasenia().equals(u.getContrasenia())){
            throw new ContraseniaInvalidaException();
        }else{
            System.out.println("Usuario y contraseña correcto");
        }
    }

    
   @Override
    public Usuario refrescarUsuario(Usuario u) throws AcoesException {
        compruebaLogin(u);
        Usuario user = em.find(Usuario.class, u.getUsername());
        return user;
    
    }

    
   @Override
    public void regisNino(Beneficiario b) throws AcoesException{ 
       
        em.persist(b);
    }
    
    @Override
    public void compruebaNino(Beneficiario b) throws AcoesException{
        Beneficiario be = em.find(Beneficiario.class, b.getNif());
        if(be==null){
            throw new BeneficiarioInexistenteException();
        }else{
            System.out.println("Beneficiario correcto");
        }
    }
    
    @Override
    public Beneficiario refrescarNino(Beneficiario b) throws AcoesException{
        compruebaNino(b);
        Beneficiario be = em.find(Beneficiario.class, b.getNif());
        return be;
    }
    
    @Override
    public void registrarDonacion(Ingresos i) throws AcoesException{
        em.persist(i);
    }
    
    public void registrarCalificacion(Datos_academicos d) throws AcoesException{
        
        em.persist(d);
    }
    
    public Beneficiario buscarNino(Long nif) throws AcoesException{
        Beneficiario b = em.find(Beneficiario.class, nif);
        if(b==null){
            throw new BeneficiarioInexistenteException();
        }
        return b;
    }
    public void modificarDatosUsuario(Usuario u) throws AcoesException{
            em.merge(u);
    }
    
   
     public Datos_academicos buscarDA(Long nif) throws AcoesException{
        Datos_academicos d = em.find(Datos_academicos.class, nif);
        if(d==null){
            throw new DatosAcademicosInexistenteException();
        }
        return d;
    }
     
    @Override
     public void registrarNinoHisto(Historial h) throws AcoesException{
         em.merge(h);
     }
    
}

    