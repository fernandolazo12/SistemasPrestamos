/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysprestamos.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alum.fial8
 */
public class EAP {
    private int idEap;
    private int idFacultad;
    private String escuela;

    public EAP() {
    }

    public EAP(int idFacultad, String escuela) {
        this.idFacultad = idFacultad;
        this.escuela = escuela;
    }

    public int getIdEap() {
        return idEap;
    }

    public void setIdEap(int idEap) {
        this.idEap = idEap;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    } 
    public static EAP loadEap(ResultSet rs) throws SQLException{
	EAP eap  = new EAP();
        eap.setIdEap(rs.getInt("idEAP"));        
        eap.setEscuela(rs.getString("Escuela"));
        eap.setIdFacultad(rs.getInt("idFacultad"));
		
        return eap;
    }

}
