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
 * @author alum.fial8
 */
public class Facultad {
    private int idFacultad;
    private String facultad;
    
    public Facultad() {
    }

    public Facultad(String facultad) {
        this.facultad = facultad;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    public static Facultad loadFacultad(ResultSet rs) throws SQLException{
	Facultad facultad  = new Facultad();
        facultad.setIdFacultad(rs.getInt("idFacultad"));
        facultad.setFacultad(rs.getString("Facultad"));
        
		
        return facultad;
    }

}
