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
public class Inventario {
    private int idInventario;
    private int idEquipo;
    private String equipo;
    private int cantidad;    

    public Inventario() {
    }

    public Inventario(int idEquipo, String equipo, int cantidad) {
        this.idEquipo = idEquipo;
        this.equipo = equipo;
        this.cantidad = cantidad;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    public static Inventario loadInventario(ResultSet rs) throws SQLException{
		Inventario inventario  = new Inventario();
                inventario.setIdInventario(rs.getInt("idDetalleInventario"));
                inventario.setEquipo(rs.getString("Equipo"));
		inventario.setCantidad(rs.getInt("Cantidad"));
                inventario.setIdEquipo(rs.getInt("idEquipo"));
                
		return inventario;
	}
}

