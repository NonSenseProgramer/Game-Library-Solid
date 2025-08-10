package DAO;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conector {
    
protected Connection conn;
    
  public boolean conectar(){
        /*
      Conecta ao banco de dados
      */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/game_library","root","Jooj+2019Fla");
         
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Falha na conexão com o banco " + ex.getMessage());
            return false;
        }
    }
  public PreparedStatement prepareStatement (String sql)
  {
      try
      {
  PreparedStatement stmt = conn.prepareStatement(sql);
  return stmt;
      }
      catch(SQLException e)
      {
       JOptionPane.showMessageDialog(null,"Ocorreu algum erro ao preparar " + e.getMessage());
       return null;
      }
  }

  public void fecharConexao()
  {
      try {
          conn.close();
      } catch (SQLException ex) {
          Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
 
}