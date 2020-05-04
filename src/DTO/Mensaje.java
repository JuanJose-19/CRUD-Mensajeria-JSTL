package DTO;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedQueries;
import com.sun.istack.NotNull;





@Entity
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findById", query = "SELECT m FROM Mensaje m WHERE m.id = :id"),
    @NamedQuery(name = "Mensaje.findByNombre", query = "SELECT m FROM Mensaje m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mensaje.findByEmail", query = "SELECT m FROM Mensaje m WHERE m.email = :email"),
    @NamedQuery(name = "Mensaje.findBySitioweb", query = "SELECT m FROM Mensaje m WHERE m.sitioweb = :sitioweb"),
    @NamedQuery(name = "Mensaje.findByMensaje", query = "SELECT m FROM Mensaje m WHERE m.mensaje = :mensaje")})
public class Mensaje implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id")
	    private Integer id;
	    @Basic(optional = false)
	    @Column(name = "nombre")
	    private String nombre;
	    @Basic(optional = false)
	    @Column(name = "email")
	    private String email;
	    @Basic(optional = false)
	    @Column(name = "sitioweb")
	    private String sitioweb;
	    @Basic(optional = false)
	    @Column(name = "mensaje")
	    private String mensaje;
	    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
	    @ManyToOne(optional = false)
	    private Usuario usuario;

	    public Mensaje() {
	    }

	    public Mensaje(Integer id) {
	        this.id = id;
	    }

	    public Mensaje(Integer id, String nombre, String email, String sitioweb, String mensaje) {
	        this.id = id;
	        this.nombre = nombre;
	        this.email = email;
	        this.sitioweb = sitioweb;
	        this.mensaje = mensaje;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getSitioweb() {
	        return sitioweb;
	    }

	    public void setSitioweb(String sitioweb) {
	        this.sitioweb = sitioweb;
	    }

	    public String getMensaje() {
	        return mensaje;
	    }

	    public void setMensaje(String mensaje) {
	        this.mensaje = mensaje;
	    }

	    public Usuario getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(Usuario usuario) {
	        this.usuario = usuario;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (id != null ? id.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Mensaje)) {
	            return false;
	        }
	        Mensaje other = (Mensaje) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "Dto.Mensaje[ id=" + id + " ]";
	    }
}
