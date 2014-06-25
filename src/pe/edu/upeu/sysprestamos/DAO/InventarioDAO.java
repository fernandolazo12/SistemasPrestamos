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
import pe.edu.upeu.sysprestamos.modelo.Inventario;

/**
 *
 * @author alum.fial8
 */
public class InventarioDAO {
    int res;
    int id;
    int op;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    public int devolverIdInventario(String equi){
    sql = "SELECT * from DetalleInventario WHERE Equipo = '"+equi+"'";
    try{
        st = cx.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            id = rs.getInt("idDetalleInventario");
        }
       // cx.close();
    }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"error" +ex);
            }
            return id;
    }
     public int validarInventario(String equi, int cant){
    
        sql="SELECT * FROM DetalleInventario WHERE Equipo='"+equi+"' AND Cantidad'"+cant+"'";
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
    public int varificarInventario(String equi){
        sql="SELECT * FROM DetalleInventario WHERE Equipo='"+equi+"'";
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
    public int registrarIventario(String equi, int cant){
        sql="INSERT INTO DetalleInventario VALUES(null,'"+equi+"','"+cant+"')";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }         
    return res;
    }
    public ArrayList<Inventario> listarInventario(){
        ArrayList<Inventario> lista = new ArrayList();
        sql = "select *from DetalleInventario";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Inventario.loadInventario(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public int modificarInventario(int iddet, String equi, int cant){
        sql="UPDATE DetalleInventario set Equipo='"+equi+"', Cantidad='"+cant+"' WHERE idDetalleInventario='"+iddet+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public int eliminarInventario(int iddet){
        sql="DELETE FROM DetalleInventario WHERE idDetalleInventario='"+iddet+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
    public ArrayList<Inventario> listarInventario(int iddet){
        ArrayList<Inventario> lista = new ArrayList();
        sql = "select *from DetalleInventario WHERE idDetalleInventario="+iddet;
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Inventario.loadInventario(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public ArrayList<Inventario> listarInventario(String equi){
        ArrayList<Inventario> lista = new ArrayList();
        sql = "select *from DetalleInventario WHERE Equipo LIKE '"+equi+"'%";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Inventario.loadInventario(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    } 
}
