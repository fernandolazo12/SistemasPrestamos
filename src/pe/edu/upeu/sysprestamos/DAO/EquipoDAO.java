/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysprestamos.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.upeu.sysprestamos.config.Conexion;
import pe.edu.upeu.sysprestamos.modelo.Equipo;

/**
 *
 * @author alum.fial7
 */
public class EquipoDAO {
    int res;
    int id;
    int op;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
    public int validarEquipo(String nombeq, String mar, String mod, int num, int estado){
        sql="SELECT *FROM Equipo WHERE Nombre='"+nombeq+"' AND Marca='"+mar+"' AND Modelo='"+mod+"' AND NroSerie='"+num+"' AND Estado='"+estado+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            //cx.close();
            if(rs.next()){
                res=1;
            }else{
                res=2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }    
    return res;
    }
    public int verificarEquipo(String nombeq){
        sql="SELECT * FROM Equipo WHERE Nombre='"+nombeq+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                op = 1;
            }else{
                op = 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
    return op;    
    }
    public int registrarEquipo(int idInv, String nombeq, String mar, String mod, String ser, int estado){
        sql="INSERT INTO Equipo VALUES(null,'"+nombeq+"','"+mar+"','"+mod+"','"+ser+"','"+estado+"','"+idInv+"')";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }         
    return res;
    }
    public ArrayList<Equipo> listarEquipo(){
        ArrayList<Equipo> lista = new ArrayList();
        sql = "select *from Equipo";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Equipo.loadEquipo(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public int modificarEquipo(int ide, String nombeq, String mar, String mod, String ser, int estado){
        sql="UPDATE Equipo set Nombre='"+nombeq+"', Marca='"+mar+"', Modelo='"+mod+"', Nro_Serie='"+ser+"', Estado='"+estado+"' WHERE idEquipo='"+ide+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public int eliminarEquipo(int ide){
        sql="DELETE FROM Equipo WHERE idEquipo='"+ide+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
    public ArrayList<Equipo> listarEquipo(int ide){
        ArrayList<Equipo> lista = new ArrayList();
        sql = "select *from Equipo WHERE idEquipo="+ide;
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Equipo.loadEquipo(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public ArrayList<Equipo> listarEquipo(String nombeq){
           ArrayList<Equipo> lista = new ArrayList();
        sql = "Select * From Equipo WHERE Nombre LIKE '"+nombeq+"'%";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Equipo.loadEquipo(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
}
