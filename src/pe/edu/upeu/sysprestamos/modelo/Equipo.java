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
 * @author alum.fial7
 */
public class Equipo {
    private int idEquipo;
    private int idInventario;
    private String nombEq;
    private String marca;
    private String modelo;
    private String serie;
    private int estado;

    public Equipo() {
    }

    public Equipo(int idInventario, String nombEq, String marca, String modelo, String serie, int estado) {
        this.idInventario = idInventario;
        this.nombEq = nombEq;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.estado = estado;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getNombEq() {
        return nombEq;
    }

    public void setNombEq(String nombEq) {
        this.nombEq = nombEq;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    public static Equipo loadEquipo(ResultSet rs) throws SQLException{
	Equipo equipo  = new Equipo();
        equipo.setIdEquipo(rs.getInt("idEquipo"));
        equipo.setNombEq(rs.getString("Nombre"));
        equipo.setMarca(rs.getString("Marca"));
        equipo.setModelo(rs.getString("Modelo"));
        equipo.setSerie(rs.getString("Nro_Serie"));
        equipo.setEstado(rs.getInt("Estado"));
        equipo.setIdInventario(rs.getInt("idDetalleInventario"));
        
		
        return equipo;
    }
}
