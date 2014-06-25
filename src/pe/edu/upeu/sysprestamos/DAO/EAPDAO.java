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
import pe.edu.upeu.sysprestamos.modelo.EAP;

/**
 *
 * @author alum.fial8
 */
public class EAPDAO {
    int res;
    int id;
    int op;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
    public int validarEap(String esc){
        sql="SELECT *FROM EAP WHERE Escuela='"+esc+"'";
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
    public int varificarEap(String esc){
        sql="SELECT * FROM EAP WHERE Escuela='"+esc+"'";
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
    public int registrarEap(int idf, String escuela){
        sql="INSERT INTO EAP VALUES(null,'"+escuela+"','"+idf+"')";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }         
    return res;
    }
    public ArrayList<EAP> listarEap(){
        ArrayList<EAP> lista = new ArrayList();
        sql = "select *from EAP";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(EAP.loadEap(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
     public int modificarEap(int idEap, String esc){
        sql="UPDATE EAP set Escuela='"+esc+"' WHERE idEAP='"+idEap+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public int eliminarEap(int idEap){
        sql="DELETE FROM EAP WHERE idEAP='"+idEap+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
    public ArrayList<EAP> listarEap(int idEap){
        ArrayList<EAP> lista = new ArrayList();
        sql = "select *from EAP WHERE idEAP="+idEap;
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(EAP.loadEap(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public ArrayList<EAP> listarEap(String esc){
           ArrayList<EAP> lista = new ArrayList();
        sql = "Select * From EAP WHERE Escuela LIKE '"+esc+"'%";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(EAP.loadEap(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
}


