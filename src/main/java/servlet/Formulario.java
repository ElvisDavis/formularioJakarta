package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registro")
public class Formulario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username=req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        PrintWriter out = resp.getWriter();
        //Creo la plantilla html
        out.print("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>Resultado Formulario</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>resultado formualrio</h1>");
        out.println("<div>");

        out.println("<p>User: " + username + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
}
