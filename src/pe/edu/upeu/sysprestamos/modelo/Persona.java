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
public class Persona {
    private int idPersona;
    private String Nombre;
    private String Paterno;
    private String Materno;
    private String Sexo;
    private int DNI;
    private int Celular;
    private String Direccion;

    public Persona() {
    }

    public Persona(String Nombre, String Paterno, String Materno, String Sexo, int DNI, int Celular, String Direccion) {
        this.Nombre = Nombre;
        this.Paterno = Paterno;
        this.Materno = Materno;
        this.Sexo = Sexo;
        this.DNI = DNI;
        this.Celular = Celular;
        this.Direccion = Direccion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPaterno() {
        return Paterno;
    }

    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    public String getMaterno() {
        return Materno;
    }

    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int Celular) {
        this.Celular = Celular;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public static Persona loadPersona(ResultSet rs) throws SQLException{
		Persona persona  = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
		persona.setNombre(rs.getString("Nombre"));
		persona.setPaterno(rs.getString("Paterno"));
                persona.setMaterno(rs.getString("Materno"));
                persona.setSexo(rs.getString("Sexo"));
                persona.setDNI(rs.getInt("DNI"));
                persona.setCelular(rs.getInt("Celular"));
                persona.setDireccion(rs.getString("Direccion"));
                
		return persona;
	}   
}
