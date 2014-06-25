/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysprestamos.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fernando
 */
public class Usuario {
    
    private int idUsuario;
    private int idPersona;
    private String usuario;
    private String clave;

    public Usuario() {
    }

    public Usuario(int idPersona, String usuario, String clave) {
        this.idPersona = idPersona;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

   public static Usuario loadUsuario(ResultSet rs) throws SQLException{
		Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
		usuario.setUsuario(rs.getString("Login"));
		usuario.setClave(rs.getString("Clave"));
                usuario.setIdPersona(rs.getInt("idPersona"));
                
	return usuario;
	}

}
