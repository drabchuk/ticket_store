package Model.Manager;

import database.DBWorker;

/**
 * Created by Δενθρ on 16.09.2015.
 */
public abstract class ClientsManager {
    static public void add(String name, int surname) {
        String query = "INSERT INTO clients (name, surname) VALUES ('"+ name +"', "+ surname +")";
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void update(int id, String name, String surname) {
        String query = "UPDATE clients SET name = '" + name + "', surname = '"+ surname +"' WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void delete(int id) {
        String query = "DELETE FROM clients WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

}
