package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Inheritance( strategy = InheritanceType.JOINED )
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario implements Serializable {
    
    public enum Rol {
    TRABAJADOR,
    SOCIO
    };
    @XmlTransient
    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private String apellidos;
    private String email;
    private String telefono;
    @Column (nullable = false)
    private String contrasenia;
    @Column (nullable = false)
    private String NIF;
    private String fechaNacimiento;
    private String fechaAlta;
    private String fechaBaja;

    private String numCuentaBancaria;
    private String direccion;
    
    
    private Rol rol;
    
    @OneToMany(mappedBy="usuario")
    private List<Ingresos> ingresos;
    @OneToMany(mappedBy="usuario")
    private List<Historial> historiales;
    @OneToMany(mappedBy="usuario")
    private List<Datos_academicos> Datos_academicos;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getNumCuentaBancaria() {
        return numCuentaBancaria;
    }

    public void setNumCuentaBancaria(String numCuentaBancaria) {
        this.numCuentaBancaria = numCuentaBancaria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Ingresos> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingresos> ingresos) {
        this.ingresos = ingresos;
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<Historial> historiales) {
        this.historiales = historiales;
    }

    public List<Datos_academicos> getDatos_academicos() {
        return Datos_academicos;
    }

    public void setDatos_academicos(List<Datos_academicos> Datos_academicos) {
        this.Datos_academicos = Datos_academicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + '}';
    }
    
    
}
