package Control;

import Control.dbconnection;

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
}
