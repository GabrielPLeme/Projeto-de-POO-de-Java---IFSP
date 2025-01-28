/*
Estabelece conexão com a Database

EDITADO POR ULTIMO:
VINIE - 16/11/23
*/

//************************************************************************************************
package Modelo;
import java.sql.*;

public class Conexao {
    private String DB_URL = "jdbc:mysql://localhost:3306/testejava";
    private String USER = "root";
    private String PASS = "ninjas2013";
    //private String PASS = "";
    private Connection conn;

    Conexao() {
      // Abre conexao
      try {
         this.conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
    }
    // MySQL Insert
    public int inserir(String comando) throws SQLException {
        Statement stmt = this.conn.createStatement();
        int rs = stmt.executeUpdate(comando);  
        return rs;  
    }
    // MySQL Update Query
    public int atualizar(String comando) throws SQLException {
        Statement stmt = this.conn.createStatement();
        int rs = stmt.executeUpdate(comando);  
        return rs;  
    }
    // MySQL Delete
    public int apagar(String comando) throws SQLException {
        Statement stmt = this.conn.createStatement();
        int rs = stmt.executeUpdate(comando);  
        return rs;  
    }

    // MySQL Select Query
    public ResultSet listar(String comando) throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery(comando);  
        return rs;  
    }

}
