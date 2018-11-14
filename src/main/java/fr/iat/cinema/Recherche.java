package fr.iat.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fred on 03/02/2016.
 *
 * @author student : IAmTerror
 */

public class Recherche extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Film> filmsRecherche = new ArrayList<>();

        HttpSession session = request.getSession();
        String titre = request.getParameter("titre");

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Liste des films recherchés</title>");
//        out.println("<head>");
//        out.println("<body>");
//        out.println("<h1>Liste des films recherchés : </h1>");
//        out.println("<ul>");

        FilmsDonnees fd = new FilmsDonnees();

        // pour les besoins de la vue
        request.setAttribute("films", filmsRecherche);

        for (Film film : fd.lesFilms) {

//            int filmId = film.id;
            String filmTitre = film.titre;

            if (filmTitre.toLowerCase().contains(titre.toLowerCase())) {
//                out.println("<li>");
////                out.println("<a href=\"detail?id=" + filmId + "\">" + film.titre + " (" + film.note + ")</a>");
////                out.println("</li>");
                filmsRecherche.add(film);
            }
        }
//        out.println("</ul>");
//        out.println("</body>");
//        out.println("</html>");

        // délégation à la vue
        String jspview = "recherche.jsp";
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/" + jspview).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
