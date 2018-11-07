package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/**
 * Created by fred on 03/02/2016.
 */

public class Detail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        FilmsDonnees fd = new FilmsDonnees();
        Film film = fd.getById(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Detail du film sélectionné</title>");
        out.println("<head>");
        out.println("<body>");
        out.println("<h1>Film sélectionné :</h1>");
        out.println("<a>Nom du film : "+ film.titre +"</a>");
        out.println("<br />");
        out.println("<br />");
        out.println("<a>Nom du film : "+ film.note +"</a>");
        out.println("<br />");
        out.println("<br />");
        out.println("<img src='affiche?id="+film.id+"'>");
        out.println("<ul>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}
