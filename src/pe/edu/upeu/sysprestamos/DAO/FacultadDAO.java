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
import pe.edu.upeu.sysprestamos.modelo.Facultad;

/**
 *
 * @author alum.fial8
 */
public class FacultadDAO {
    int res;
    int id;
    int op;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;

    public int devolverIdFacultad(String facu){
    sql = "SELECT * from Facultad WHERE Facultad = '"+facu+"'";
    try{
        st = cx.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            id = rs.getInt("idFacultad");
        }
       // cx.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"error" +ex);
    }
      return id;
    }
    public int validarFacultad(String facu){
    
        sql="SELECT * FROM Facultad WHERE Facultad='"+facu+"'";
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
     public int varificarFacultad(String facu){
        sql="SELECT * FROM Facultad WHERE Facultad='"+facu+"'";
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
    public int registrarFacultad(String facultad){
        sql="INSERT INTO Facultad VALUES(null,'"+facultad+"')";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }         
    return res;
    }
    
    public ArrayList<Facultad> listarFacultad(){
        ArrayList<Facultad> lista = new ArrayList();
        sql = "select *from Facultad";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Facultad.loadFacultad(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public int modificarFacultad(int idf, String facu){
        sql="UPDATE Facultad set Facultad='"+facu+"' WHERE idFacultad='"+idf+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
     public int eliminarFacultad(int idf){
        sql="DELETE FROM Facultad WHERE idFacultad='"+idf+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
     public ArrayList<Facultad> listarFacultad(int idf){
        ArrayList<Facultad> lista = new ArrayList();
        sql = "select *from Facultad WHERE idFacultad="+idf;
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Facultad.loadFacultad(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public ArrayList<Facultad> listarFacultad(String facu){
        ArrayList<Facultad> lista = new ArrayList();
        sql = "select *from Facultad WHERE Facultad LIKE '"+facu+"'%";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Facultad.loadFacultad(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    } 

}
