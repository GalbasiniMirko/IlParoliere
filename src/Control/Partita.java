package Control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Partita {
    private int id;
    private String Username;
    private String Difficoltà;
    private int Punteggio;

    //COSTRUTTORE VUOTO
    public Partita(){

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

    //INSERISCI DATI
    public boolean inserisciDati() {
        dbconnection connessione1 = new dbconnection();
        String query = "INSERT INTO Partita (Username, Difficoltà, Punteggio) VALUES ('Galba', 'difficile', 100)";
        boolean success = connessione1.queryInsert(query);

        return success;
    }
    //VISUALIZZA PUNTEGGIO
    public Object[][] visualizzaMiglioriF() {
        dbconnection connessione = new dbconnection();
        String query = "SELECT p1.Username, p1.Difficoltà, p1.Punteggio FROM Partita p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'facile' AND p2.Difficoltà = 'facile' " +
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
        String query = "SELECT p1.Username, p1.Difficoltà, p1.Punteggio FROM Partita p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'medio' AND p2.Difficoltà = 'medio' " +
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
        String query = "SELECT p1.Username, p1.Difficoltà, p1.Punteggio FROM Partita p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'difficile' AND p2.Difficoltà = 'difficile' " +
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
}



