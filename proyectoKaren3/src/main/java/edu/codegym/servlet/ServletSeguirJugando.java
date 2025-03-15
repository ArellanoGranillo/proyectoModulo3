package edu.codegym.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/elegir")
public class ServletSeguirJugando extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Iniciando Servlet de elección");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String desafio = request.getParameter("desafio");

        // Verificar si el usuario seleccionó "Aceptar el desafío"
        if (desafio != null && desafio.equals("true")) {
            System.out.println("Jugador aceptó el desafío, redirigiendo a nombre.jsp");
            resp.sendRedirect("nombre.jsp");
        } else {
            System.out.println("Jugador rechazó el desafío, redirigiendo a perder.jsp");
            resp.sendRedirect("perder.jsp");
        }
    }
}
