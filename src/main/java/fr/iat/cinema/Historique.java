package fr.iat.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by fred on 03/02/2016.
 *
 * @author student : IAmTerror
 */

public class Historique extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Liste des films</title>");
        out.println("<head>");
        out.println("<body>");
        out.println("<h1>Les films : </h1>");
        out.println("<ul>");


        HttpSession session = request.getSession();
        List<Film> filmsVus = (List<Film>) session.getAttribute("listeFilmsConsultes");

        for (Film film : filmsVus) {
            out.println("<li>" + film.titre + " (" + film.note + ")</li>");

        }

        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}
