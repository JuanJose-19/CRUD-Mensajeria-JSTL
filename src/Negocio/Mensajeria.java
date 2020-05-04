package Negocio;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.sun.istack.logging.Logger;
import DAO.Conexion;
import DAO.MensajeJPAController;
import DAO.UsuarioJPAController;
import DAO.exceptions.NonexistentEntityException;
import DTO.Mensaje;
import DTO.Usuario;



public class Mensajeria {

  
	Conexion con;

    public Mensajeria() {
        con = Conexion.getConexion();
    }

    public boolean registrar(Mensaje m) {

        MensajeJPAController mjc = new MensajeJPAController(con.getBd());
        for (Mensaje me : this.getMensajes()) {
            if (me.getNombre().equals(m.getNombre()) && me.getEmail().equals(m.getEmail()) && me.getMensaje().equals(m.getMensaje())) {
                return false;
            }
        }
        mjc.create(m);
        return true;
    }

    public List<Mensaje> getMensajes() {
        MensajeJPAController mjc = new MensajeJPAController(con.getBd());
        List<Mensaje> lmen = mjc.findMensajeEntities();
        if (lmen != null) {
            return lmen;
        }
        return null;
    }

    public Mensaje getMensajeById(int id) {
        MensajeJPAController mjc = new MensajeJPAController(con.getBd());
        return mjc.findMensaje(id);
    }

    public void update(Mensaje m) {
        MensajeJPAController mjc = new MensajeJPAController(con.getBd());
        try {
            mjc.edit(m);
        } catch (Exception ex) {
            Logger.getLogger(Mensajeria.class.getName(), null).log(Level.SEVERE, null, ex);
        }
    }

    public void removMensaje(int id) {
        MensajeJPAController mjc = new MensajeJPAController(con.getBd());
        try {
            mjc.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Mensajeria.class.getName(), null).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> getUsuario() {
        UsuarioJPAController ujc = new UsuarioJPAController(con.getBd());
        List<Usuario> lu = ujc.findUsuarioEntities();
        return lu;
    }

    public Usuario buUsuario(String u) {
        List<Usuario> lu = this.getUsuario();
        for (Usuario usuario : lu) {
            if (usuario.getUsuario().equals(u)) {
                return usuario;
            }
        }
        return null;
    }

}
