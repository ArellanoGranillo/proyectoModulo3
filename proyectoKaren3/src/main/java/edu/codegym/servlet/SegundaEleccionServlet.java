package edu.codegym.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/segundaEleccion")
public class SegundaEleccionServlet extends HttpServlet {

          @Override
        public void init() throws ServletException {
            super.init();
            System.out.println("Iniciando Servlet segunda elección");
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if (opcion == null) {
            response.sendRedirect("segundaEleccion.jsp");
            return;
        }

        System.out.println("Opción elegida: " + opcion);

        switch (opcion) {
            case "despejado":
                response.sendRedirect("perder.jsp");
                break;
            case "selva":
                response.sendRedirect("terceraEleccion.jsp");
                break;
            default:
                response.sendRedirect("segundaEleccion.jsp");
                break;
        }
    }
}

