package fr.laerce.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collections;

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

        // TODO: voir si l'on peut gérer le tri avec des lambdas expression JAVA8
        // doc : https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
        String sort = request.getParameter("sort");

        if (sort.equals("asc")) {
            Collections.sort(fd.lesFilms, new FilmComparatorAsc());
        } else if (sort.equals("desc")) {
            Collections.sort(fd.lesFilms, new FilmComparatorDesc());
        }

        for (Film film : fd.lesFilms) {
            int filmId = film.id;
            out.println("<li>");
            out.println("<a href=\"detail?id="+filmId+"\">"+film.titre+"</a>");
            out.println("</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");


    }
}
