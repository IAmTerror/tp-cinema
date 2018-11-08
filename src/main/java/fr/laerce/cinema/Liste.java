package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by fred on 03/02/2016.
 */

public class Liste extends HttpServlet {
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

        FilmsDonnees fd = new FilmsDonnees();

        // doc : https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
        String sort = request.getParameter("sort");

        /* sort alphabétique ascendant ou descendant **/
        // avec l'interface Comparator
        if (sort.equals("_name_asc")) {
            // avec l'interface Comparator
//            Collections.sort(fd.lesFilms, new FilmComparatorAsc());
            // avec une expression lambda (méthode plus légère)
            // TODO : le tri ascendant ne fonctionne plus... pourquoi ?
            Collections.sort(fd.lesFilms,
                    (Film o1, Film o2) -> o1.titre.compareToIgnoreCase(o2.titre));
        } else if (sort.equals("name_desc")) {
            // avec l'interface Comparator
//            Collections.sort(fd.lesFilms, new FilmComparatorDesc());
            // avec une expression lambda (méthode plus légère)
            Collections.sort(fd.lesFilms,
                    (Film o1, Film o2) -> o2.titre.compareToIgnoreCase(o1.titre));
        } else if (sort.equals("note_asc")) {
            /* sort par note du film, ascendant ou descendant **/
            Collections.sort(fd.lesFilms,
                    Comparator.comparingDouble((Film o) -> o.note));
        } else if (sort.equals("note_desc")) {
            Collections.sort(fd.lesFilms,
                    (Film o1, Film o2) -> Double.compare(o2.note, o1.note));
        }




        for (Film film : fd.lesFilms) {
            int filmId = film.id;
            out.println("<li>");
            out.println("<a href=\"detail?id="+filmId+"\">"+film.titre+" ("+film.note+")</a>");
            out.println("</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");


    }
}
