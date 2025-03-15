package edu.codegym.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ServletPerderTest {

     private ServletPerder servlet;
    private HttpServletRequest request;
    private HttpServletResponse resp;
    private HttpSession session;
    private ServletContext context;
    private ServletConfig servletConfig;

    @BeforeEach
    void setUp() {
        try {
            servlet = new ServletPerder();
            request = mock(HttpServletRequest.class);
            resp = mock(HttpServletResponse.class);
            session = mock(HttpSession.class);
            context = mock(ServletContext.class);
            servletConfig = mock(ServletConfig.class);


            when(request.getSession()).thenReturn(session);
            when(session.getAttribute("playerName")).thenReturn("Karen");
            when(servletConfig.getServletContext()).thenReturn(context);


            servlet.init(servletConfig);


            Map<String, int[]> estadisticas = new HashMap<>();
            when(context.getAttribute("estadisticas")).thenReturn(estadisticas);

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testJugadorRechazaDesafio() throws IOException, ServletException {

        when(request.getParameter("desafio")).thenReturn("false");


        servlet.doPost(request, resp);


        verify(resp).sendRedirect("perder.jsp");
    }

    @Test
    void testJugadorAceptaDesafio() throws IOException, ServletException {

        when(request.getParameter("desafio")).thenReturn("true");


        servlet.doPost(request, resp);

        // Verificamos si se redirige a index ,
        verify(resp).sendRedirect("index.jsp");
    }

    @Test
    void testJugadorNoEncontrado() throws IOException, ServletException {

        when(session.getAttribute("playerName")).thenReturn(null);


        servlet.doPost(request, resp);
        verify(resp).sendRedirect("nombre.jsp");
    }

    @Test
    void testJugadorPierdeIncrementaDerrotas() throws IOException, ServletException {

        when(request.getParameter("desafio")).thenReturn("false");

        // Obtenemos las estadísticas
        Map<String, int[]> estadisticas = (Map<String, int[]>) context.getAttribute("estadisticas");

        // Llamamos al método doPost
        servlet.doPost(request, resp);

        // Verificamos si las derrotasestán aumentando
        assertEquals(1, estadisticas.get("Karen")[0]); // Incremento de derrotas
    }
}
