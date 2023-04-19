package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconnection {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mariadb://172.22.201.51/IlParoliereLaCaGa";

    private static final String DB_USER = "utentedb";
    private static final String DB_PASSWORD = "Cobi_2022_$";

    private Connection dbConnection = null;

    public dbconnection() {
        String url;
        Connection con = null;
        System.out.println("Inizio Connessione...");
        try {
            //The newInstance() call is a work around for some
            //broken Java implementations
            System.out.println("Cerco i driver...");
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver trovati");
        } catch (Exception ex) {
            //handle the error
            System.out.println("errore JDBC");
        }

        try
        {
            this.dbConnection = null;
            System.out.println("Provo a connettermi al Database...");
            this.dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            System.out.println("SQL Connection to DB eseguita correttamente!");
        }
        catch (SQLException e)
        {
            System.out.println("Connection to dbmio database failed");
            System.out.println(e.getErrorCode() + ":" + e.getMessage());
            //throw new SQLException(e.getErrorCode() + ":" + e.getMessage());
        }
    }

    public ResultSet querySelect(String query) {
        Statement stmt = null;
        ResultSet UtentiList = null;

        try {
            stmt = this.dbConnection.createStatement();
            UtentiList = stmt.executeQuery(query);

        } catch(SQLException sqle) {
            System.out.println("SELECT ERROR");
        } catch(Exception err) {
            System.out.println("GENERIC ERROR");
        }

        return UtentiList;
    }

    public boolean queryInsert(String query) {
        Statement stmt = null;
        boolean success = false;

        try {
            stmt = this.dbConnection.createStatement();
            stmt.executeQuery(query);
            success = true;
        } catch(SQLException sqle) {
            System.out.println("INSERT ERROR");
        } catch(Exception err) {
            System.out.println("GENERIC ERROR");
        }

        return success;
    }

    public boolean queryUpdate(String query) {
        Statement stmt = null;
        boolean success = false;

        try {
            stmt = this.dbConnection.createStatement();
            stmt.executeQuery(query);
            success = true;
        } catch(SQLException sqle) {
            System.out.println("UPDATE ERROR");
        } catch(Exception err) {
            System.out.println("GENERIC ERROR");
        }

        return success;
    }
}
