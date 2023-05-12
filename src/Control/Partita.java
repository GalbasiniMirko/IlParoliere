package Control;

import Control.dbconnection;

import java.sql.ResultSet;

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
    public ResultSet visualizzaMiglioriF(){
        dbconnection connessione = new dbconnection();
        String query = "SELECT  p1.Username, p1.Punteggio FROM Partita  p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'facile' AND p2.Difficoltà = 'facile' " +
                "ORDER BY p1.Punteggio DESC ";
        ResultSet success =connessione.querySelect(query);
        return success;
    }

    public ResultSet visualizzaMiglioriM(){
        dbconnection connessione = new dbconnection();
        String query = "SELECT  p1.Username, p1.Punteggio FROM Partita  p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'medio' AND p2.Difficoltà = 'medio' " +
                "ORDER BY p1.Punteggio DESC ";
        ResultSet success =connessione.querySelect(query);
        return success;
    }
    public ResultSet visualizzaMiglioriD(){
        dbconnection connessione = new dbconnection();
        String query = "SELECT  p1.Username, p1.Punteggio FROM Partita  p1 JOIN Partita p2 ON p1.Username = p2.Username WHERE p1.Difficoltà = 'difficile' AND p2.Difficoltà = 'difficile' " +
                "ORDER BY p1.Punteggio DESC ";
        ResultSet success =connessione.querySelect(query);
        return success;
    }

}


