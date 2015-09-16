package Model.Manager;

import database.DBWorker;

/**
 * Created by Δενθρ on 12.09.2015.
 */
public abstract class StationManager {
    static public void add(int city, String name) {
        //String query = "INSERT INTO buses (name, seats) VALUES ('" + bus.getName() + "', " + bus.getSeats() + ")";
        String query = "INSERT INTO stations (city, name) VALUES ("+ city + ", '"+ name +"')";
        //String query = "SELECT name FROM buses WHERE id = 1";
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
    static public void update(int id, int city, String name) {
        String query = "UPDATE stations SET city = " + city + ", '"+ name +"' WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
    static public void delete(int id) {
        String query = "DELETE stations WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
}
