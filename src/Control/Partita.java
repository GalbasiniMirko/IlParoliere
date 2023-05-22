package Control;

import View.FrameGioco;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Partita {
    private int id;
    private String Username;
    private String Difficoltà;
    private int Punteggio;
    private int numeroParole;

    //COSTRUTTORE VUOTO
    public Partita() {

    }

    //GETTER E SETTER
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getDifficoltà() {
        return Difficoltà;
    }
    public void setDifficoltà(String difficoltà) {
        Difficoltà = difficoltà;
    }
    public int getPunteggio() {
        return Punteggio;
    }
    public void setPunteggio(int punteggio) {
        Punteggio = punteggio;
    }
    public int getNumeroParole() {
        return numeroParole;
    }
    public void setNumeroParole(int numeroParole) {
        this.numeroParole = numeroParole;
    }

    //INSERISCI DATI NEL DB
    public boolean inserisciDati() {
        dbconnection connessione1 = new dbconnection();
        String query = "INSERT INTO Partita (Username, Difficoltà, Punteggio, numeroParole) VALUES ('"+Username+"', '"+Difficoltà+"', "+Punteggio+", "+numeroParole+")";
        boolean success = connessione1.queryInsert(query);

        return success;
    }

    //VISUALIZZA PUNTEGGIO
    public Object[][] visualizzaMiglioriF() {
        dbconnection connessione = new dbconnection();
        String query = "SELECT p1.Username, p1.Difficoltà, p1.Punteggio, p1.numeroParole FROM Partita p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'facile' AND p2.Difficoltà = 'facile' " +
                "ORDER BY p1.Punteggio DESC";
        ResultSet resultSet = connessione.querySelect(query);

        try {
            // Determina il numero di righe nel ResultSet
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();

            // Ottieni il numero di colonne nel ResultSet
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Crea una matrice di oggetti per i risultati
            Object[][] resultMatrix = new Object[rowCount][columnCount];

            int row = 0;
            while (resultSet.next()) {
                for (int col = 0; col < columnCount; col++) {
                    resultMatrix[row][col] = resultSet.getObject(col + 1);
                }
                row++;
            }

            return resultMatrix;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Restituisce null in caso di errore
    }

    public Object[][] visualizzaMiglioriM() {
        dbconnection connessione = new dbconnection();
        String query = "SELECT p1.Username, p1.Difficoltà, p1.Punteggio, p1.numeroParole FROM Partita p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'medio' AND p2.Difficoltà = 'medio' " +
                "ORDER BY p1.Punteggio DESC";
        ResultSet resultSet = connessione.querySelect(query);

        try {
            // Determina il numero di righe nel ResultSet
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();

            // Ottieni il numero di colonne nel ResultSet
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Crea una matrice di oggetti per i risultati
            Object[][] resultMatrix = new Object[rowCount][columnCount];

            int row = 0;
            while (resultSet.next()) {
                for (int col = 0; col < columnCount; col++) {
                    resultMatrix[row][col] = resultSet.getObject(col + 1);
                }
                row++;
            }

            return resultMatrix;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Restituisce null in caso di errore
    }

    public Object[][] visualizzaMiglioriD() {
        dbconnection connessione = new dbconnection();
        String query = "SELECT p1.Username, p1.Difficoltà, p1.Punteggio, p1.numeroParole FROM Partita p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'difficile' AND p2.Difficoltà = 'difficile' " +
                "ORDER BY p1.Punteggio DESC";
        ResultSet resultSet = connessione.querySelect(query);

        try {
            // Determina il numero di righe nel ResultSet
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();

            // Ottieni il numero di colonne nel ResultSet
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Crea una matrice di oggetti per i risultati
            Object[][] resultMatrix = new Object[rowCount][columnCount];

            int row = 0;
            while (resultSet.next()) {
                for (int col = 0; col < columnCount; col++) {
                    resultMatrix[row][col] = resultSet.getObject(col + 1);
                }
                row++;
            }

            return resultMatrix;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Restituisce null in caso di errore
    }

    public boolean controllaParolaNelDatabase(String parola) {
        boolean parolaEsistente = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //connesione al database
            conn = DriverManager.getConnection("jdbc:mariadb://172.22.201.51/IlParoliereLaCaGa", "utentedb", "Cobi_2022_$");
            String query = "SELECT COUNT(*) FROM parole WHERE parola = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, parola);

            rs = stmt.executeQuery();
            if (rs.next()) {   //controlla se c'è una riga nel database che corrisponde
                int count = rs.getInt(1); // se presente viene preso il valore del conteggio
                if(count > 0){
                    parolaEsistente = true;
                }
                //parolaEsistente = count > 0; // se il conteggio è >0 la stringa viene messa true altrimenti false
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { //rilascia la connessione e libera le risorse usate
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return parolaEsistente; //restituisce true se la parola è stata trovata o meno
    }

    public void visDati(){
        System.out.println(getUsername());
        System.out.println(getDifficoltà());
    }
}



