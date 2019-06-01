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
    

    /**
     * Este método debe comprobar que el nombre de usuario y contraseña que
     * recibe en el objeto u pertenecen a un usuario que existe en la BBDD y que
     * está validado (un usuario está validado cuando su cadena de validación es
     * nula).
     * 
     * Puede lanzar las excepciones CuentaInexistenteException, CuentaInactivaException
     * y ContraseniaInvalidaException
     *
     * @param u
     * @return
     */
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

    /**
     * Este método debe comprobar que el usuario que se le pasa como parámetro
     * es un usuario existente y con contraseña correcta (ya que estamos en la capa
     * de negocio con un Session Bean de tipo @Stateless, debemos comprobar
     * todos los accesos a la capa de nogocio). En caso negativo debe devolver debe devolver 
     * la excepción que corresponda,
     * en caso afirmativo debe devolver una entidad usuario tal con la información
     * existe ahora mismo en la BBDD.
     * @param u
     * @return 
     * @throws Negocio.AcoesException 
     */
   @Override
    public Usuario refrescarUsuario(Usuario u) throws AcoesException {
        compruebaLogin(u);
        Usuario user = em.find(Usuario.class, u.getUsername());
        return user;
    
    }

    @Override
    public void validarCuenta(String cuenta, String validacion) throws AcoesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            System.out.println("Beneficirio correcto");
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
    public Beneficiario getninio(Long nif) throws BeneficiarioInexistenteException{
        Beneficiario res = em.find(Beneficiario.class, nif);
        if(res==null){
            throw new BeneficiarioInexistenteException();
        }
        return res;
    }
    
}

    