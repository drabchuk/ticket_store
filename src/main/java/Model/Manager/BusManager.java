package Model.Manager;

import Model.Entity.Bus;
import database.DBWorker;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public abstract class BusManager {
    static public void add(String name, int seats) {
        //String query = "INSERT INTO buses (name, seats) VALUES ('" + bus.getName() + "', " + bus.getSeats() + ")";
        String query = "INSERT INTO buses (name, seats) VALUES ('"+ name +"', "+ seats +")";
        //String query = "SELECT name FROM buses WHERE id = 1";
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

    static public void updateName(int id, String name) {
        String query = "UPDATE buses SET name = '" + name + "' WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void updateSeats(int id, int seats) {
        String query = "UPDATE buses SET seats = '" + seats + "' WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
    static public void delete(int id) {
        String query = "DELETE FROM buses WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
}
