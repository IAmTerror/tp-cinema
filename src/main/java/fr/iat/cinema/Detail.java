package fr.iat.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fred on 03/02/2016.
 *
 * @author student : IAmTerror
 */

public class Detail extends HttpServlet {

    List<Film> filmsConsultesSession;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        filmsConsultesSession = (List<Film>) session.getAttribute("listeFilmsConsultes");

        if (filmsConsultesSession == null) {
            filmsConsultesSession = new ArrayList<Film>();
            session.setAttribute("listeFilmsConsultes", filmsConsultesSession);
        }

        Integer id = Integer.parseInt(request.getParameter("id"));
        FilmsDonnees fd = new FilmsDonnees();
        Film film = fd.getById(id);

        filmsConsultesSession.add(film);

        // pour les besoins de la vue
        request.setAttribute("film", film);

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Detail du film sélectionné</title>");
//        out.println("<head>");
//        out.println("<body>");
//        out.println("<h1>Film sélectionné :</h1>");
//        out.println("<a>Nom du film : " + film.titre + "</a>");
//        out.println("<br />");
//        out.println("<br />");
//        out.println("<a>Note du film : " + film.note + "</a>");
//        out.println("<br />");
//        out.println("<br />");
//        out.println("<img src='affiche?id=" + film.id + "'>");
//        out.println("<ul>");
//        out.println("</ul>");
//        out.println("</body>");
//        out.println("</html>");

        // délégation à la vue
        String jspview = "detail.jsp";
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/" + jspview).forward(request, response);
    }
}
