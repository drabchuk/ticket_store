package Model.Manager;

import database.DBWorker;

/**
 * Created by Δενθρ on 16.09.2015.
 */
public abstract class BusConfigManager {
    static public void addOneSeat(long bus, long seat, long row, long place) {
        String query = "INSERT INTO bus_config (bus, seat, row, place) VALUES ("+ bus +", "+ seat +", "+ row +", "+ place +")";
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }

    static public void delete(int id) {
        String query = "DELETE FROM bus_config WHERE Id = " + id;
        DBWorker dbWorker = new DBWorker();
        dbWorker.execute(query);
        dbWorker.closeConnection();
    }
}
