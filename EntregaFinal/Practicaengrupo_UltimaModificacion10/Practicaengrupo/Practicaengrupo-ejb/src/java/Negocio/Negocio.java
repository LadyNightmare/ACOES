
package Negocio;

import entidades.Beneficiario;
import entidades.Datos_academicos;
import entidades.Ingresos;
import entidades.Usuario;
import javax.ejb.Local;

/**
 *
 * @author francis
 */
@Local
public interface Negocio {
    public void registrarUsuario(Usuario u)throws AcoesException;
    public void validarCuenta(String cuenta, String validacion) throws AcoesException;
    public void compruebaLogin(Usuario u) throws AcoesException;
    public Usuario refrescarUsuario(Usuario u) throws AcoesException;
    public void regisNino(Beneficiario b) throws AcoesException;
    public Beneficiario refrescarNino(Beneficiario b) throws AcoesException;
    public void compruebaNino(Beneficiario b) throws AcoesException;
    public void registrarDonacion(Ingresos i) throws AcoesException;
    public void registrarCalificacion(Datos_academicos d) throws AcoesException;
    public Beneficiario buscarNino(Long nif) throws AcoesException;
    public void modificarDatosUsuario(Usuario u) throws AcoesException;
    public Beneficiario getninio(Long nif) throws BeneficiarioInexistenteException;
}

