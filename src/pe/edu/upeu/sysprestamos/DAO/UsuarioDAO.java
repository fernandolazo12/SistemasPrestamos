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
import pe.edu.upeu.sysprestamos.modelo.Usuario;

/**
 *
 * @author Fernando
 */
public class UsuarioDAO {
    int res;
    Connection conex;
    Statement st;
    ResultSet rs;
    String sql;
    int op;
    int id;
    
    
   public int validarUsuario(String usua, String clave){
        sql="SELECT *FROM Usuario WHERE Login='"+usua
                +"' AND Clave='"+clave+"'";
        try {
            conex = Conexion.getConex();
            st = conex.createStatement();
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
    public int varificarUsuario(String us){
        sql="SELECT * FROM Usuario WHERE Login='"+us+"'";
        try {
            conex = Conexion.getConex();
            st = conex.createStatement();
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
    public int registrarUsuario(int idp, String user, String cl){
        sql="INSERT INTO Usuario VALUES(null,'"+user+"','"+cl+"','"+idp+")";
        try {
            conex = Conexion.getConex();
            st = conex.createStatement();
            st.executeUpdate(sql);
            conex.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }         
    return res;
    }
    public ArrayList<Usuario> listarUsuario(){
        ArrayList<Usuario> lista = new ArrayList();
        sql = "select *from Usuario";
        try {
            conex = Conexion.getConex();
            st = conex.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuario.loadUsuario(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public int modificarUsuario(int idu, String usuario, String cl){
    sql="UPDATE Usuario set Login='"+usuario+"', Clave='"+cl+"' WHERE idUsuario='"+idu+"'";
        try {
            conex = Conexion.getConex();
            st = conex.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public int eliminarUsuario(int idu){
        sql="DELETE FROM Usuario WHERE idUsuario='"+idu+"'";
        try {
            conex = Conexion.getConex();
            st = conex.createStatement();
            res = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
    public ArrayList<Usuario> listarUsuario(int id){
        ArrayList<Usuario> lista = new ArrayList();
        sql = "select *from Usuario WHERE idUsuario="+id;
        try {
            conex = Conexion.getConex();
            st = conex.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuario.loadUsuario(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public ArrayList<Usuario> listarUsuario(String us){
    ArrayList<Usuario> lista = new ArrayList();
        sql = "Select * From Usuario WHERE Login LIKE '"+us+"'%";
        try {
            conex = Conexion.getConex();
            st = conex.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuario.loadUsuario(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
}
