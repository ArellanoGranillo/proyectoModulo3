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

class FinalServletTest {

    private FinalServlet servlet;
     private HttpServletRequest request;
    private HttpServletResponse resp;
    private HttpSession session;
    private ServletContext context;
      private ServletConfig servletConfig;

    @BeforeEach
    void setUp() {
        try {
            servlet = new FinalServlet();
            request = mock(HttpServletRequest.class);
            resp = mock(HttpServletResponse.class);
            session = mock(HttpSession.class);
             context = mock(ServletContext.class);
            servletConfig = mock(ServletConfig.class);


            when(request.getSession()).thenReturn(session);
            when(session.getAttribute("playerName")).thenReturn("Karen");
            when(servletConfig.getServletContext()).thenReturn(context);

            // llamamos al init
            servlet.init(servletConfig);

            // Simular estadísticas
            Map<String, int[]> estad = new HashMap<>();
            when(context.getAttribute("estadisticas")).thenReturn(estad);

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testJugadorGana() throws IOException, ServletException {

        Map<String, int[]> estad = (Map<String, int[]>) context.getAttribute("estadisticas");

        // se incrementan las victorias,
        when(request.getParameter("desafio")).thenReturn("true");

        servlet.doPost(request, resp);

        // Verificar si se incrementaron las estadísticas
        assertEquals(1, estad.get("Karen")[1]);
    }

    @Test
    void testJugadorNoEncontrado() throws IOException, ServletException {

        when(session.getAttribute("playerName")).thenReturn(null);

        servlet.doPost(request, resp);
        verify(resp).sendRedirect("nombre.jsp");
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
        verify(resp).sendRedirect("index.jsp");
    }
}
