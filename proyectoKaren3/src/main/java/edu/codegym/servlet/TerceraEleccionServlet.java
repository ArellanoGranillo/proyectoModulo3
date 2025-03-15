package edu.codegym.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/terceraEleccion")
public class TerceraEleccionServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Iniciando Servlet tercera elección");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if (opcion == null) {
            response.sendRedirect("terceraEleccion.jsp");
            return;
        }

        System.out.println("Opción elegida: " + opcion);

        switch (opcion) {
            case "izquierda":
                response.sendRedirect("perder.jsp");
                break;
            case "derecha":
                response.sendRedirect("final.jsp");
                break;
            default:
                response.sendRedirect("terceraEleccion.jsp");
                break;
        }
    }
}