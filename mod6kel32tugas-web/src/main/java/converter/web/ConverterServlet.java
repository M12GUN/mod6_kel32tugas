package converter.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mycompany.mod6kel32tugas.ConverterBean;

@WebServlet(name = "ConverterServlet", urlPatterns = { "/ConverterServlet" })
public class ConverterServlet extends HttpServlet {

    private ConverterBean cb = new ConverterBean();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Temperature Converter</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Temperature Converter</h1>");

        try {
            String degree = request.getParameter("degree");

            if ((degree != null) && (degree.length() > 0)) {
                double d = Double.parseDouble(degree);

                if (request.getParameter("F TO K") != null) {
                    String kelvin = cb.ftok(d);
                    out.println("<p>" + degree + " Fahrenheit is " + kelvin + " Kelvin.</p>");
                }

                if (request.getParameter("K TO F") != null) {
                    String fahrenheit = cb.ktof(d);
                    out.println("<p>" + degree + " Kelvin is " + fahrenheit + " Fahrenheit.</p>");
                }

                // Add more conditions for other conversions if needed

            } else {
                out.println("<p>Enter degree to convert:</p>");
                out.println("<form method=\"get\">");
                out.println("<p> <input type=\"text\" name=\"degree\" size=\"25\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"F TO K\" value=\"F TO K\">"
                        + "<input type=\"submit\" name=\"K TO F\" value=\"K TO F\">");
                out.println("</form>");
            }
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
