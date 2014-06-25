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
import pe.edu.upeu.sysprestamos.modelo.Persona;

/**
 *
 * @author alum.fial8
 */
public class PersonaDAO {
    int res;
    int op;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
    public int devolverIdPersona(String nomb){
    int id = 0;
    sql = "SELECT * from Persona WHERE  Nombre= '"+nomb+"'";
    try{
        st = cx.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            id = rs.getInt("idPersona");
        }
       // cx.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"error" +ex);
    }
      return id;
    }
    
    public int validarPersona(String nomb , String pat, String mat, String sex, int dni, int cel, String dir ){
    
        sql="SELECT * FROM Persona WHERE Nombre='"+nomb+"' AND Paterno='"+pat+"' AND Materno='"+mat+"' AND Sexo='"+sex+"' AND DNI='"+dni+"' AND Celular='"+cel+"' AND Direccion='"+dir+"'";
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
     public int varificarPersona(String nomb){
        sql="SELECT * FROM Persona WHERE Nombre='"+nomb+"'";
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
     public int registrarPersona(String nomb, String pat, String mat, String sex, int dni, int cel, String dir){
        sql="INSERT INTO Persona VALUES(null,'"+nomb+"','"+pat+"','"+mat+"','"+sex+"','"+dni+"','"+cel+"','"+dir+"')";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }         
    return res;
    }
    public ArrayList<Persona> listarPersona(){
        ArrayList<Persona> lista = new ArrayList();
        sql = "select *from Persona";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Persona.loadPersona(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public int modificarPersona(int idP, String nombre, String paterno, String materno, int dni, int celular, String direccion){
        sql="UPDATE Persona set Nombre='"+nombre+"', Paterno='"+paterno+"', Materno='"+materno+"', DNI='"+dni+"', Celular='"+celular+"', Direccion='"+direccion+" WHERE idPersona='"+idP+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public int eliminarPersona(int idP){
        sql="DELETE FROM Persona WHERE idPersona='"+idP+"'";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
    public ArrayList<Persona> listarPersona(int id){
        ArrayList<Persona> lista = new ArrayList();
        sql = "select *from Persona WHERE idPersona="+id;
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Persona.loadPersona(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    
    public ArrayList<Persona> listarPersona(String nomb){
    ArrayList<Persona> lista = new ArrayList();
        sql = "select *from Persona WHERE Nombre LIKE '"+nomb+"'%";
        try {
            cx = Conexion.getConex();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Persona.loadPersona(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
}
