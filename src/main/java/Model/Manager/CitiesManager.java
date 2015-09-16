package Model.Manager;

import database.DBWorker;

/**
 * Created by Δενθρ on 16.09.2015.
 */
public abstract class CitiesManager {
    static public void add(String name) {
        String query = "INSERT INTO cities (name) VALUES ('"+ name +"')";
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void update(int id, String name, int seats) {
        String query = "UPDATE buses SET name = '" + name + "', seats = "+ seats +" WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void update(int id, String name) {
        String query = "UPDATE cities SET name = '" + name + "' WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
    static public void delete(int id) {
        String query = "DELETE FROM cities WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
}
