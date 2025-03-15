package edu.codegym.servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/nombre")
public class ServletINombre extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Iniciando Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = request.getParameter("player");

        if (nombre == null || nombre.trim().isEmpty()) {
            resp.sendRedirect("perder.jsp");
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("playerName", nombre);
        System.out.println("Nombre del jugador: " + nombre);

        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect("procesarEleccion.jsp");
    }
}
