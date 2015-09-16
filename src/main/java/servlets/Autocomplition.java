package servlets;

import Model.Entity.Bus;
import Model.Entity.City;
import Model.Hash.Composer;
import Model.Hash.ComposerData;
import Model.Manager.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Δενθρ on 13.09.2015.
 */
@WebServlet("/autocomplete")
public class Autocomplition extends HttpServlet {

    private ServletContext context;
    private ComposerData compData = new ComposerData();
    private HashMap cities = compData.getCities();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //testing
        /*BusManager.add("bogdan", 21);
        BusManager.update(17, "AA6666NN, bogdan");
        BusManager.delete(16);
        StationManager.add(1, "Peremohy 2 square");
        StationManager.add(1, "Kreschatic");
        StationManager.update(8, 1, "Peremohu square");
        StationManager.add(1, "NSC Olimpiyscy");
        StationManager.delete(7);*/
        //BusManager.add("Abtobus", 10);
        //BusManager.update(19, "Avto", 14);
        //BusManager.add("777", 8);
        //BusManager.updateName(19,"Avto edit");
        //BusManager.updateSeats(19, 16);
        //BusManager.delete(20);
        //BusManager.add("Mercedes Vito", 7);
        //CitiesManager.add("Novoaleksiivka 3");
        //CitiesManager.add("New York");
        //StationManager.add(18, "Magazin piva");
        //StationManager.add(19, "Brighton beach");
        //RouteManager.add(14, 15);
        //TripManager.add(9, 22, "2015-09-16", "15:30:00", "2015-09-16", "19:30:00");

        //testing

        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        StringBuffer sb = new StringBuffer();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        boolean namesAdded = false;
        if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) {

                Iterator it = cities.keySet().iterator();

                while (it.hasNext()) {
                    Integer id = (Integer) it.next();
                    City city = (City) cities.get(id);

                    if ( // targetId matches first name
                            city.getName().toLowerCase().startsWith(targetId) //||
                                    // targetId matches last name
                                    //city.getLastName().toLowerCase().startsWith(targetId) ||
                                    // targetId matches full name
                                    /*city.getFirstName().toLowerCase().concat(" ")
                                            .concat(city.getLastName().toLowerCase()).startsWith(targetId)*/) {

                        sb.append("<city>");
                        sb.append("<id>" + city.getId() + "</id>");
                        sb.append("<firstName>" + city.getName() + "</firstName>");
                        //sb.append("<lastName>" + city.getLastName() + "</lastName>");
                        sb.append("</city>");
                        namesAdded = true;
                    }
                }
            }
            sb.append("<action><name>autocomplete</name></action>");
            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<cities>" + sb.toString() + "</cities>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }
        if (action.equals("lookup")) {

            // put the target composer in the request scope to display
            if ((targetId != null) && cities.containsKey(targetId.trim())) {
                request.setAttribute("composer", cities.get(targetId));
                context.getRequestDispatcher("Reservation.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }
}
